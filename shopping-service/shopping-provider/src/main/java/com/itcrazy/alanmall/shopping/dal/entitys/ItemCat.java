package com.itcrazy.alanmall.shopping.dal.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_item_cat")
public class ItemCat implements Serializable {
    /**
     * 类目ID
     */
    @Id
    private Long id;

    /**
     * 父分类ID=0时代表一级根分类
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 状态 1启用 0禁用
     */
    private Integer status;

    /**
     * 排列序号
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 是否为父分类 1为true 0为false
     */
    @Column(name = "is_parent")
    private Boolean isParent;

    /**
     * 图标
     */
    private String icon;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    private static final long serialVersionUID = 1L;

    /**
     * 获取类目ID
     *
     * @return id - 类目ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置类目ID
     *
     * @param id 类目ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取父分类ID=0时代表一级根分类
     *
     * @return parent_id - 父分类ID=0时代表一级根分类
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父分类ID=0时代表一级根分类
     *
     * @param parentId 父分类ID=0时代表一级根分类
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取状态 1启用 0禁用
     *
     * @return status - 状态 1启用 0禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 1启用 0禁用
     *
     * @param status 状态 1启用 0禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取排列序号
     *
     * @return sort_order - 排列序号
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 设置排列序号
     *
     * @param sortOrder 排列序号
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取是否为父分类 1为true 0为false
     *
     * @return is_parent - 是否为父分类 1为true 0为false
     */
    public Boolean getIsParent() {
        return isParent;
    }

    /**
     * 设置是否为父分类 1为true 0为false
     *
     * @param isParent 是否为父分类 1为true 0为false
     */
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
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
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取更新时间
     *
     * @return updated - 更新时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置更新时间
     *
     * @param updated 更新时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}