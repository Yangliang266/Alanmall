package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.BannerDto;
import com.itcrazy.alanmall.merchant.model.Banner;
import java.util.List;

public interface BannerManager {
  Banner addBanner(Banner paramBanner);
  
  Banner getBannerById(Long paramLong);
  
  int updateBanner(Banner paramBanner);
  
  List<Banner> getPageList(BannerDto paramBannerDto);
  
  int getPageTotal(BannerDto paramBannerDto);
  
  int deleteBannerById(Long paramLong1, Long paramLong2);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\BannerManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */