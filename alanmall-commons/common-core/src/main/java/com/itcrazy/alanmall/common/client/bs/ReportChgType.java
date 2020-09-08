package com.itcrazy.alanmall.common.client.bs;

/**
 * 报表统计变动类型
 * 
 * @author DDD
 *
 */
public class ReportChgType {

	public static String STORE_STORE_ADD = "1,6,10,15,21,23,30,31,32,33,34,53,54,57,58,70,71,72,101,106,108";// 门店之间充值
	public static String STORE_STORE_CONSU = "7,8,20,22,51,52,55,56,201"; // 门店之间消费
	public static String STORE_STORE_TRANSFER = "2,3,4,5"; // 门店之间转账

	public static String TRADE_STORE_ADD = "1,10,15,21,23,30,31,32,33,34,53,54,57,58,70,71,72,101,106,108";// 操作门店增加预存
	public static String TRADE_STORE_CONSU = "8,20,22,51,52,55,56,201"; // 操作门店消费
	public static String TRADE_STORE_ACCOUNT_ADD = "6";// 操作门店调账增加
	public static String TRADE_STORE_ACCOUNT_REDUCE = "7"; // 操作门店调账减少

	public static String STORE_TRANSFER = "2,3,4,5"; // 门店之间转账
	
	public static String MEMBER_STORE_DEBIT = "1,6,10,15,21,23,30,31,32,33,34,53,54,57,58,70,71,72,101,106,108";// 门店之间充值(借方)
	public static String MEMBER_STORE_LENDER = "7,8,20,22,51,52,55,56,201"; // 门店之间消费(贷方)

}