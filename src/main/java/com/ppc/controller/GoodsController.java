package com.ppc.controller;

import com.ppc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/{id}")
    public String test(@PathVariable Integer id){
        return goodsService.getById(id).toString();
    }
}
