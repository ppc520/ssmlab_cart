package com.ppc.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Order {
    private Integer orderId;
    private Date createTime;
    private String userName;
    private Double originPrice;
    private Double diccount;
    private Double paidMoney;
    private Integer deleted;
}
