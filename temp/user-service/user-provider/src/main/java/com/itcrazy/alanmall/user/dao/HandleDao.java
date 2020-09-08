package com.itcrazy.alanmall.user.dao;

import java.util.List;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.user.carddto.HandleDto;
import com.itcrazy.alanmall.user.model.Handle;
import org.springframework.stereotype.Component;

@Component
public interface HandleDao extends BaseDao<Handle, Long> {
  List<Handle> getPageList(HandleDto paramHandleDto);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\dao\HandleDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */