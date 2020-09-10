package com.itcrazy.alanmall.user.service;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;
import com.itcrazy.alanmall.user.converter.*;
import com.itcrazy.alanmall.user.dal.entity.Member;
import com.itcrazy.alanmall.user.dal.mapper.MemberMapper;
import com.itcrazy.alanmall.user.dto.UserLoginRequest;
import com.itcrazy.alanmall.user.dto.UserLoginResponse;
import com.itcrazy.alanmall.user.IUserLoginService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author mathyoung
 * @Description
 * @ClassName UserImp
 * @date 2020/7/8 15:47
 */
@Service
@Slf4j
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
        // 输出日志
        log.info("Begin UserLoginServiceImpl.login: request:" + userLoginRequest);

        UserLoginResponse userLoginResponse = new UserLoginResponse();

        try {
            // 检查参数
            userLoginRequest.requestCheck();
            // 设置查询条件
            Example example = new Example(Member.class);
            example.createCriteria().andEqualTo("status", 1).andEqualTo("username", userLoginRequest.getUsername());

            List<Member> members = memberMapper.selectByExample(example);

            // 检测member
            if (null == members || members.size() == 0) {
                // 返回錯誤
                userLoginResponse.setCode(SysRetCodeConstants.USERORPASSWORD_ERROR.getCode());
                userLoginResponse.setMsg(SysRetCodeConstants.USERORPASSWORD_ERROR.getMessage());

                return userLoginResponse;
            }


            // dto转换
            //        UserLoginResponse userLoginResponse = userConverer.login(member);

            //        return userLoginResponse;

            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }

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
