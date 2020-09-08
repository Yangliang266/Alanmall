package com.itcrazy.alanmall.common.client.constains;

import java.math.BigDecimal;

/**
 * 卡系统常量
 * @author chenfei
 * 2018-09-05
 */
public class CardConstants {

	/** 是 */
	public final static int KEY_YES = 0;
	/** 否 */
	public final static int KEY_NO = 1;

	/** 是 */
	public final static String VALUE_YES = "是";
	/** 否 */
	public final static String VALUE_NO = "否";

	/** 启用 */
	public final static int KEY_ENABLE = 0;
	/** 停用 */
	public final static int KEY_DISABLE = 1;

	/** 启用 */
	public final static String VALUE_ENABLE = "启用";
	/** 停用 */
	public final static String VALUE_DISABLE = "停用";

	/** 制卡 */
	public final static int KEY_CARD_STATE_MAKE = 1;

	/** 写卡失败 */
	public final static int KEY_CARD_STATE_WRITE_FAIL = 2 ;

	/** 退货 */
	public final static int KEY_CARD_STATE_RETURN = 3;

	/** 总部入库 */
	public final static int KEY_CARD_STATE_HQ_IN = 4;

	/** 作废 */
	public final static int KEY_CARD_STATE_SCRAP = 5;

	/** 总部出库 */
	public final static int KEY_CARD_STATE_HQ_OUT = 6;

	/** 门店入库 */
	public final static int KEY_CARD_STATE_STORE_IN = 7;

	/** 门店出库 */
	public final static int KEY_CARD_STATE_STORE_OUT = 8;

	/** 激活 */
	public final static int KEY_CARD_STATE_ACTIVATED = 9;

	/** 挂失 */
	public final static int KEY_CARD_STATE_LOST = 10;


	/** 制卡 */
	public final static String VALUE_CARD_STATE_MAKE = "制卡";

	/** 写卡失败 */
	public final static String VALUE_CARD_STATE_WRITE_FAIL = "写卡失败" ;

	/** 退货 */
	public final static String VALUE_CARD_STATE_RETURN = "退货";

	/** 总部入库 */
	public final static String VALUE_CARD_STATE_HQ_IN = "总部入库";

	/** 作废 */
	public final static String VALUE_CARD_STATE_SCRAP = "作废";

	/** 总部出库 */
	public final static String VALUE_CARD_STATE_HQ_OUT = "总部出库";

	/** 门店入库 */
	public final static String VALUE_CARD_STATE_STORE_IN = "门店入库";

	/** 门店出库 */
	public final static String VALUE_CARD_STATE_STORE_OUT = "门店出库";

	/** 激活 */
	public final static String VALUE_CARD_STATE_ACTIVATED = "激活";

	/** 挂失 */
	public final static String VALUE_CARD_STATE_LOST = "挂失";

	/** 默认折扣*/
	public final static BigDecimal DEFAULT_DISCOUNT = BigDecimal.ONE;

	/** 男 */
	public final static int KEY_CARD_SEX_MAN = 0;

	/** 女 */
	public final static int KEY_CARD_SEX_WOMAN = 1;

	/** 男 */
	public final static String VALUE_CARD_SEX_MAN = "男";

	/** 女 */
	public final static String VALUE_CARD_SEX_WOMAN = "女";

	/** 换卡 */
	public final static int KEY_CHANGE_CARD = 0;

	/** 补卡*/
	public final static int KEY_SUPPLEMENT_CARD = 1;


	/** 调拨入库*/
	public final static int KEY_STORE_TRANSFER_IN = 1;
	/** 调拨出库*/
	public final static int KEY_STORE_TRANSFER_OUT = 2;
	/** 调拨入库*/
	public final static String VALUE_STORE_TRANSFER_IN = "调拨入库";
	/** 调拨出库*/
	public final static String VALUE_STORE_TRANSFER_OUT = "调拨出库";


	/** 本店已入库*/
	public final static int KEY_STORE_TRANSFER_STATU_OUR_IN = 1;
	/** 本店未入库*/
	public final static int KEY_STORE_TRANSFER_STATU_OUR_NOT_IN = 2;
	/** 它店已入库*/
	public final static int KEY_STORE_TRANSFER_STATU_OTHER_IN = 3;
	/** 它店未入库*/
	public final static int KEY_STORE_TRANSFER_STATU_OTHER_NOT_IN = 4;
	/** 本店已入库*/
	public final static String VALUE_STORE_TRANSFER_STATU_OUR_IN = "本店已入库";
	/** 本店未入库*/
	public final static String VALUE_STORE_TRANSFER_STATU_OUR_NOT_IN = "本店未入库";
	/** 它店已入库*/
	public final static String VALUE_STORE_TRANSFER_STATU_OTHER_IN = "它店已入库";
	/** 它店未入库*/
	public final static String VALUE_STORE_TRANSFER_STATU_OTHER_NOT_IN = "它店未入库";


	/** 作废单号前缀 */
	public final static String RECEIPT_NO_PREFIX = "ZBZF-";

	/** 折扣率默认保留位数*/
	public final static int DEFAULT_DISCOUNT_NUM = 2;

	/** 挂帐默认保留位数*/
	public final static int DEFAULT_CREDIT_NUM = 2;

	/** 折扣率默认保留小数的舍入模式*/
	public final static int DEFAULT_DISCOUNT_ROUNDING_MODE = BigDecimal.ROUND_DOWN;

	/** 折扣率的正则 0.01 - 1.00*/
	public final static String IS_DISCOUNT = "/^0\\.[0-9]{2}$|0\\.[0-9]|1\\.[0][0]|1\\.[0]|1/";


	/** 卡消费折扣状态 0：品牌*/
	public final static int CARD_DISCOUNT_TYPE_BRAND = 0;
	/** 卡消费折扣状态 1：门店*/
	public final static int CARD_DISCOUNT_TYPE_STORE = 1;

	/** 挂帐额度类型  0：品牌*/
	public final static int CARD_CREDIT_TYPE_BRAND = 0;
	/** 挂帐额度类型 1：门店*/
	public final static int CARD_CREDIT_TYPE_STORE = 1;

	/** 卡挂账状态 0：开启*/
	public final static int KEY_CREDIT_STATUS_ENABLE = 0;
	/** 卡挂账状态 1：关闭*/
	public final static int KEY_CREDIT_STATUS_DISABLE = 1;
	/** 卡挂账状态 0：开启*/
	public final static String VALUE_CREDIT_STATUS_ENABLE = "开启";
	/** 卡挂账状态 1：关闭*/
	public final static String VALUE_CREDIT_STATUS_DISABLE = "关闭";


	/** 卡清账状态 0：已清账*/
	public final static int KEY_CREDIT_SALES_STATUS_ALL = 0;
	/** 卡清账状态 1：部分清账*/
	public final static int KEY_CREDIT_SALES_STATUS_PART = 1;
	/** 卡清账状态 2：未清账*/
	public final static int KEY_CREDIT_SALES_STATUS_NEVER = 2;
	/** 卡清账状态 0：已清账*/
	public final static String VALUE_CREDIT_SALES_STATUS_ALL = "已清账";
	/** 卡清账状态 1：部分清账*/
	public final static String VALUE_CREDIT_SALES_STATUS_PART = "部分清账";
	/** 卡清账状态 2：未清账*/
	public final static String VALUE_CREDIT_SALES_STATUS_NEVER = "未清账";



	/** 订单状态 0：成功*/
	public final static int KEY_ORDER_STATUS_SUCCESS = 0;
	/** 订单状态 1：失败*/
	public final static int KEY_ORDER_STATUS_FAILED = 1;
	/** 订单状态 2：撤销*/
	public final static int KEY_ORDER_STATUS_REVOKED = 2;


	/** 消费方式 0：储值消费*/
	public final static String KEY_CONSUME_MODE_STORAGE = "0";
	/** 消费方式 1：挂账消费*/
	public final static String KEY_CONSUME_MODE_CREDIT = "1";
	/** 消费方式 2：其他消费*/
	public final static String KEY_CONSUME_MODE_OTHERS = "2";

	/** 短信验证码缓存key 挂失画面*/
	public final static String CACHE_KEY_LOST = "CACHE_KEY_LOST";
	/** 短信验证码缓存key 补办画面*/
	public final static String CACHE_KEY_SUPPLEMENT = "CACHE_KEY_SUPPLEMENT";
	/** 短信验证码缓存key 记名卡信息填写画面*/
	public final static String CACHE_KEY_CARD= "CACHE_KEY_CARD";
}
