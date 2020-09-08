package com.itcrazy.alanmall.mscard.dal.entity;

import java.util.Date;

public class RechargeReward {
    private Integer id;

    private Integer rechargeMode;

    private String recharge;

    private Integer rewardMode;

    private Integer reward;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private Integer isDeleted;

    private Long companyId;

    private String cardCategories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRechargeMode() {
        return rechargeMode;
    }

    public void setRechargeMode(Integer rechargeMode) {
        this.rechargeMode = rechargeMode;
    }

    public String getRecharge() {
        return recharge;
    }

    public void setRecharge(String recharge) {
        this.recharge = recharge == null ? null : recharge.trim();
    }

    public Integer getRewardMode() {
        return rewardMode;
    }

    public void setRewardMode(Integer rewardMode) {
        this.rewardMode = rewardMode;
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCardCategories() {
        return cardCategories;
    }

    public void setCardCategories(String cardCategories) {
        this.cardCategories = cardCategories == null ? null : cardCategories.trim();
    }
}