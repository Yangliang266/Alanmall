package com.itcrazy.alanmall.common.client.sms.mandao;

import com.itcrazy.alanmall.common.client.file.SysConfig;
import com.itcrazy.alanmall.common.client.sms.mandaows.AudioClient;

public class SingletonMandaoAudioClient {
	private static AudioClient client = null;

	private SingletonMandaoAudioClient() {
	}

	public synchronized static AudioClient getClient(String softwareSerialNo,
			String key) {
		if (client == null) {
			try {
				client = new AudioClient(softwareSerialNo, key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	public synchronized static AudioClient getClient() {
		String softwareSerialNo = SysConfig
				.getCommonConf("sms_mandao_ws_softwareSerialNo");
		String key = SysConfig.getCommonConf("sms_mandao_ws_key");
		if (client == null) {
			try {
				client = new AudioClient(softwareSerialNo, key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	public static void main(String str[]) {
		SingletonMandaoAudioClient.getClient();
	}
}
