package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.BannerDto;
import com.itcrazy.alanmall.merchant.model.Banner;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface BannerDao extends BaseDao<Banner, Long> {
  List<Banner> getPageList(BannerDto paramBannerDto);
  
  int getPageTotal(BannerDto paramBannerDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\BannerDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */