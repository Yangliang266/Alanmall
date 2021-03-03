package com.itcrazy.alanmall.mscard.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CardCategory {
    private Integer id;

    private String name;

    private String bin;

    private Integer isNamed;

    private BigDecimal rechargeQuota;

    private Integer isPswMust;

    private Integer isRecharge;

    private Integer rechargeCount;

    private Integer isCredit;

    private BigDecimal discount;

    private Integer status;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private Integer isDeleted;

    private Long companyId;

    private String cities;

    private String brands;

    private String stores;

    private String allJoinBrands;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin == null ? null : bin.trim();
    }

    public Integer getIsNamed() {
        return isNamed;
    }

    public void setIsNamed(Integer isNamed) {
        this.isNamed = isNamed;
    }

    public BigDecimal getRechargeQuota() {
        return rechargeQuota;
    }

    public void setRechargeQuota(BigDecimal rechargeQuota) {
        this.rechargeQuota = rechargeQuota;
    }

    public Integer getIsPswMust() {
        return isPswMust;
    }

    public void setIsPswMust(Integer isPswMust) {
        this.isPswMust = isPswMust;
    }

    public Integer getIsRecharge() {
        return isRecharge;
    }

    public void setIsRecharge(Integer isRecharge) {
        this.isRecharge = isRecharge;
    }

    public Integer getRechargeCount() {
        return rechargeCount;
    }

    public void setRechargeCount(Integer rechargeCount) {
        this.rechargeCount = rechargeCount;
    }

    public Integer getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(Integer isCredit) {
        this.isCredit = isCredit;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities == null ? null : cities.trim();
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands == null ? null : brands.trim();
    }

    public String getStores() {
        return stores;
    }

    public void setStores(String stores) {
        this.stores = stores == null ? null : stores.trim();
    }

    public String getAllJoinBrands() {
        return allJoinBrands;
    }

    public void setAllJoinBrands(String allJoinBrands) {
        this.allJoinBrands = allJoinBrands == null ? null : allJoinBrands.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}