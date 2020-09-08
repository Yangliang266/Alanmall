package com.itcrazy.alanmall.user.manager.impl;

import java.util.List;

import com.itcrazy.alanmall.common.framework.model.BaseModel;
import com.itcrazy.alanmall.user.carddto.UserDto;
import com.itcrazy.alanmall.user.dao.UserDao;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;
import com.itcrazy.alanmall.user.model.UserScope;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


//@Service(protocol = {"dubbo"}, version = "1.0.0", timeout = 10000)
@Service
public class UserManagerImpl
        implements UserManager {
    @Autowired
    private UserDao userDao;

    public List<User> getPageList(UserDto userDto) {
        return this.userDao.getPageList(userDto);
    }


    public Integer getPageTotal(UserDto userDto) {
        return this.userDao.getPageTotal(userDto);
    }


    public User getUserByLoginName(String loginName) {
        if (loginName == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setLoginName(loginName);
        dto.setOfficeAreaIds("1,2");
        List<User> cuList = this.userDao.getPageList(dto);
        if (cuList != null && cuList.size() == 1) {
            return cuList.get(0);
        }
        return null;
    }

    public User getUserByWechatUserId(Long wechatUserId) {
        return this.userDao.getUserByWechatUserId(wechatUserId);
    }


    public User getUserByRewardWechatUserId(Long rewardWechatUserId) {
        return this.userDao.getUserByRewardWechatUserId(rewardWechatUserId);
    }


    public User addUser(User user) {
        this.userDao.save(user);
        return user;
    }


    public int updateUser(User user) {
        return this.userDao.update(user);
    }


    public User getUserById(Long id) {
        return (User) this.userDao.get(id);
    }

    public int removeUser(User user) {
        UserScope uru = new UserScope();
        uru.setUserId(user.getId());
        uru.setUpdateId(user.getUpdateId());
        return this.userDao.remove(user);
    }


    public User getAdminUser(Long companyId) {
        UserDto dto = new UserDto();
        dto.setCompanyId(companyId);
        List<User> cuList = this.userDao.getPageList(dto);
        if (cuList != null && cuList.size() > 0) {
            return cuList.get(0);
        }
        return null;
    }

    public User getUserBySourceCode(Integer source, String sourceCode, Long companyId) {
        UserDto dto = new UserDto();
        dto.setSource(source);
        dto.setCompanyId(companyId);
        dto.setSourceCode(sourceCode);
        List<User> cuList = this.userDao.getPageList(dto);
        if (cuList != null && cuList.size() > 0) {
            return cuList.get(0);
        }
        return null;
    }
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\manager\impl\UserManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */