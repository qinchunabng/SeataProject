package com.qin.common.domain.dto;

public class AccountTblDTO {
    /**
     *  
     */
    private Integer id;

    /**
     *  用户ID
     */
    private String userId;

    /**
     *  余额
     */
    private Integer money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}