package com.itcrazy.alanmall.tomcat.dal.entitys;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_tomcat")
public class Tomcat implements Serializable {
    @Id
    private Long id;

    private Integer num;

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
     * @return num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
    }
}