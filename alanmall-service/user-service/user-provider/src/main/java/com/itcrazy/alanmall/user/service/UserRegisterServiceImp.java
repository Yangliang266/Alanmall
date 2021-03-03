package com.itcrazy.alanmall.user.service;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.user.manager.IUserRegisterService;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;
import com.itcrazy.alanmall.user.dal.entity.Member;
import com.itcrazy.alanmall.user.dal.entity.UserVerify;
import com.itcrazy.alanmall.user.dal.mapper.MemberMapper;
import com.itcrazy.alanmall.user.dal.mapper.UserVerifyMapper;
import com.itcrazy.alanmall.user.dto.UserRegisterRequest;
import com.itcrazy.alanmall.user.dto.UserRegisterResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@DubboService
@Slf4j
public class UserRegisterServiceImp implements IUserRegisterService {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    UserVerifyMapper userVerifyMapper;

    @Override
    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        log.info("Begin:UserRegisterServiceImp.register.request:" + userRegisterRequest);
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterRequest.requestCheck();

        existUser(userRegisterRequest);
        Member member = new Member();
        member.setUsername(userRegisterRequest.getUserName());
        member.setPassword(DigestUtils.md5DigestAsHex(userRegisterRequest.getUserPwd().getBytes()));

        member.setState(1);
        member.setCreated(new Date());
        member.setUpdated(new Date());
        member.setIsverified("N");//为激活
        member.setEmail(userRegisterRequest.getEmail());

        if (memberMapper.insert(member) != 1) {
            userRegisterResponse.setCode(SysRetCodeConstants.USER_REGISTER_FAILED.getCode());
            userRegisterResponse.setMsg(SysRetCodeConstants.USER_REGISTER_FAILED.getMessage());
            log.info("Failed:UserRegisterServiceImp.register.response:" + userRegisterResponse);
            return userRegisterResponse;
        }

        //插入用户验证表
        UserVerify userVerify = new UserVerify();
        userVerify.setUsername(member.getUsername());
        String key = member.getUsername()+member.getPassword()+ UUID.randomUUID().toString();
        userVerify.setUuid(DigestUtils.md5DigestAsHex(key.getBytes()));
        userVerify.setIsExpire("N");//注册信息是否过期
        userVerify.setIsVerify("N");//是否验证成功
        userVerify.setRegisterDate(new Date());
        if(userVerifyMapper.insert(userVerify)!=1){
            userRegisterResponse.setCode(SysRetCodeConstants.USER_REGISTER_VERIFY_FAILED.getCode());
            userRegisterResponse.setMsg(SysRetCodeConstants.USER_REGISTER_VERIFY_FAILED.getMessage());
            log.info("Failed:UserRegisterServiceImp.register.response:" + userRegisterResponse);
            return userRegisterResponse;
        }
        userRegisterResponse.setCode(SysRetCodeConstants.SUCCESS.getCode());
        userRegisterResponse.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
        log.info("End:UserRegisterServiceImp.register.response:" + userRegisterResponse);
        return userRegisterResponse;
    }

    private void existUser(UserRegisterRequest userRegisterRequest) {
        // 数据库查询 是否有重复数据
        userRegisterRequest.requestCheck();

        Example example = new Example(Member.class);
        example.createCriteria().andEqualTo("state",1).andEqualTo("username",userRegisterRequest.getUserName());

        List<Member> members = memberMapper.selectByExample(example);

        if (members != null && members.size() > 0) {
            throw  new ValidateException(SysRetCodeConstants.USERNAME_ALREADY_EXISTS.getCode(),SysRetCodeConstants.USERNAME_ALREADY_EXISTS.getMessage());
        }
    }

}
