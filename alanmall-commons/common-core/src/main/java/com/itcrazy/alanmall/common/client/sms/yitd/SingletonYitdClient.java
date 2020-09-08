package com.itcrazy.alanmall.common.client.sms.yitd;

import com.itcrazy.alanmall.common.client.file.SysConfig;

public class SingletonYitdClient {

	/** 普通短信 */
	private static Client client = null;
	/** 营销短信 */
	private static Client promClient = null;

	private SingletonYitdClient() {
	}

	public synchronized static Client getClient() {
		if (client == null) {
			try {
				String uid = SysConfig.getCommonConf("sms_yitd_userid");
				String username = SysConfig.getCommonConf("sms_yitd_username");
				String passwd = SysConfig.getCommonConf("sms_yitd_password");

				client = new Client(uid, username, passwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	public synchronized static Client getPromClient() {
		if (promClient == null) {
			try {
				String uid = SysConfig.getCommonConf("sms_yitd_prom_userid");
				String username = SysConfig
						.getCommonConf("sms_yitd_prom_username");
				String passwd = SysConfig
						.getCommonConf("sms_yitd_prom_password");

				promClient = new Client(uid, username, passwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return promClient;
	}
}
