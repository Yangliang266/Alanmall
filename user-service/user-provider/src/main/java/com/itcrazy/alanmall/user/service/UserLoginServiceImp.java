package com.itcrazy.alanmall.user.service;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;
import com.itcrazy.alanmall.user.converter.*;
import com.itcrazy.alanmall.user.dal.entity.Member;
import com.itcrazy.alanmall.user.dal.mapper.MemberMapper;
import com.itcrazy.alanmall.user.dto.CheckAuthRequest;
import com.itcrazy.alanmall.user.dto.CheckAuthResponse;
import com.itcrazy.alanmall.user.dto.UserLoginRequest;
import com.itcrazy.alanmall.user.dto.UserLoginResponse;
import com.itcrazy.alanmall.user.IUserLoginService;
import com.itcrazy.alanmall.user.utils.ExceptionProcessorUtils;
import com.itcrazy.alanmall.user.utils.JwtTokenUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mathyoung
 * @Description
 * @ClassName UserImp
 * @date 2020/7/8 15:47
 */
@Service
@Slf4j
public class UserLoginServiceImp implements IUserLoginService {
    @Autowired
    MemberMapper memberMapper;
//
    @Autowired
    UserConverter userConverer;

    @Autowired
    RedissonConfig redissonConfig;

    /**
     * @author yliang
     * @date 2020/9/10 14:54
     * @description
     * @Param [userLoginRequest]
     * @return com.itcrazy.alanmall.user.dto.UserLoginResponse
     * @throws
     **/
    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        // 输出日志
        log.info("Begin UserLoginServiceImpl.login: request:" + userLoginRequest);
        userLoginRequest.requestCheck();
        UserLoginResponse userLoginResponse = new UserLoginResponse();

        try {
            // 检查参数
            userLoginRequest.requestCheck();
            // 设置查询条件
            Example example = new Example(Member.class);
            example.createCriteria().andEqualTo("state", 1).andEqualTo("username", userLoginRequest.getUsername());

            List<Member> members = memberMapper.selectByExample(example);

            // 检测member
            if (null == members || members.size() == 0) {
                // 返回錯誤
                userLoginResponse.setCode(SysRetCodeConstants.USERORPASSWORD_ERROR.getCode());
                userLoginResponse.setMsg(SysRetCodeConstants.USERORPASSWORD_ERROR.getMessage());
                return userLoginResponse;
            }

            // 验证是否已经激活
            if("N".equals(members.get(0).getIsverified())){
                userLoginResponse.setCode(SysRetCodeConstants.USERORPASSWORD_ERROR.getCode());
                userLoginResponse.setMsg(SysRetCodeConstants.USERORPASSWORD_ERROR.getMessage());
                return userLoginResponse;
            }

            // md5 转换验证
            if(!DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes()).equals(members.get(0).getPassword())){
                userLoginResponse.setCode(SysRetCodeConstants.USERORPASSWORD_ERROR.getCode());
                userLoginResponse.setMsg(SysRetCodeConstants.USERORPASSWORD_ERROR.getMessage());
                return userLoginResponse;
            }

            // 1 根据id file创建 token
            Map<String, Object> map = new HashMap<>();
            map.put("uid",members.get(0).getId());
            map.put("file",members.get(0).getFile());
            String token = JwtTokenUtils.builder().msg(JSON.toJSON(map).toString()).build().creatJwtToken();

            // 2 将查询结果转换为responseDto
            userLoginResponse = userConverer.login(members.get(0));

            // 3 将token返回给前端
            userLoginResponse.setToken(token);
            userLoginResponse.setCode(SysRetCodeConstants.SUCCESS.getCode());
            userLoginResponse.setMsg(SysRetCodeConstants.SUCCESS.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            log.error("UserLoginServiceImpl.login Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(userLoginResponse,e);
        }

        return userLoginResponse;
    }

    /*
     * @Author yangl
     * @Description //TODO 
     * @Date 12:00 2020/9/24
     * @Param [checkAuthRequest]
     * @return com.itcrazy.alanmall.user.dto.CheckAuthResponse
     **/
    @Override
    public CheckAuthResponse validToken(CheckAuthRequest checkAuthRequest) {
        log.info("Begin UserLoginServiceImpl.validToken: request:" + checkAuthRequest);
        checkAuthRequest.requestCheck();
        CheckAuthResponse checkAuthResponse = new CheckAuthResponse();
        try {
            // 解析token
            String decoderMsg = JwtTokenUtils.builder().token(checkAuthRequest.getToken()).build().freeJwt();
            log.info(decoderMsg);


            if (StringUtils.isNoneBlank(decoderMsg)) {
                log.info("validToken success");
                checkAuthResponse.setUserinfo(decoderMsg);
                checkAuthResponse.setCode(SysRetCodeConstants.SUCCESS.getCode());
                checkAuthResponse.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
                return checkAuthResponse;
            }
        } catch (Exception e) {
            log.error("UserLoginServiceImpl.validToken Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(checkAuthResponse,e);
        }
        checkAuthResponse.setCode(SysRetCodeConstants.TOKEN_VALID_FAILED.getCode());
        checkAuthResponse.setMsg(SysRetCodeConstants.TOKEN_VALID_FAILED.getMessage());
        return checkAuthResponse;
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
