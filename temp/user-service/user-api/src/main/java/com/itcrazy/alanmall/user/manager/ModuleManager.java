package com.itcrazy.alanmall.user.manager;

import com.itcrazy.alanmall.user.carddto.ModuleDto;
import com.itcrazy.alanmall.user.model.Module;

import java.util.List;
import java.util.Map;

public interface ModuleManager {
  Module getModule(Long paramLong);
  
  List<Module> getPageList(ModuleDto paramModuleDto);
  
  Map<Long, Module> getSystemModuleMap(Integer paramInteger);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\manager\ModuleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */