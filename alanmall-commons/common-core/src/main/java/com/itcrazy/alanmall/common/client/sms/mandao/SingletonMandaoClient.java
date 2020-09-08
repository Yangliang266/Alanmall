package com.itcrazy.alanmall.common.client.sms.mandao;

import com.itcrazy.alanmall.common.client.file.SysConfig;
import com.itcrazy.alanmall.common.client.sms.mandaows.Client;

public class SingletonMandaoClient {
	public static final String VALID = ""; // 验证类
	public static final String NOTICE = "1"; // 通知类
	public static final String PROM = "5"; // 营销类

	private static Client client = null;

	private SingletonMandaoClient() {
	}

	public synchronized static Client getClient(String softwareSerialNo,
			String key) {
		if (client == null) {
			try {
				client = new Client(softwareSerialNo, key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	public synchronized static Client getClient() {
		String softwareSerialNo = SysConfig
				.getCommonConf("sms_mandao_ws_softwareSerialNo");
		String key = SysConfig.getCommonConf("sms_mandao_ws_key");
		if (client == null) {
			try {
				client = new Client(softwareSerialNo, key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	public static void main(String str[]) {
		SingletonMandaoClient.getClient();
	}
}
