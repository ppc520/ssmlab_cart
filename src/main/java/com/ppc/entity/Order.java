package com.ppc.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Order {
    private Integer orderId;
    private Date createTime;
    private String username;
    private Double originPrice;
    private Double discount;
    private Double paidMoney;
    private Integer deleted;
}
