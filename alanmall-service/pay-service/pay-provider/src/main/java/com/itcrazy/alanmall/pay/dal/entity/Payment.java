package com.itcrazy.alanmall.pay.dal.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_payment")
public class Payment implements Serializable {
    @Id
    private Integer id;

    /**
     * 支付状态
     */
    private String status;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 第三方返回单号
     */
    @Column(name = "pay_no")
    private String payNo;

    /**
     * 支付流水号
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 付款人id
     */
    @Column(name = "payer_uid")
    private Long payerUid;

    /**
     * 付款人姓名
     */
    @Column(name = "payer_name")
    private String payerName;

    /**
     * 付款方支付金额
     */
    @Column(name = "payer_amount")
    private BigDecimal payerAmount;

    /**
     * 订单金额
     */
    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    /**
     * 支付方式
     */
    @Column(name = "pay_way")
    private String payWay;

    /**
     * 支付成功时间
     */
    @Column(name = "pay_success_time")
    private Date paySuccessTime;

    /**
     * 支付完成时间
     */
    @Column(name = "complete_time")
    private Date completeTime;

    /**
     * 备注
     */
    private String remark;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取支付状态
     *
     * @return status - 支付状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置支付状态
     *
     * @param status 支付状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取第三方返回单号
     *
     * @return pay_no - 第三方返回单号
     */
    public String getPayNo() {
        return payNo;
    }

    /**
     * 设置第三方返回单号
     *
     * @param payNo 第三方返回单号
     */
    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    /**
     * 获取支付流水号
     *
     * @return trade_no - 支付流水号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置支付流水号
     *
     * @param tradeNo 支付流水号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    /**
     * 获取付款人id
     *
     * @return payer_uid - 付款人id
     */
    public Long getPayerUid() {
        return payerUid;
    }

    /**
     * 设置付款人id
     *
     * @param payerUid 付款人id
     */
    public void setPayerUid(Long payerUid) {
        this.payerUid = payerUid;
    }

    /**
     * 获取付款人姓名
     *
     * @return payer_name - 付款人姓名
     */
    public String getPayerName() {
        return payerName;
    }

    /**
     * 设置付款人姓名
     *
     * @param payerName 付款人姓名
     */
    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    /**
     * 获取付款方支付金额
     *
     * @return payer_amount - 付款方支付金额
     */
    public BigDecimal getPayerAmount() {
        return payerAmount;
    }

    /**
     * 设置付款方支付金额
     *
     * @param payerAmount 付款方支付金额
     */
    public void setPayerAmount(BigDecimal payerAmount) {
        this.payerAmount = payerAmount;
    }

    /**
     * 获取订单金额
     *
     * @return order_amount - 订单金额
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置订单金额
     *
     * @param orderAmount 订单金额
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取支付方式
     *
     * @return pay_way - 支付方式
     */
    public String getPayWay() {
        return payWay;
    }

    /**
     * 设置支付方式
     *
     * @param payWay 支付方式
     */
    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    /**
     * 获取支付成功时间
     *
     * @return pay_success_time - 支付成功时间
     */
    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    /**
     * 设置支付成功时间
     *
     * @param paySuccessTime 支付成功时间
     */
    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    /**
     * 获取支付完成时间
     *
     * @return complete_time - 支付完成时间
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * 设置支付完成时间
     *
     * @param completeTime 支付完成时间
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}