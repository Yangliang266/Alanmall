package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.BrandUnionDto;
import com.itcrazy.alanmall.merchant.model.BrandUnion;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface BrandUnionDao extends BaseDao<BrandUnion, Long> {
  BrandUnion getBySrcDstId(BrandUnion paramBrandUnion);
  
  List<BrandUnion> getPageList(BrandUnionDto paramBrandUnionDto);
  
  Integer getPageTotal(BrandUnionDto paramBrandUnionDto);
  
  List<BrandUnion> getPageListBySrcId(BrandUnionDto paramBrandUnionDto);
  
  Integer getPageTotalBySrcId(BrandUnionDto paramBrandUnionDto);
  
  List<BrandUnion> getBrandUnionList(BrandUnion paramBrandUnion);
  
  BrandUnion getBrandUnionBySrcAndDst(BrandUnion paramBrandUnion);
  
  Integer getUnionTotal(BrandUnionDto paramBrandUnionDto);
  
  Integer getBindTotal(BrandUnionDto paramBrandUnionDto);
  
  List<BrandUnion> getRecmdBrandUnionList(BrandUnion paramBrandUnion);
  
  List<BrandUnion> getNextRecmdBrandUnionList(BrandUnion paramBrandUnion);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\BrandUnionDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */