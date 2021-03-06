package com.itcrazy.alanmall.user.service;

import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.user.converter.*;
import com.itcrazy.alanmall.user.dal.mapper.MemberMapper;
import com.itcrazy.alanmall.user.dto.UserLoginRequest;
import com.itcrazy.alanmall.user.dto.UserLoginResponse;
import com.itcrazy.alanmall.user.inter.IUserLoginService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author mathyoung
 * @Description
 * @ClassName UserImp
 * @date 2020/7/8 15:47
 */
@Service
public class UserLoginImp implements IUserLoginService {
    @Autowired
    MemberMapper memberMapper;
//
    @Autowired
    UserConverter userConverer;

    @Autowired
    RedissonConfig redissonConfig;

    /**
     * @return com.itcrazy.alanmall.user.dto.UserLoginResponse
     * @Description
     * @Param [userLoginRequest]
     * @Author Mathyoung
     * @Date 2020.07.08 15:49
     **/
    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
//        // 检查参数
//        userLoginRequest.requestCheck();
//
//        // redis查询
//        String json = cacheManager.checkCache("hello");
//        Member member = new Member();
//
//        if (StringUtils.isNotBlank(json)) {
//            member = JSON.parseObject(json,Member.class);
//        } else {
//            // 根据id查询
//            member = memberMapper.selectByPrimaryKey(userLoginRequest.getId());
//            // 设置到cache
//            cacheManager.setCache("hello", "hello world", 60000);
//        }
//
//        // dto转换
//        UserLoginResponse userLoginResponse = userConverer.login(member);
//
//        return userLoginResponse;
        return null;
    }

    @Override
    public String jedisTest() {
        redissonConfig.setCache("redis","redis1235678",1000);
//
        return redissonConfig.getCache("redis");
//        return "hello";
    }

    @Override
    public void redissonTest() {
////        cacheManager.setCache("alanmall", "hello world 1", 60000);
//        cacheManager.setMapCache("123","123","no1",60000);
//
//        if (cacheManager.checkMapHashCache("123","123","no1")) {
//            System.out.println("hash 已经存入 redis");
//            return;
//        }
//
//        System.out.println("hash 未存入 redis");
    }
}
