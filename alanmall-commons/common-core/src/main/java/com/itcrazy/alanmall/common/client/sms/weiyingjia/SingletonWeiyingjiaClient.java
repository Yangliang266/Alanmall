package com.itcrazy.alanmall.common.client.sms.weiyingjia;

import com.itcrazy.alanmall.common.client.file.SysConfig;
import com.itcrazy.alanmall.common.client.sms.weiyingjiaws.Client;

public class SingletonWeiyingjiaClient {

	private static Client client = null;

	private SingletonWeiyingjiaClient() {

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
				.getCommonConf("sms_weiyingjia_ws_softwareSerialNo");
		String key = SysConfig.getCommonConf("sms_weiyingjia_ws_key");
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
		SingletonWeiyingjiaClient.getClient();
	}
}
