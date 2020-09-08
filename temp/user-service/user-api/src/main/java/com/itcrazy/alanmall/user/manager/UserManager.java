package com.itcrazy.alanmall.user.manager;

import com.itcrazy.alanmall.user.carddto.UserDto;
import com.itcrazy.alanmall.user.model.User;

import java.util.List;

public interface UserManager {
  User addUser(User paramUser);
  
  int updateUser(User paramUser);
  
  User getUserById(Long paramLong);
  
  User getUserByLoginName(String paramString);
  
  User getUserByWechatUserId(Long paramLong);
  
  User getUserByRewardWechatUserId(Long paramLong);
  
  List<User> getPageList(UserDto paramUserDto);
  
  Integer getPageTotal(UserDto paramUserDto);
  
  int removeUser(User paramUser);
  
  User getUserBySourceCode(Integer paramInteger, String paramString, Long paramLong);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\manager\UserManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */