package com.itcrazy.alanmall.user.dao;

import java.util.List;
import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.user.carddto.UserDto;
import com.itcrazy.alanmall.user.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends BaseDao<User, Long> {
  List<User> getPageList(UserDto paramUserDto);
  
  Integer getPageTotal(UserDto paramUserDto);
  
  User checkUser(UserDto paramUserDto);
  
  User getUserByWechatUserId(Long paramLong);
  
  User getUserByRewardWechatUserId(Long paramLong);
  
  int update(User paramUser);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\dao\UserDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */