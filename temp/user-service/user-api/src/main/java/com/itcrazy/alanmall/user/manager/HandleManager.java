package com.itcrazy.alanmall.user.manager;

import com.itcrazy.alanmall.user.model.Handle;

import java.util.List;

public interface HandleManager {
  List<Handle> getListBySystemId(Integer paramInteger);
  
  List<Handle> getListByModuleId(Long paramLong);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\manager\HandleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */