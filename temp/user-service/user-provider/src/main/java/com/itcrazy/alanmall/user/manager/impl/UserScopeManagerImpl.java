package com.itcrazy.alanmall.user.manager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itcrazy.alanmall.common.framework.model.BaseModel;
import com.itcrazy.alanmall.user.carddto.UserScopeDto;
import com.itcrazy.alanmall.user.dao.UserScopeDao;
import com.itcrazy.alanmall.user.manager.UserScopeManager;
import com.itcrazy.alanmall.user.model.UserScope;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

//@Service(protocol = {"dubbo"}, version = "1.0.0", timeout = 10000)
@Service
public class UserScopeManagerImpl implements UserScopeManager {
    @Autowired
    private UserScopeDao userScopeDao;

    public List<UserScope> getPageList(UserScopeDto dto) {
        return this.userScopeDao.getPageList(dto);
    }

    public Map<String, UserScope> storeIdMap(Long userId) {
        UserScopeDto dto = new UserScopeDto();
        dto.setUserId(userId);
        List<UserScope> usList = this.userScopeDao.getPageList(dto);
        if (usList == null) {
            return null;
        }
        Map<String, UserScope> m = new HashMap<>(usList.size());

        for (UserScope us : usList) {
            m.put(us.getBrandId() + "_" + us.getStoreId(), us);
        }
        return m;
    }


    public void saveBatch(List<UserScope> usList) {
        if (usList == null || usList.size() < 1) {
            return;
        }
        this.userScopeDao.saveBatch(usList);
    }

    public int removeUserScope(UserScope userScope) {
        return this.userScopeDao.remove(userScope);
    }
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\manager\impl\UserScopeManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */