package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.model.CustomReturnHistory;
import org.springframework.stereotype.Component;

/**
 * 退卡Dao层接口
 * @author yangliang
 * 2018-09-15
 */
@Component
public interface CustomReturnHistoryDao extends BaseDao<CustomReturnHistory, Long> {
	// custom_return_history
	public int insertCustomReturnHistory(CustomReturnHistory customReturnHistory);

}
