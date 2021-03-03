package com.itcrazy.alanmall.mscard.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ActivedInformation {
    private String cardNo;

    private Long companyId;

    private String motherCardNo;

    private Integer motherType;

    private String serialNo;

    private Integer category;

    private Integer status;

    private Integer writeStatus;

    private Long store;

    private Integer creditStatus;

    private Integer creditMaxQuota;

    private BigDecimal rechargeBalance;

    private BigDecimal reward;

    private BigDecimal credit;

    private Date createTime;

    private Long createId;

    private Date publishTime;

    private Long publishId;

    private Date updateTime;

    private Long updateId;

    private Integer isDeleted;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getMotherCardNo() {
        return motherCardNo;
    }

    public void setMotherCardNo(String motherCardNo) {
        this.motherCardNo = motherCardNo == null ? null : motherCardNo.trim();
    }

    public Integer getMotherType() {
        return motherType;
    }

    public void setMotherType(Integer motherType) {
        this.motherType = motherType;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWriteStatus() {
        return writeStatus;
    }

    public void setWriteStatus(Integer writeStatus) {
        this.writeStatus = writeStatus;
    }

    public Long getStore() {
        return store;
    }

    public void setStore(Long store) {
        this.store = store;
    }

    public Integer getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(Integer creditStatus) {
        this.creditStatus = creditStatus;
    }

    public Integer getCreditMaxQuota() {
        return creditMaxQuota;
    }

    public void setCreditMaxQuota(Integer creditMaxQuota) {
        this.creditMaxQuota = creditMaxQuota;
    }

    public BigDecimal getRechargeBalance() {
        return rechargeBalance;
    }

    public void setRechargeBalance(BigDecimal rechargeBalance) {
        this.rechargeBalance = rechargeBalance;
    }

    public BigDecimal getReward() {
        return reward;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
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

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
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
}