package com.ppc.entity;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private Double balance;
    private Integer deleted;
}
