package com.itcrazy.alanmall.common.client.constains;

public class PayConstants {
	/**
	 * 微信支付相关链接
	 */
	public static final String ORDER_QUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery"; // 查询订单
	public static final String MICROPAY_URL = "https://api.mch.weixin.qq.com/pay/micropay"; // 提交刷卡支付API
	public static final String REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund"; // 申请退款
	public static final String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder"; // 统一下单
	public static final String AUTHCODETOOPENID_URL = "https://api.mch.weixin.qq.com/tools/authcodetoopenid"; // 根据授权码获取openID
	public static final String REVERSE_URL = "https://api.mch.weixin.qq.com/secapi/pay/reverse"; // 撤销订单API
	public static final String MICRO_PAY_URL = "https://api.mch.weixin.qq.com/pay/micropay";

	/**
	 * 亚博松对接参数
	 */
	public static final String SEMOOR_URL = "http://dct.semoor.cn/o2o_5imeishi/notify3.php";
	public static final String SEMOOR_TEST_URL = "http://beta3.semoor.net/o2o_dm_proc_wxpay5ipay/notify.php";
	public static final String SEMOOR_URL_V2 = "http://dct.semoor.cn/o2o_dm_proc_wxpay5ipay/notify.php";
	public static final String SEMOOR_KEY = "testtest";
	// 正式环境支付地址(微信)
	public static final String SEMOOR_PAY_URL = "https://payapi.mch.weixin.semoor.cn";
	// 测试环境支付地址(微信)
	public static final String SEMOOR_PAY_TEST_URL = "http://payapitest.mch.weixin.semoor.cn";
	// 正式环境支付地址V2(微信)
	public static final String SEMOOR_PAY_V2_URL = "https://payapi.mch.weixin.semoor.cn/2.0";
	// 测试环境支付地址V2(微信)
	public static final String SEMOOR_PAY_V2_TEST_URL = "http://payapitest.mch.weixin.semoor.cn/2.0";
	// 正式环境支付地址(支付宝)
	public static final String SEMOOR_ALIPAY_URL = "https://openapi.alipay.semoor.cn/3.0/gateway.do";
	// 测试环境支付地址(支付宝)
	public static final String SEMOOR_ALIPAY_TEST_URL = "http://testopenapi.alipay.semoor.cn/3.0/gateway.do";

	/**
	 * 5i服务商支付信息
	 */
	public static final String KEY_5I = "5imeishifuwushang123456789123456";
	public static final String APPID_5I = "wx46a20d24a65f0b07";
	public static final Long MCH_ID_5I = 1332754901l;

	/**
	 * 意锐对接用参数
	 */
	public static final String PAIPAI_TEST_KEY = "124f0264b776cedeccd0d3d8a84f27bc";
	public static final String PAIPAI_KEY = "c5e4ffcdac481ef9a7b3676a8a605068";
	public static final String PAIPAI_NOTIFY_URL = "http://yirui.2dupay.com/paySuccess";

	/**
	 * 爱订云对接用参数
	 */
	// 测试环境
	public static final String IIDING_TEST_URL = "http://infos.iidingyun.com/settleOrder.vm";
	// 优惠券ID
	public static final String IIDING_TEST_COUPON_ID = "291";
	// 正式环境
	public static final String IIDING_URL = "http://shwc.iidingyun.com/settleOrder.vm";
	// 优惠券ID
	public static final String IIDING_COUPON_ID = "301";

	/**
	 * 杉德对接
	 */
	// pos机调用接口的密钥
	public static final String SAND_POS_KEY = "5imeishisandposkey";
	// 接口调用网管的密钥
	public static final String SAND_LICENSE = "31997dfe10d50b0236060baeae794d39";
	// 接口调用网管的密钥
	public static final String SAND_SELLCODE = "1234567890";
	// 统一支付接口
	public static final String SAND_PAY_URL = "http://114.215.150.146:8091/sandpay-admin/api/pay/doPay.html";
	// 统一支付接口
	public static final String SAND_QUERY_URL = "http://114.215.150.146:8091/sandpay-admin/api/order/query.html";

	public static final String SAND_REVERSE_URL = "http://114.215.150.146:8091/sandpay-admin/api/order/cancel.html";

	public static final String SAND_OPENID_URL = "http://114.215.150.146:8091/sandpay-admin/api/openid/get.html";

	public static final String SAND_REFUND_URL = "http://114.215.150.146:8091/sandpay-admin/api/refund/doRefund.html";

	/**
	 * 平安银行
	 */
	// 测试地址
	public static final String FUBEI_TEST_URL = "https://openapi-liquidation-test.51fubei.com/gateway";
	// 正式环境地址
	public static final String FUBEI_URL = "https://openapi-liquidation.51fubei.com/gateway";
	// 子商户接入
	public static final String FUBEI_SUBMERCHANT_CREATE = "fshows.liquidation.submerchant.create";
	// 商户查询
	public static final String FUBEI_SUBMERCHANT_QUERY = "fshows.liquidation.submerchant.query";
	// 商户卡绑定
	public static final String FUBEI_SUBMERCHANT_BANKBIND = "fshows.liquidation.submerchant.bank.bind";
	// 微信公众号支付
	public static final String FUBEI_WXPAY_MPPAY = "fshows.liquidation.wxpay.mppay";
	// 微信刷卡支付
	public static final String FUBEI_WXPAY_MICPAY = "fshows.liquidation.wx.trade.pay";

	/**
	 * POS厂商编号
	 */
	public static final Integer POS_CODE_YBS = 109;

	/**
	 * 富必达
	 */
	public static final String FUBIDA_KEY = "fbd$passw0rd";
	public static final String FUBIDA_TEST_KEY = "fubida888";

	public static class PosAccount {
		public static final Integer YBS = 109; // 亚博松
		public static final Integer DFIRE = 124; // 二维火
	}
	
	/**
	 * 亚博松支付接口的各方法
	 * @author gaoyj
	 * @date 2018年5月15日
	 */
	public static class SemoorMethod {
		public static final String MICROPAY = "/pay/micropay"; // 刷卡支付
		public static final String ORDER_QUERY = "/pay/orderquery"; // 查询订单
		public static final String REFUND = "/secapi/pay/refund"; // 申请退款
		public static final String REFUND_QUERY = "/pay/refundquery"; // 查询退款
		public static final String REVERSE = "/secapi/pay/reverse"; // 撤销订单
		public static final String CLOSE_ORDER = "/pay/closeorder"; // 关闭订单
		public static final String DOWNLOAD_BILL = "/pay/downloadbill"; // 下载对账单
		public static final String UNIFIEDORDER = "/pay/unifiedorder"; // 统一下单
//		public static final String GETHBINFO = "/mmpaymkttransfers/gethbinfo"; // 红包查询
//		public static final String SENDREDPACK = "/mmpaymkttransfers/sendredpack"; // 红包发放
		
	}
}
