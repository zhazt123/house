package com.jk.service;

import com.jk.pojo.HouseBean;
import com.jk.pojo.HouseCat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("house-service")
public interface HouseService {

    @RequestMapping("queryHouseCat")
    List<HouseCat> queryHouseCat();

    @RequestMapping("queryDrugBeanById")
    HouseBean queryDrugBeanById(@RequestParam("ids") String ids);
}
