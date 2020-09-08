package com.itcrazy.alanmall.common.client.util;

import com.itcrazy.alanmall.common.client.file.SysConfig;
import net.sf.json.JSONObject;

public class PayQrCodeUtil {

	public static String getMemberAsset(String qrCode) {
		String url = SysConfig.getCommonConf("INTERFACE_HOST");
		String result = HttpRequest.sendUrl(url
				+ "/pay/getMemberAsset.action?content=" + qrCode, null);
		return result;
	}

	public static void main(String[] args) {
		String result = getMemberAsset("10071");
		JSONObject jObject = JSONObject.fromObject(result);
		Object res = jObject.get("result");
		JSONObject j = JSONObject.fromObject(res);
		System.out.println(jObject);
		System.out.println(j.get("code"));
		System.out.println(j.get("memberId"));
	}

}
