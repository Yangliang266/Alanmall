package com.itcrazy.alanmall.common.framework.dao;


import com.itcrazy.alanmall.common.framework.model.BaseModel;

import java.io.Serializable;

/**
 * dao层接口公共方法
 * 
 * @author DDD
 * 
 */
public interface BaseDao<T extends BaseModel, PK extends Serializable> {

	/**
	 * 保存方法
	 * 
	 * @param object
	 * @return 返回对应保存记录1为保存成功,0为没有保存
	 */
	int save(T object);

	/**
	 * 根据主键id查询对应记录
	 * 
	 * @param id
	 * @return
	 */
	T get(PK id);

	/**
	 * 更新记录,
	 * 
	 * @param object
	 * @return
	 */
	int update(T object);

	/**
	 * 删除记录
	 * 
	 * @param object
	 * @return
	 */
	int remove(T object);

}