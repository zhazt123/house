package com.jk.controller;

import com.alibaba.fastjson.JSONArray;
import com.jk.mapper.HouseMapper;
import com.jk.pojo.HouseBean;
import com.jk.pojo.HouseCat;
import com.jk.pojo.HouseInfo;
import com.jk.service.HouseService;
import com.jk.utiles.ConstantUtil;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class HouseServiceController implements HouseService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RabbitListener(queues = "deleteHouse")
    //@Async
    public void deleteHouse(Integer[] ids){
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(1));

        HouseInfo one = mongoTemplate.findOne(query, HouseInfo.class);
        JSONArray json = one.getUserInfo();
        if(json.size()==ids.length){
            mongoTemplate.remove(one);
        }else {

        }
    }
    @RabbitListener(queues = "queryHouse")
    //@Async
    public void queryHouse (Map<String,Integer> map){
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(1));
        HouseInfo one = mongoTemplate.findOne(query, HouseInfo.class);
        if(one==null){
            HouseInfo houseInfo = new HouseInfo();
            houseInfo.setUserId(1);
            JSONArray userInfo = new JSONArray();
            JSONArray arr = new JSONArray();
            arr.add(0,map.get("id"));
            arr.add(1,map.get("count"));
            //arr.add(2,map.get("shopId"));
            userInfo.add(arr);
            houseInfo.setUserInfo(userInfo);
            mongoTemplate.save(houseInfo);
        }else{
            int num = 0;
            JSONArray json = one.getUserInfo();
            for (int i=0;i<json.size();i++){
                JSONArray jsonArray = json.getJSONArray(i);
                if(jsonArray.get(0).equals(map.get("id"))){
                    num++;
                   // Integer sum = jsonArray.getInteger(1);
                    //jsonArray.set(1,sum+map.get("count"));
                    one.getUserInfo().set(i,jsonArray);
                }
            }
            if(num==0){
                JSONArray arr = new JSONArray();
                arr.add(0,map.get("id"));
                //arr.add(1,map.get("count"));
                //arr.add(2,map.get("shopId"));
                one.getUserInfo().add(arr);
            }
            mongoTemplate.save(one);
        }
    }

    @Autowired
    private HouseMapper houseMapper;
    @Override
    @ResponseBody
    public List<HouseCat> queryHouseCat() {
        List<HouseCat> list = new ArrayList<HouseCat>();
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(1));
        HouseInfo one = mongoTemplate.findOne(query, HouseInfo.class);
        if(one !=null ) {
            JSONArray productInfo = one.getUserInfo();
            for (int i = 0; i < productInfo.size(); i++) {
                HouseCat product = new HouseCat();
                //获取商品id
                Integer productId = productInfo.getJSONArray(i).getInteger(0);
                String cacheKey = ConstantUtil.HOUSE_INFO_CACHE + productId;
                if (redisTemplate.hasKey(cacheKey)) {
                    product = (HouseCat) redisTemplate.opsForValue().get(cacheKey);
                } else {
                    product = houseMapper.queryHouseCat(productId);
                    redisTemplate.opsForValue().set(cacheKey, product);
                    redisTemplate.expire(cacheKey, 60, TimeUnit.DAYS);
                }
               // Integer count = productInfo.getJSONArray(i).getInteger(1);
                //product.setCount(count);
                list.add(product);
            }
        }
        return list;
    }

    @Override
    @ResponseBody
    public HouseBean queryDrugBeanById(@RequestParam("ids") String ids) {
        HouseBean list= new HouseBean();
        String cachekye= ConstantUtil.HOUSE_ID_CACHE+ids;
        Boolean hasKey = redisTemplate.hasKey(cachekye);
        if (hasKey) {
            System.out.println("走缓存");
            list = (HouseBean) redisTemplate.opsForValue().get(cachekye);
        } else {
            System.out.println("走数据库");
            list=houseMapper.queryHouse(ids);
            redisTemplate.opsForValue().set(cachekye, list);
            redisTemplate.expire(cachekye, 30, TimeUnit.DAYS);
        }
        return list;
    }
}
