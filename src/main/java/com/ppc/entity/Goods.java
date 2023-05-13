package com.ppc.entity;

import lombok.Data;

@Data

public class Goods {
    private Integer goodsId;
    private String goodsCode;
    private String goodsName;
    private Double inPrice;
    private Double salePrice;
    private Integer goodsQuantity;
    private Integer deleted;

    private Integer count;
    private String username;


}
