package com.itcrazy.alanmall.user.dal.mapper;

import com.itcrazy.alanmall.common.mybatis.TKMapper;
import com.itcrazy.alanmall.user.dal.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
public interface MemberMapper extends TKMapper<Member> {
    Member selectById(Long id);
}