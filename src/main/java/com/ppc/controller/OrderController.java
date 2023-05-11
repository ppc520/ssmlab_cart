package com.ppc.controller;

import com.ppc.common.result.Result;
import com.ppc.entity.Order;
import com.ppc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/getAll")
    public Result getAll(){
        List<Order> orderList = orderService.getAll();
        if (orderList!=null){
            return Result.ok(orderList);
        }return Result.fail();
    }
}
