package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.Province;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface ProvinceDao extends BaseDao<Province, Long> {
  Province getProvinceByCode(String paramString);
  
  Province getProvinceByName(String paramString);
  
  List<Province> getAll();
  
  List<Province> getProvinceByWechatConfigId(Long paramLong);
  
  List<Province> getProvinceForWangxiangyuan(String paramString);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\ProvinceDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */