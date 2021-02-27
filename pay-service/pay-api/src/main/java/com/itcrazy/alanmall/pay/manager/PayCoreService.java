package com.itcrazy.alanmall.pay.manager;


import com.itcrazy.alanmall.pay.dto.PaymentNotifyRequest;
import com.itcrazy.alanmall.pay.dto.PaymentNotifyResponse;
import com.itcrazy.alanmall.pay.dto.PaymentRequest;
import com.itcrazy.alanmall.pay.dto.PaymentResponse;

public interface PayCoreService {
    /**
     * 执行支付操作
     * @param request
     * @return
     */
    PaymentResponse execPay(PaymentRequest request);


    /**
     * 支付、退款结果通知处理(等待微信或者支付宝异步通知支付结果）
     * @param request
     * @return
     */
    PaymentNotifyResponse paymentResultNotify(PaymentNotifyRequest request);

    /**
     * 执行退款
     * @param refundRequest
     * @return
     */
//    RefundResponse execRefund(RefundRequest refundRequest);

}
