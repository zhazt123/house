package com.jk.controller;

import com.alibaba.fastjson.JSONArray;
import com.jk.pojo.HouseBean;
import com.jk.service.HouseService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Controller
public class HouseServiceController implements HouseService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RabbitListener(queues = "deleteHouse")
    public void deleteShoppingCart(Integer[] ids){
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(1));

        HouseBean one = mongoTemplate.findOne(query, HouseBean.class);
        String info = one.getInfo();
        JSONArray json = one.getInfo();
        if(json.size()==ids.length){
            mongoTemplate.remove(one);
        }else {

        }
    }
}
