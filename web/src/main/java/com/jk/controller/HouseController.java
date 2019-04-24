package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.pojo.HouseBean;
import com.jk.pojo.HouseCat;
import com.jk.service.HouseService;
import com.jk.utiles.ConstantUtil;
import net.minidev.json.JSONObject;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("house")
public class HouseController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("toHouse")
    public String toHouse(){
        return "house";
    }

    @RequestMapping("junmpspxq")
    public String junmpspxq( Integer  id, Model model){
        model.addAttribute("id",id);
        return  "xiangqing";
    }

    @RequestMapping("toXiangqing")
    public String toXiangqing(){
        return "xiangqing";
    }

    @RequestMapping("queryProduct")
    @ResponseBody
    public JSONObject queryProduct(Integer page, Integer rows, HouseBean shop){
        JSONObject result = new JSONObject();
        Client client = elasticsearchTemplate.getClient();
        Integer startIndex = rows*(page-1);
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("house").setTypes("dom");
        if(shop.getInfo() !=null && shop.getInfo() != "" ){
            searchRequestBuilder.setQuery(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("info", shop.getInfo())));
        }
     if(shop.getStartPrice() !=null){
            searchRequestBuilder.setQuery(QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery("price").gte(shop.getStartPrice())));
        }
        if(shop.getEndPrice() !=null){
            searchRequestBuilder.setQuery(QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery("price").lte(shop.getEndPrice())));
        }
        searchRequestBuilder.setFrom(startIndex).setSize(rows);
        searchRequestBuilder.setExplain(true);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("info");
        highlightBuilder.preTags("<font color='red' >");
        highlightBuilder.postTags("</font>");
        searchRequestBuilder.highlighter(highlightBuilder);
        SearchResponse searchResponse = searchRequestBuilder.get();
        SearchHits hits = searchResponse.getHits();
        long total = hits.getTotalHits();
        Iterator<SearchHit> iterator = hits.iterator();
        List<HouseBean> list = new ArrayList<HouseBean>();
        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            Map<String, HighlightField> highlightFields = next.getHighlightFields();
            String sourceAsString = next.getSourceAsString();
            HighlightField info = highlightFields.get("info");
            HouseBean shopBean = JSON.parseObject(sourceAsString, HouseBean.class);
            //取得定义的高亮标签
            if(info !=null) {
                Text[] fragments = info.fragments();
                //为thinkName（相应字段）增加自定义的高亮标签
                String title = "";
                for (Text text1 : fragments) {
                    title += text1;
                }
                shopBean.setInfo(title);
            }
            list.add(shopBean);
        }
        result.put("total",total);
        result.put("rows",list);
        return result;
    }
    @RequestMapping("queryDrugBeanByIds")
    @ResponseBody
    public HouseBean queryDrugBeanByIds(Integer ids){
        Client client = elasticsearchTemplate.getClient();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("house").setTypes("dom");
        searchRequestBuilder.setQuery(QueryBuilders.matchQuery("id",ids));
        SearchResponse searchResponse = searchRequestBuilder.get();
        SearchHits hits = searchResponse.getHits();
        Iterator<SearchHit> iterator = hits.iterator();
        SearchHit next = iterator.next();
        String sourceAsString = next.getSourceAsString();
        HouseBean shopBean = JSON.parseObject(sourceAsString, HouseBean.class);
        return shopBean;
    }


    @PostMapping("queryDrugBeanById")
    @ResponseBody
    public HouseBean queryDrugBeanById(@RequestParam("ids") String ids){
        return houseService.queryDrugBeanById(ids);
    }

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("send")
    @ResponseBody
    public void send(Integer id){
        amqpTemplate.convertAndSend("deleteHouse",id);
    }

    @RabbitListener(queues = "deleteHouse")
    public void deleteHouse(Integer id){
        System.out.println(id);
    }



    //新增购物车
    @RequestMapping("addHouse")
    @ResponseBody
    public void addHouse(Integer id){
        Map<String, Integer> map = new HashMap<>();
        map.put("id",id);

        amqpTemplate.convertAndSend("queryHouse", map);
    }
    //删除
    @DeleteMapping("deleteHouse")
    @ResponseBody
    public void deleteHouse(Integer[] ids){
        amqpTemplate.convertAndSend("deleteHouse", ids);
    }
@Autowired
private HouseService houseService;
//购物车查询
    @RequestMapping("queryHouseCat")
    @ResponseBody
    public List<HouseCat> queryHouseCat(){
        return houseService.queryHouseCat();
    }
}
