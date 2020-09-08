package com.itcrazy.alanmall.common.client.sms.smsbao;

import com.alibaba.fastjson.JSONObject;
import com.itcrazy.alanmall.common.client.file.SysConfig;
import com.itcrazy.alanmall.common.client.sms.smsbaos.Client;
import com.itcrazy.alanmall.common.client.sms.smsbaos.SmsbaoCode;

/**
 * 短信宝单例
 * 
 * @author lukai
 *
 */
public class SingletonSmsbaoClient {

	private Client client = null;

	private SingletonSmsbaoClient() {
		String cliUsername = SysConfig.getCommonConf("sms_smsbao_username");
		String cliPassword = SysConfig.getCommonConf("sms_smsbao_password");
		client = new Client(cliUsername, cliPassword);
	}

	private static class SingletonSmsbaoClientHolder {
		private final static SingletonSmsbaoClient INSTANCE = new SingletonSmsbaoClient();
	}

	public static SingletonSmsbaoClient getInstance() {
		return SingletonSmsbaoClientHolder.INSTANCE;
	}

	/**
	 * 发送短信
	 * 
	 * @param mobile
	 *            电话号码
	 * @param content
	 *            发送内容
	 * @return 发送结果JSON对象
	 */
	public JSONObject sendSms(String mobile, String content) {

		JSONObject jsonRet = new JSONObject();

		String sendRst = client.sendSMS(mobile, content);
		String[] rets = null;
		// 以“0”开头的字符串默认为发送成功
		if (sendRst != null && sendRst.startsWith("0")) {
			rets = sendRst.split("\n");
			// 第一行返回 '0' 视为发送成功，其他内容为错误提示内容
			// 如果第一行返回成功，则第二行返回 'taskid'，是一个19位长度的字符串，为当前提交任务的唯一标识
			if (rets != null && rets.length == 2) {
				jsonRet.put("code", "0");
				jsonRet.put("taskid", rets[1]);
			} else {
				jsonRet.put("code", "0");
			}
		} else {
			jsonRet.put("code", sendRst);
		}

		return jsonRet;
	}

	/**
	 * 查询余额 原始数据返回内容： 第一行返回 '0' 视为发送成功，其他内容为错误提示内容 如果第一行返回成功，则第二行返回 '发送条数,剩余条数'
	 * 
	 * @return 正常时： 剩余条数 异常时： 错误信息
	 */
	public String getBalance() {
		String ret = null;
		String strRemain = client.getBalance();
		String[] remains = null;
		String[] resLines = strRemain.split("\n");
		if (resLines != null && resLines.length == 2) {
			// 只处理返回状态为正常的情况
			if ("0".equals(resLines[0])) {
				remains = resLines[1].split(",");
				// 获取剩余条数
				if (remains != null && remains.length == 2) {
					ret = remains[1];
				}

				// 存在错误码的情况，返回错误码对应的错误信息
			} else {
				ret = SmsbaoCode.getName(Integer.parseInt(resLines[0]));
			}
		}
		return ret;
	}
}
