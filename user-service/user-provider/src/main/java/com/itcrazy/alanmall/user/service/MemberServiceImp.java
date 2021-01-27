package com.itcrazy.alanmall.user.service;

import com.itcrazy.alanmall.user.manager.IMemberService;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;
import com.itcrazy.alanmall.user.converter.MemberConverter;
import com.itcrazy.alanmall.user.dal.entity.Member;
import com.itcrazy.alanmall.user.dal.mapper.MemberMapper;
import com.itcrazy.alanmall.user.dto.QueryMemberRequest;
import com.itcrazy.alanmall.user.dto.QueryMemberResponse;
import com.itcrazy.alanmall.user.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberServiceImp implements IMemberService {
    @Autowired
    MemberMapper memberMapper;

    @Autowired
    MemberConverter memberConverter;

    @Override
    public QueryMemberResponse queryMemberById(QueryMemberRequest request) {
        log.info("Begin: MemberServiceImp.queryMemberById.request: " + request.getUserId());
        QueryMemberResponse response = new QueryMemberResponse();
        try {
            Member member = memberMapper.selectByPrimaryKey(request.getUserId());
            if (null != member) {
                response = memberConverter.member2Res(member);
                response.setCode(SysRetCodeConstants.SUCCESS.getCode());
                response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
            }
        } catch (Exception e) {
            log.error("Exception: MemberServiceImp.queryMemberById.response: " + response);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }
}
