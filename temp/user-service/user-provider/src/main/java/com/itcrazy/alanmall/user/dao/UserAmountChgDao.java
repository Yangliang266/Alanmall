package com.itcrazy.alanmall.user.dao;

import java.util.List;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.user.carddto.UserAmountChgDto;
import com.itcrazy.alanmall.user.model.UserAmountChg;
import org.springframework.stereotype.Component;

@Component
public interface UserAmountChgDao extends BaseDao<UserAmountChg, Long> {
  UserAmountChg getMemberAmountChgByPayCode(String paramString);
  
  List<UserAmountChg> getPageList(UserAmountChgDto paramUserAmountChgDto);
  
  Integer getPageTotal(UserAmountChgDto paramUserAmountChgDto);
  
  List<String> getMonthList(UserAmountChgDto paramUserAmountChgDto);
  
  Integer getMonthTotal(UserAmountChgDto paramUserAmountChgDto);
  
  Integer getRewardUserNum(UserAmountChgDto paramUserAmountChgDto);
  
  Double getRewardAmount(UserAmountChgDto paramUserAmountChgDto);
  
  Integer getUserRank(UserAmountChgDto paramUserAmountChgDto);
  
  List<UserAmountChg> getPageListForSort(UserAmountChgDto paramUserAmountChgDto);
  
  Integer getPageTotalForSort(UserAmountChgDto paramUserAmountChgDto);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\dao\UserAmountChgDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */