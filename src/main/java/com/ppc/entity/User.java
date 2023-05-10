package com.ppc.entity;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String username;
    private String password;
    private Double balance;
    private Integer deleted;
}
