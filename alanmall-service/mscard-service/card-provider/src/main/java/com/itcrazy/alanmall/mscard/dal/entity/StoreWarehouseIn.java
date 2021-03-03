package com.itcrazy.alanmall.mscard.dal.entity;

import java.util.Date;

public class StoreWarehouseIn {
    private String cardNo;

    private String receiptNo;

    private Long companyId;

    private String warehouseOutNo;

    private Long storeFrom;

    private Long storeTo;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private Integer isDeleted;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo == null ? null : receiptNo.trim();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getWarehouseOutNo() {
        return warehouseOutNo;
    }

    public void setWarehouseOutNo(String warehouseOutNo) {
        this.warehouseOutNo = warehouseOutNo == null ? null : warehouseOutNo.trim();
    }

    public Long getStoreFrom() {
        return storeFrom;
    }

    public void setStoreFrom(Long storeFrom) {
        this.storeFrom = storeFrom;
    }

    public Long getStoreTo() {
        return storeTo;
    }

    public void setStoreTo(Long storeTo) {
        this.storeTo = storeTo;
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
}