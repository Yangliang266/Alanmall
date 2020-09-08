package com.itcrazy.alanmall.user.manager;

import com.itcrazy.alanmall.user.model.Business;

import java.util.List;

public interface BusinessManager {
  Business getBusinessById(Long paramLong);
  
  List<Business> getBusinessList();
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\manager\BusinessManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */