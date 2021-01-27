package com.itcrazy.alanmall.order.conveter;

import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.common.result.AbstractResponse;
import com.itcrazy.alanmall.order.context.TransHandlerContext;

public interface TransConverter {
    TransHandlerContext convertRequest2Ctx(AbstractRequest req, TransHandlerContext context);

    AbstractResponse convertCtx2Respond(TransHandlerContext ctx);
}
