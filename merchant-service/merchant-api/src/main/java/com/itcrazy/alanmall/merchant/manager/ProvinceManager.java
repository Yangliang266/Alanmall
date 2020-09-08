package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.model.Province;
import java.util.List;

public interface ProvinceManager {
  List<Province> getAllProvinceList();
  
  Province getProvinceByCode(String paramString);
  
  Province getProvinceById(Long paramLong);
  
  Province getProvinceByName(String paramString);
  
  String getProvinceName(Long paramLong);
  
  List<Province> getProvinceByWechatConfigId(Long paramLong);
  
  List<Province> getProvinceForWangxiangyuan(String paramString);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\ProvinceManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */