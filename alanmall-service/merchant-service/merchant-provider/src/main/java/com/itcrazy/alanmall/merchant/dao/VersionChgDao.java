package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.VersionChgDto;
import com.itcrazy.alanmall.merchant.model.VersionChg;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface VersionChgDao extends BaseDao<VersionChg, Long> {
  VersionChg getVersionChgByDto(VersionChgDto paramVersionChgDto);
  
  List<VersionChg> getPageList(VersionChgDto paramVersionChgDto);
  
  Integer getPageTotal(VersionChgDto paramVersionChgDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\VersionChgDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */