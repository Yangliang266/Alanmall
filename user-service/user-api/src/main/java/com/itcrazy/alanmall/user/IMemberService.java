package com.itcrazy.alanmall.user;

import com.itcrazy.alanmall.user.dto.QueryMemberRequest;
import com.itcrazy.alanmall.user.dto.QueryMemberResponse;

public interface IMemberService {
    QueryMemberResponse queryMemberById(QueryMemberRequest request);
}
