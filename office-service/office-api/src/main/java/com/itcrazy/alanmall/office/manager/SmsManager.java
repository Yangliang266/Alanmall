package com.itcrazy.alanmall.office.manager;

import com.itcrazy.alanmall.office.dto.SmsDto;
import com.itcrazy.alanmall.office.model.CustomerSmsVar;
import com.itcrazy.alanmall.office.model.MerchantSmsVar;
import com.itcrazy.alanmall.office.model.Sms;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface SmsManager {
  Sms addSms(Sms paramSms);
  
  Sms addInterfaceCustomerSms(CustomerSmsVar paramCustomerSmsVar) throws Exception;
  
  Sms addMerchantSms(MerchantSmsVar paramMerchantSmsVar);
  
  Sms addUNIFYValidCode(String paramString1, Integer paramInteger, String paramString2, String paramString3, String paramString4, BigDecimal paramBigDecimal, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addMemberConsuSMS(String paramString1, Integer paramInteger1, String paramString2, String paramString3, String paramString4, BigDecimal paramBigDecimal, Integer paramInteger2, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addMemberConsuMsg(String paramString1, String paramString2, String paramString3, BigDecimal paramBigDecimal1, String paramString4, BigDecimal paramBigDecimal2, Integer paramInteger, String paramString5, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addMemberConsuMsgByNotCard(String paramString1, String paramString2, String paramString3, BigDecimal paramBigDecimal1, String paramString4, BigDecimal paramBigDecimal2, Integer paramInteger, String paramString5, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addMemberConsuMsgBySoltCard(String paramString1, String paramString2, String paramString3, BigDecimal paramBigDecimal1, String paramString4, BigDecimal paramBigDecimal2, Integer paramInteger, String paramString5, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addMemberBrandRechargeMsg(String paramString1, String paramString2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, Long paramLong1, Long paramLong2, Long paramLong3) throws Exception;
  
  Sms addMemberRechargeMsg(String paramString1, String paramString2, String paramString3, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addMemberRechargeMsgBySoltCard(String paramString1, String paramString2, String paramString3, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addMemberBrandRechargeScoreMsg(String paramString1, String paramString2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, Integer paramInteger, Long paramLong1, Long paramLong2, Long paramLong3) throws Exception;
  
  Sms addMemberRechargeScoreMsg(String paramString1, String paramString2, String paramString3, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, Integer paramInteger, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addMemberRechargeScoreMsgBySoltCard(String paramString1, String paramString2, String paramString3, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, Integer paramInteger, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addMemberBindingValidCode(String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addMemberLoginValidCode(String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addMemberPwdValidCode(String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addCancelMemberRechargeMsg(String paramString1, String paramString2, String paramString3, BigDecimal paramBigDecimal, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addCancelMemberConsuMsg(String paramString1, String paramString2, String paramString3, BigDecimal paramBigDecimal, Integer paramInteger1, Integer paramInteger2, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addPhoneChangeBefore(String paramString1, String paramString2, String paramString3, Long paramLong1, Long paramLong2) throws Exception;
  
  Sms addPhoneChangeBeAfter(String paramString1, String paramString2, String paramString3, Long paramLong1, Long paramLong2) throws Exception;
  
  Sms addStoreMemberSMS(String paramString1, String paramString2, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms addWechatMemberSMS(String paramString1, String paramString2, String paramString3, Long paramLong1, Long paramLong2) throws Exception;
  
  Sms addPhoneLockSMS(String paramString1, String paramString2, String paramString3, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  Sms resetMshopPwdSMS(String paramString1, String paramString2, String paramString3, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) throws Exception;
  
  List<Sms> getSendSmsList();
  
  int deleteUnsendSmsBySourceId(Long paramLong1, Long paramLong2);
  
  int updateSmsStatusBySourceId(int paramInt, Long paramLong1, Long paramLong2, Integer paramInteger);
  
  void updateSendStatusSuccess(String paramString1, Integer paramInteger, String paramString2, String paramString3) throws Exception;
  
  void updateSendStatusFailure(Long paramLong, String paramString, Integer paramInteger1, Integer paramInteger2);
  
  void updateSendStatusProcess(Long paramLong, Integer paramInteger);
  
  void updateSendSmsCommit(Long paramLong, String paramString, Integer paramInteger);
  
  List<Sms> getPageList(SmsDto paramSmsDto);
  
  Integer getPageTotal(SmsDto paramSmsDto);
  
  Sms getSmsById(Long paramLong);
  
  int updateSms(Sms paramSms);
  
  int add4SmsDirectSendProm(List<String> paramList, Long paramLong1, String paramString, Date paramDate, Long paramLong2, Long paramLong3);
  
  Integer getSmsTotal(SmsDto paramSmsDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\manager\SmsManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */