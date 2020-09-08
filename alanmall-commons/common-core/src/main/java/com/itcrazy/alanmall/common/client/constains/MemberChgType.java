package com.itcrazy.alanmall.common.client.constains;

import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;

/**
 * 会员储值金额变动表
 *
 */
public class MemberChgType extends BaseModelAdapter {

	private static final long serialVersionUID = -2861620055223607452L;

	public static final int TYPE_IMPORT = 1; // 导入数据
	public static final int TYPE_TRANSFER_ADD = 2; // 收银转账记录转入
	public static final int TYPE_TRANSFER_REDUCE = 3; // 收银转账记录转出
	public static final int TYPE_LOCK_ADD = 4; // 手机绑定转入
	public static final int TYPE_LOCK_REDUCE = 11; // 手机绑定转出
	public static final int TYPE_CARD2PHONE_ADD = 5; // 卡会员转手机会员转入
	public static final int TYPE_CARD2PHONE_REDUCE = 12; // 卡会员转手机会员转出
	public static final int TYPE_ACCOUNT_ADD = 6; // 调账增加
	public static final int TYPE_ACCOUNT_REDUCE = 7; // 调账扣减
	public static final int TYPE_MERGE_ADD = 16; // 资产合并转入
	public static final int TYPE_MERGE_REDUCE = 17; // 资产合并转出
	public static final int TYPE_WECHAT_TAKEOUT = 8; // 微外卖扣减
	public static final int TYPE_CREATE_MEMBER = 10; // 新建卡激活
	public static final int TYPE_MEMBER_UPGRADE = 13; // 会员升级

	public static final int TYPE_MEMBER_STORE = 14; // 会员所属门店转入
	public static final int TYPE_LEVEL_REWARD = 15; // 等级奖励增加

	public static final int TYPE_CONSU = 20; // 消费扣除
	public static final int TYPE_CONSU_REWARD = 21; // 消费奖励
	public static final int TYPE_CANCEL_CONSU = 22; // 消费扣除撤销
	public static final int TYPE_CANCEL_CONSU_REWARD = 23; // 消费奖励撤销
	public static final int TYPE_CANCEL_CONSU_CASH = 24; // 消费现金撤销
	public static final int TYPE_CANCEL_CONSU_WECHAT = 25; // 微信支付撤销
	public static final int TYPE_QRCODE_CONSU_WECHAT = 26; // 微信扫码送积分

	public static final int TYPE_BRAND_RECHARGE = 30; // 品牌充值
	public static final int TYPE_RECHARGE = 31; // 收银充值
	public static final int TYPE_RECHARGE_REWARD = 32; // 充值奖励
	public static final int TYPE_CANCEL_RECHARGE = 33; // 充值撤销
	public static final int TYPE_CANCEL_RECHARGE_REWARD = 34; // 充值奖励撤销

	public static final int TYPE_TAKEOUT_CONSU = 51; // 外卖支付扣除
	public static final int TYPE_TAKEOUT_CANCEL_CONSU = 52; // 外卖支付扣除撤销
	public static final int TYPE_TAKEOUT_CONSU_REWARD = 53; // 外卖奖励
	public static final int TYPE_TAKEOUT_CANCEL_REWARD = 54; // 外卖奖励撤销

	public static final int TYPE_DISHORDER_CONSU = 55; // 点餐支付扣除
	public static final int TYPE_DISHORDER_CANCEL_CONSU = 56; // 点餐支付扣除撤销
	public static final int TYPE_DISHORDER_CONSU_REWARD = 57; // 点餐支付奖励
	public static final int TYPE_DISHORDER_CANCEL_REWARD = 58; // 点餐支付奖励撤销

	public static final int TYPE_MSHOP_OPEN = 70; // 微店开店送奖励
	public static final int TYPE_MSHOP_ORDER = 71; // 微店订单送奖励
	public static final int TYPE_MSHOP_ORDER_CONSU = 72; // 微店订单消费奖励

	public static final int TYPE_CANCEL_CONSU_ALIPAY = 80; // 支付宝支付撤销

	public static final int TYPE_MEMBER_PROM = 101; // 营销赠送
	public static final int TYPE_COMMENT = 106; // 评论送积分
	public static final int TYPE_COMMENT_CANCEL = 107; // 撤销评论送积分
	public static final int TYPE_MEMBER_INFO = 108; // 完善会员信息赠送积分
	public static final int TYPE_WECHAT_PROM = 109; // 微信营销赠送
	public static final int TYPE_WECHAT_CARD = 110; // 微信卡券
	public static final int TYPE_CRM_CARD_CONSU = 111; // CRM微信端核销
	public static final int TYPE_COUPON_FROM_FRIEND = 112; // 卡券转赠
	public static final int TYPE_WECHAT_SIGNIN = 113; // 签到奖励
	public static final int TYPE_WECHAT_BROWSE = 114; // 微信活动浏览

	public static final int TYPE_WECHAT_ACTIVITY_ADD = 115; // 微信活动奖励
	public static final int TYPE_WECHAT_ACTIVITY_CONSU = 116; // 微信活动使用
	public static final int TYPE_POS_COUPON_CONSU = 117; // POS核销优惠券

	public static final int TYPE_TAOBAO_RED_PACKET = 120; // 支付宝红包兑换
	public static final int TYPE_TAOBAO_RED_PACKET_CANCEL = 121; // 支付宝红包取消兑换
	public static final int TYPE_TAOBAO_FLOW_WALLET = 122; // 流量钱包兑换
	public static final int TYPE_TAOBAO_FLOW_WALLET_CANCEL = 123; // 流量钱包取消兑换
	public static final int TYPE_TAOBAO_COUPON = 124; // 优惠劵兑换
	public static final int TYPE_TAOBAO_COUPON_CANCEL = 125; // 优惠劵取消兑换
	public static final int TYPE_TAOBAO_GIFT = 126; // 礼品兑换
	public static final int TYPE_TAOBAO_GIFT_CANCEL = 127; // 礼品取消兑换


	public static final int TYPE_WECHAT_USER_CONSU = 201; // 微信用户使用
	public static final int TYPE_OVER_DUE = 202; // 过期
	public static final int TYPE_INVALID = 203; // 作废

	public static final int TYPE_CARD_STOP = 210; // 会员卡注销(停用)

	public static final int TYPE_STOCK_DISH_ADD = 301; // 入库
	public static final int TYPE_STOCK_DISH_REDUCE = 302; // 出库
	public static final int TYPE_STOCK_DISH_UPDATE = 303; // 盘点

	public static final int TYPE_UNION_MEMBER_COUPON_BUY = 400; // 联盟营销-卡券购买
	public static final int TYPE_UNION_MEMBER_PROM_COUPON_CANCEL = 401; // 联盟营销-卡券取消（退款）

	public static final int TYPE_WECHAT_DRAW = 500; // 积分提现
	public static final int TYPE_WECHAT_DRAW_SHARE = 501; // 提现后分享奖励
	public static final int TYPE_WECHAT_SHARE_REG = 502; // 分享后注册奖励

	public static final int TYPE_EXTRA_SCORE = 510; // 签收额外积分奖励
	public static final int TYPE_SIGN_SCORE = 511; // 签收后积分奖励
	public static final int TYPE_TAOBAO = 512; //淘宝购买

	public static final int TYPE_COLLECT_POINT = 600; // 集点兑换
	public static final int TYPE_RESET_POINT = 1001; // 集点清零

	public static final int TYPE_RESET_SCORE = 1000; // 积分清零

	/********* 金额类型 ********/
	public static final int TYPE_AMOUNT = -1; // 储值
	public static final int TYPE_REWARD_AMOUNT = -2; // 奖励
	public static final int TYPE_SCORE = -3; // 积分
	public static final int TYPE_CASH = -4; // 现金
	public static final int TYPE_PROM = -5; // 优惠券
	public static final int TYPE_QRCODE_SCORE = -6; // 积分扫码
	public static final int TYPE_POINT = -7; // 集点

	/**
	 * 请按顺序按照上面列举的类型排序加上类型名称
	 * 
	 * @param type
	 * @return
	 */
	public static String getTypeName(Integer type) {
		String str = "";
		if (type == null) {
			str = "未知类型";
		} else if (type == TYPE_IMPORT) {
			str = "导入数据";
		} else if (type == TYPE_TRANSFER_ADD) {
			str = "收银转账转入";
		} else if (type == TYPE_TRANSFER_REDUCE) {
			str = "收银转账转出";
		} else if (type == TYPE_LOCK_ADD) {
			str = "手机绑定转入";
		} else if (type == TYPE_LOCK_REDUCE) {
			str = "手机绑定转出";
		} else if (type == TYPE_CARD2PHONE_ADD) {
			str = "卡会员转手机会员转入";
		} else if (type == TYPE_CARD2PHONE_REDUCE) {
			str = "卡会员转手机会员转出";
		} else if (type == TYPE_ACCOUNT_ADD) {
			str = "调账增加";
		} else if (type == TYPE_ACCOUNT_REDUCE) {
			str = "调账扣减";
		} else if (type == TYPE_MERGE_ADD) {
			str = "资产合并转入";
		} else if (type == TYPE_MERGE_REDUCE) {
			str = "资产合并转出";
		} else if (type == TYPE_WECHAT_TAKEOUT) {
			str = "微外卖扣减";
		} else if (type == TYPE_CREATE_MEMBER) {
			str = "新建卡激活";
		} else if (type == TYPE_MEMBER_UPGRADE) {
			str = "会员升级";
		}

		else if (type == TYPE_MEMBER_STORE) {
			str = "会员所属门店转入";
		} else if (type == TYPE_LEVEL_REWARD) {
			str = "等级奖励增加";
		}

		else if (type == TYPE_CONSU) {
			str = "消费扣除";
		} else if (type == TYPE_CONSU_REWARD) {
			str = "消费奖励";
		} else if (type == TYPE_CANCEL_CONSU) {
			str = "消费扣除撤销";
		} else if (type == TYPE_CANCEL_CONSU_REWARD) {
			str = "消费奖励撤销";
		} else if (type == TYPE_CANCEL_CONSU_CASH) {
			str = "消费现金撤销";
		} else if (type == TYPE_CANCEL_CONSU_WECHAT) {
			str = "微信支付撤销";
		} else if (type == TYPE_QRCODE_CONSU_WECHAT) {
			str = "微信扫码送积分";
		} else if (type == TYPE_CANCEL_CONSU_ALIPAY) {
			str = "支付宝支付撤销";
		}

		else if (type == TYPE_BRAND_RECHARGE) {
			str = "品牌充值";
		} else if (type == TYPE_RECHARGE) {
			str = "收银充值";
		} else if (type == TYPE_RECHARGE_REWARD) {
			str = "充值奖励";
		} else if (type == TYPE_CANCEL_RECHARGE) {
			str = "充值撤销";
		} else if (type == TYPE_CANCEL_RECHARGE_REWARD) {
			str = "充值奖励撤销";
		}

		else if (type == TYPE_TAKEOUT_CONSU) {
			str = "外卖支付扣除";
		} else if (type == TYPE_TAKEOUT_CANCEL_CONSU) {
			str = "外卖支付扣除撤销";
		} else if (type == TYPE_TAKEOUT_CONSU_REWARD) {
			str = "外卖奖励";
		} else if (type == TYPE_TAKEOUT_CANCEL_REWARD) {
			str = "外卖奖励撤销";
		}

		else if (type == TYPE_DISHORDER_CONSU) {
			str = "点餐支付扣除";
		} else if (type == TYPE_DISHORDER_CANCEL_CONSU) {
			str = "点餐支付扣除撤销";
		} else if (type == TYPE_DISHORDER_CONSU_REWARD) {
			str = "点餐支付奖励";
		} else if (type == TYPE_DISHORDER_CANCEL_REWARD) {
			str = "点餐支付奖励撤销";
		}

		else if (type == TYPE_MSHOP_OPEN) {
			str = "微店开店送奖励";
		} else if (type == TYPE_MSHOP_ORDER) {
			str = "微店订单送奖励";
		} else if (type == TYPE_MSHOP_ORDER_CONSU) {
			str = "微店订单消费奖励";
		}

		else if (type == TYPE_COMMENT) {
			str = "评价消费";
		} else if (type == TYPE_COMMENT_CANCEL) {
			str = "撤销评价消费";
		} else if (type == TYPE_MEMBER_INFO) {
			str = "完善会员信息";
		} else if (type == TYPE_MEMBER_PROM) {
			str = "营销赠送";
		} else if (type == TYPE_WECHAT_PROM) {
			str = "微信营销赠送";
		} else if (type == TYPE_WECHAT_CARD) {
			str = "微信卡券";
		} else if (type == TYPE_CRM_CARD_CONSU) {
			str = "CRM微信端核销";
		} else if (type == TYPE_POS_COUPON_CONSU) {
			str = "POS核销优惠券";
		}

		else if (type == TYPE_COUPON_FROM_FRIEND) {
			str = "卡券转赠";
		} else if (type == TYPE_WECHAT_SIGNIN) {
			str = "签到奖励";
		} else if (type == TYPE_WECHAT_BROWSE) {
			str = "微信活动浏览";
		}

		else if (type == TYPE_WECHAT_ACTIVITY_ADD) {
			str = "微信活动奖励";
		} else if (type == TYPE_WECHAT_ACTIVITY_CONSU) {
			str = "微信活动使用";
		}

		else if (type == TYPE_WECHAT_USER_CONSU) {
			str = "微信用户消费";
		} else if (type == TYPE_OVER_DUE) {
			str = "过期";
		} else if (type == TYPE_INVALID) {
			str = "作废";
		}

		else if (type == TYPE_STOCK_DISH_ADD) {
			str = "入库";
		} else if (type == TYPE_STOCK_DISH_REDUCE) {
			str = "出库";
		} else if (type == TYPE_STOCK_DISH_UPDATE) {
			str = "盘点";
		}

		else if (type == TYPE_UNION_MEMBER_COUPON_BUY) {
			str = "联盟营销购买卡券";
		} else if (type == TYPE_UNION_MEMBER_PROM_COUPON_CANCEL) {
			str = "联盟营销卡券取消";
		}

		else if (type == TYPE_WECHAT_DRAW) {
			str = "积分提现";
		} else if (type == TYPE_WECHAT_DRAW_SHARE) {
			str = "提现后分享奖励";
		} else if (type == TYPE_WECHAT_SHARE_REG) {
			str = "分享后注册奖励";
		}

		else if (type == TYPE_EXTRA_SCORE) {
			str = "签收额外积分奖励";
		} else if (type == TYPE_SIGN_SCORE) {
			str = "签收后积分奖励";
		}

		else if (type == TYPE_RESET_SCORE) {
			str = "积分清零";
		}

		else if (type == TYPE_AMOUNT) {
			str = "储值";
		} else if (type == TYPE_REWARD_AMOUNT) {
			str = "奖励";
		} else if (type == TYPE_SCORE) {
			str = "积分";
		} else if (type == TYPE_CASH) {
			str = "现金";
		} else if (type == TYPE_PROM) {
			str = "优惠券";
		} else if (type == TYPE_QRCODE_SCORE) {
			str = "积分扫码";
		} else if (type == TYPE_CARD_STOP) {
			str = "会员卡注销";
		} else if(type == TYPE_TAOBAO) {
		    str = "淘宝购买";
		} else if(type == TYPE_TAOBAO_RED_PACKET){
            str = "支付宝红包兑换";
        } else if(type == TYPE_TAOBAO_RED_PACKET_CANCEL){
            str = "支付宝红包兑换取消";
        } else if(type == TYPE_TAOBAO_FLOW_WALLET){
            str = "流量钱包兑换";
        } else if(type == TYPE_TAOBAO_FLOW_WALLET_CANCEL){
            str = "流量钱包兑换取消";
        } else if(type == TYPE_TAOBAO_COUPON){
            str = "优惠劵兑换";
        } else if(type == TYPE_TAOBAO_COUPON_CANCEL){
            str = "优惠劵兑换取消";
        } else if(type == TYPE_TAOBAO_GIFT){
            str = " 礼品兑换";
        } else if(type == TYPE_TAOBAO_GIFT_CANCEL){
            str = " 礼品兑换取消";
        }

		return str;
	}
}
