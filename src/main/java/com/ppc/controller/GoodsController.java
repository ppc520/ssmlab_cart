package com.ppc.controller;

import com.ppc.common.result.Result;
import com.ppc.entity.Goods;
import com.ppc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/doBuy")
    public Result doBuy(@RequestBody Goods goods){
        System.out.println("goods = " + goods);
        boolean flag=goodsService.doBuy(goods);
        return flag?Result.ok():Result.fail();
    }
}
