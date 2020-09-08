package com.itcrazy.alanmall.user.dao;

import java.util.List;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.user.carddto.RoleHandleDto;
import com.itcrazy.alanmall.user.model.RoleHandle;
import org.springframework.stereotype.Component;

@Component
public interface RoleHandleDao extends BaseDao<RoleHandle, Long> {
  List<RoleHandle> getPageList(RoleHandleDto paramRoleHandleDto);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\dao\RoleHandleDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */