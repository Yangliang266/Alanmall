package com.itcrazy.alanmall.order.dal.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_mq_message")
public class MqMessage implements Serializable {
    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "msg_id")
    private Long msgId;

    private String exchange;

    private String queue;

    private Integer status;

    private Date created;

    private Date updated;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @param msgId
     */
    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    /**
     * @return msgId
     */
    public Long getMsgId() {
        return msgId;
    }


    /**
     * @return exchange
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * @param exchange
     */
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * @return queue
     */
    public String getQueue() {
        return queue;
    }

    /**
     * @param queue
     */
    public void setQueue(String queue) {
        this.queue = queue;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}