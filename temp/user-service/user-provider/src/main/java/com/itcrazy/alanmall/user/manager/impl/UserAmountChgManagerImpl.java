 package com.itcrazy.alanmall.user.manager.impl;

 import java.util.List;
 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.user.carddto.UserAmountChgDto;
 import com.itcrazy.alanmall.user.dao.UserAmountChgDao;
 import com.itcrazy.alanmall.user.manager.UserAmountChgManager;
 import com.itcrazy.alanmall.user.model.UserAmountChg;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;

// @Service(protocol = {"dubbo"}, version = "1.0.0", timeout = 10000)
@Service
 public class UserAmountChgManagerImpl
   implements UserAmountChgManager {
   @Autowired
   private UserAmountChgDao userAmountChgDao;

   public UserAmountChg addUserAmountChg(UserAmountChg userAmountChg) {
/* 19 */     if (this.userAmountChgDao.save(userAmountChg) > 0) {
/* 20 */       return userAmountChg;
     }

/* 23 */     return null;
   }


   public int updateUserAmountChg(UserAmountChg userAmountChg) {
/* 28 */     return this.userAmountChgDao.update(userAmountChg);
   }


   public UserAmountChg getMemberAmountChgByPayCode(String payCode) {
/* 33 */     return this.userAmountChgDao.getMemberAmountChgByPayCode(payCode);
   }


   public List<UserAmountChg> getPageList(UserAmountChgDto userAmountChgDto) {
/* 38 */     return this.userAmountChgDao.getPageList(userAmountChgDto);
   }


   public Integer getPageTotal(UserAmountChgDto userAmountChgDto) {
/* 43 */     return this.userAmountChgDao.getPageTotal(userAmountChgDto);
   }


   public List<String> getMonthList(UserAmountChgDto userAmountChgDto) {
/* 48 */     return this.userAmountChgDao.getMonthList(userAmountChgDto);
   }


   public Integer getMonthTotal(UserAmountChgDto userAmountChgDto) {
/* 53 */     return this.userAmountChgDao.getMonthTotal(userAmountChgDto);
   }


   public Integer getRewardUserNum(UserAmountChgDto userAmountChgDto) {
/* 58 */     return this.userAmountChgDao.getRewardUserNum(userAmountChgDto);
   }


   public Double getRewardAmount(UserAmountChgDto userAmountChgDto) {
/* 63 */     return this.userAmountChgDao.getRewardAmount(userAmountChgDto);
   }


   public Integer getUserRank(UserAmountChgDto userAmountChgDto) {
/* 68 */     return this.userAmountChgDao.getUserRank(userAmountChgDto);
   }



   public List<UserAmountChg> getPageListForSort(UserAmountChgDto userAmountChgDto) {
/* 74 */     return this.userAmountChgDao.getPageListForSort(userAmountChgDto);
   }


   public Integer getPageTotalForSort(UserAmountChgDto userAmountChgDto) {
/* 79 */     return this.userAmountChgDao.getPageTotalForSort(userAmountChgDto);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\manager\impl\UserAmountChgManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */