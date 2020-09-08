package com.itcrazy.alanmall.common.client.constains;

public class DFireConstants {
	public static final String DFIRE_URL = "http://open.2dfire.com/router";
	public static final String DFIRE_APPKEY = "62b0566f2a3e134d8989a8c1e452d7d2";
	public static final String DFIRE_SECRET = "b713a25328a966728945e911280d9b88";
	public static final long WAIT_TIME_RETRY = 5000; // 推送失败的等候时间
	public static final int LOOP_COUNT = 3; // 失败时，重复推送的次数
	public static final int SOURCE = 3; // 来源（5i专用）
	public static final String PREFIX_MOBILE_MEMBER = "M"; // 手机会员用M+手机号作为二维火会员卡卡号

	public static class SystemResult {
		public static final String SERVICE_UNAVAILABLE = "1"; // 服务目前无法使用，请保存好错误信息并和服务平台管理员联系
		public static final String ISV_AUTH_ERROR = "2"; // 不足的ISV权限，请和管理员联系
		public static final String PERMISSION_DENY = "3"; // 用户权限不足，请和管理员联系
		public static final String UPLOAD_FAIL = "4"; // 上传失败，请检查文件类型及大小是否合法
		public static final String POST_METHOD_ERROR = "5"; // 请使用合适的HTTP方法（GET或POST）
		public static final String INVALID_ENCRYPT_CODE = "6"; // 无效的编码，请对使用UTF-8对请求参数值进行编码
		public static final String REQUEST_FORBID = "7"; // 禁止请求，因服务平台已经满负荷，请稍候再试
		public static final String OLD_VERSION = "8"; // 方法已过时，请使用新版本或其它替代的方法
		public static final String SESSION = "9"; // 请了解服务调用的前置条件，检查是否满足业务逻辑
		public static final String SESSION_ISNULL = "20"; // 将添加会话ID请求参数
		public static final String INVALID_SESSION = "21"; // 无效的会话,请重新登录以获取合法的会话
		public static final String APPKEY_ISNULL = "22"; // 缺少appKey，请向服务端获取合法的appKey
		public static final String INVALID_APPKEY = "23"; // 无效的appKey,请使用合法的appKey（由服务提供商授予你）
		public static final String SIGN_ISNULL = "24"; // 缺少签名参数，请添加签名请求参数
		public static final String INVALID_SIGN = "25"; // 签名无效，请按正确的算法对请求数据进行签名:SHA1(<secret>
														// <paramName1><paramValue><secret>),注意参数列表按字母顺序排列
		public static final String METHOD_ISNULL = "26"; // 缺少方法,请添加上服务方法的请求参数
		public static final String INVALID_METHOD = "27"; // 无效的方法，请检查服务方法名是否正确
		public static final String VERSION_ISNULL = "28"; // 缺少版本参数，请指定服务方法的版本号
		public static final String INVALID_VERSION = "29"; // 非法的版本号，这个服务方法的版本号是错误的，请检查
		public static final String VERSION_EXPIRED = "30"; // 这个版本号已经不支持，如已经过期，请使用新的服务方法版本
		public static final String DATA_FORMAT_ERROR = "31"; // 数据格式不正确，合法的报文格式为xml,json及stream,请检查
		public static final String PARAM_ERROR = "32"; // 请查看根据服务接口，添加必须的参数
		public static final String PARAM_FORMAT_ERROR = "33"; // 请查看根据服务接口对参数格式的要求
		public static final String SYSTEM_BUSY = "34"; // 等待片刻，稍候再试
		public static final String LOGOUT_SYSTEM = "35"; // 退出系统，稍候再试
		public static final String AUTH_ACCESS_TIMES = "36"; // 请检查应用授权访问服务的次数
		public static final String REDUCE_ACCESS_TIMES = "37"; // 请降低服务访问的频率
		public static final String TIMESTAMP_ISNULL = "38"; // 传入的参数中添加必需包含的timestamp参数
		public static final String TIMESTAMP_FORMAT_ERROR = "39"; // 时间戳，格式为秒或毫秒
		public static final String APPKEY_ERROR = "40"; // 检查appKey是否错误或在传入的参数中添加加盟编号
		public static final String INVALID_COMPANY_CODE = "41"; // 无效的加盟商编号，请检查加盟商编号是否正确
		public static final String INVALID_STORE_CODE = "42"; // 无效的店铺编号，请检查店铺编号是否正确
	}

	/**
	 * 业务错误码
	 * 
	 * @author gaoyj
	 * @date 2017年5月24日
	 */
	public static class BussinessResult {
		public static final String SUCCESS = "000"; // 操作成功
		public static final String SEARCH_RESULT_NULL = "001"; // 查询结果为空
		public static final String PARAM_ERROR = "002"; // 输入参数为空或格式不正确
		public static final String ACCOUNT_PWD_ERROR = "003"; // 账号或密码错误
		public static final String DUPLICATE_ACCOUNT = "004"; // 账号重复
		public static final String ORDER_SOURCE_ERROR = "005"; // 下单订单来源转换为Short失败
		public static final String SERVER_INTERRUPT = "009"; // 服务器中断，请联系客服
		public static final String SHOPPING_CART_EMPTY = "010"; // 购物车不能为空
		public static final String APP_KEY_ERROR = "011"; // 授权申请号错误
		public static final String STORE_NOT_EXIST = "012"; // 无法查询到对应店铺
		public static final String TIMESTAMP_ERROR = "013"; // 输入时间参数不正确
		public static final String ORDERID_COUNT_ERROR = "014"; // 输入订单ID多于20条
		public static final String ENTITYID_ERROR = "015"; // 输入entityId不能为门店
		public static final String INVALID_ORDERID = "016"; // 无效的订单ID
		public static final String INVALID_SUPPLIER_CODE = "017"; // 无效的供应商code
		public static final String INVALID_MATERIAL_CODE = "018"; // 无效的原料ID
		public static final String INVALID_HOUSE_CODE = "019"; // 无效的仓库ID
		public static final String INVALID_CODE = "020"; // 无效的单据编号
		public static final String INVALID_STATUS = "021"; // 无效的单据状态
		public static final String INVALID_ENTITYID = "022"; // 配送单,输入entityId不能为总部
	}

	/**
	 * 二维火对接方法名
	 * 
	 * @author gaoyj
	 * @date 2017年5月26日
	 */
	public static class Method {
		public static final String COUPON_SEND = "dfire.shop.deliver.promotion";
		public static final String COUPON_CONSU = "dfire.shop.verify.promotion";
		public static final String COUPON_GET = "dfire.shop.query.promotion";
		public static final String COUPON_DEL = "dfire.shop.delete.promotion";
		// 会员卡充值
		public static final String CARD_CHARGE = "dfire.shop.member.card.charge";

		// 会员卡充值记录红冲
		public static final String CHARGE_CANCEL = "dfire.shop.member.card.cancel.charge";
		// 保存会员信息
		public static final String MEMBER_CARD_SAVE = "dfire.member.save";
	}

	/**
	 * 会员推送的推送类型
	 * 
	 * @author gaoyj
	 * @date 2017年5月26日
	 */
	public static class EventType {
		public static final String MEMBER_CARD = "1"; // 会员卡消息
		public static final String AMOUNT_CHG = "2"; // 金额流水
		public static final String CARD_STATUS_CHG = "3"; // 操作流水
	}

	public static class CardStatus {
		/*** 挂失（冻结） ***/
		public static final int STATUS_LOSS = 2;
		/*** 解挂（解锁） ***/
		public static final int STATUS_UNLOCK = 3;
		/*** 注销（停用） ***/
		public static final int STATUS_STOP = 4;
		// 激活
		public static final int STATUS_ACTIVITY = 7;
	}

}
