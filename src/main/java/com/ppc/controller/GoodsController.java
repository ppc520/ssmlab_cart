package com.ppc.controller;

import com.ppc.common.result.Result;
import com.ppc.entity.Goods;
import com.ppc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @GetMapping("/getAll")
    public Result getAll(){
        List<Goods> goodsList = goodsService.getAll();
        if (goodsList!=null){
            for (Goods goods : goodsList) {
                System.out.println("goods = " + goods);
            }
            return Result.ok(goodsList);
        }return Result.fail();
    }
}
