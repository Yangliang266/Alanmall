package com.itcrazy.alanmall.common.client.constains;

/**
 * ActiveMQ 队列常量
 */
public class MQConstants {
	/*
	 * 队列名称定义
	 */
	public static final String QUEUE_INSTANT = "5imq_instant_coupon";
	public static final String QUEUE_WECHAT_MEMBER_ASSET = "5imq_wechat_member_asset";
	public static final String QUEUE_MEMBER_SUM = "5imq_member_sum";
	public static final String QUEUE_WECHAT_TEMPLATE = "5imq_wechat_template";
	public static final String QUEUE_IIDINGYUN_QUEUE = "5imq_iidingyun_queue";
	public static final String QUEUE_WECHAT_GROUP_TEMPLATE = "5imq_wechat_group_template";
	public static final String QUEUE_CONSU_RECHARGE_NOTICE = "5imq_consu_recharge_notice";
	public static final String QUEUE_WECHAT_COUPON = "5imq_wechat_coupon";
	public static final String QUEUE_IIDINGYUN_SEND_RECHARGE = "5imq_iidingyun_send_recharge";
	public static final String QUEUE_ALIPAY_MEMBER_ASSET = "5imq_alipay_member_asset";
	public static final String QUEUE_WECHAT_USER_INFO = "5imq_wechat_user_info";
	public static final String QUEUE_WECHAT_MEMBER_CARD = "5imq_wechat_member_card";

	/*** 扫码支付，支付完成回调队列 ***/
	// 亚博松
	public static final String QUEUE_POS_NOTIFY_YBS = "5imq_pos_ybs_notify";
	// 爱订云
	public static final String QUEUE_POS_NOTIFY_IIDING = "5imq_pos_iiding_notify";
	// 大家来
	public static final String QUEUE_POS_NOTIFY_DAJIALAI = "5imq_pos_dajialai_notify";
	// 大家来失败时连续通知
	public static final String QUEUE_POS_NOTIFY_DAJIALAI_ERR = "5imq_pos_dajialai_notify_err";
	// 餐道
	public static final String QUEUE_POS_NOTIFY_CANDAO = "5imq_pos_candao_notify";

	/****** 二维火券对接用队列 ********************/
	public static final String QUEUE_DFIRE_COUPON = "5imq_dfire_coupon";

	/****** 二维火会员储值对接用队列 ********************/
	public static final String QUEUE_DFIRE_MEMBER = "5imq_dfire_member";

	/****** 二维火会员卡激活对接用队列 ********************/
	public static final String QUEUE_DFIRE_MEMBER_CARD_SAVE = "5imq_dfire_member_card_save";

	// mq-consumer2

	/** APP语音播报 */
	public static final String QUEUE_APP_XPUSH_CONSU = "5imq_app_xpush_consu";
}
