package com.itcrazy.alanmall.mscard.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CreditSalesHistory {
    private String id;

    private String cardNo;

    private String motherCardNo;

    private Integer motherType;

    private Long releaseStore;

    private Date consumeTime;

    private Long store;

    private BigDecimal bill;

    private BigDecimal creditBill;

    private BigDecimal clearBill;

    private BigDecimal credit;

    private Integer status;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private Integer isDeleted;

    private Long companyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
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

    public Long getReleaseStore() {
        return releaseStore;
    }

    public void setReleaseStore(Long releaseStore) {
        this.releaseStore = releaseStore;
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Long getStore() {
        return store;
    }

    public void setStore(Long store) {
        this.store = store;
    }

    public BigDecimal getBill() {
        return bill;
    }

    public void setBill(BigDecimal bill) {
        this.bill = bill;
    }

    public BigDecimal getCreditBill() {
        return creditBill;
    }

    public void setCreditBill(BigDecimal creditBill) {
        this.creditBill = creditBill;
    }

    public BigDecimal getClearBill() {
        return clearBill;
    }

    public void setClearBill(BigDecimal clearBill) {
        this.clearBill = clearBill;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
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
}