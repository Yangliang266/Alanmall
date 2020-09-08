package com.itcrazy.alanmall.user.manager;

import com.itcrazy.alanmall.user.carddto.UserAmountChgDto;
import com.itcrazy.alanmall.user.model.UserAmountChg;

import java.util.List;

public interface UserAmountChgManager {
  UserAmountChg addUserAmountChg(UserAmountChg paramUserAmountChg);
  
  int updateUserAmountChg(UserAmountChg paramUserAmountChg);
  
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


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\manager\UserAmountChgManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */