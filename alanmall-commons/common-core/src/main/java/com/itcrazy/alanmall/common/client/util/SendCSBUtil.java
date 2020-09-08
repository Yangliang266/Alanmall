package com.itcrazy.alanmall.common.client.util;

import com.alibaba.csb.sdk.HttpCaller;
import com.alibaba.csb.sdk.HttpParameters;
import com.itcrazy.alanmall.common.vo.PrepaidCardData;

public class SendCSBUtil {

	// 调用CSB请求
	public static String sendCSBData(PrepaidCardData pcData) throws Exception {
		
		// 获取随机密码
		String symkey = BASE64Util.getRandomkey();
		// 私钥加密随机数
		String symmetricKeyEncrpt = BASE64Util.encryptRSA("" + symkey, BASE64Util.getPrivateKey(pcData.getSymmetricKeyEncrpt()));
		// 加密json
		String jsonDataEncrypt = BASE64Util.encryptAES("" + symkey, pcData.getJsonDataEncrypt());
		
		StringBuffer csbData = new StringBuffer("{\"dataMap\":");
		csbData.append("{\"uniqueNo\":\"").append(pcData.getUniqueNo()).append("\",");
		csbData.append("\"symmetricKeyEncrpt\":\"").append(symmetricKeyEncrpt).append("\",");
		csbData.append("\"jsonDataEncrypt\":\"").append(jsonDataEncrypt).append("\"}}");
		HttpParameters.Builder builder = new HttpParameters.Builder();
		builder.api(pcData.getApiName()).version("1.0.0").requestURL(pcData.getUrl())
			   .method("POST").accessKey(pcData.getAccessKey()).secretKey(pcData.getAccessKeySecret())
				.putParamsMap("dataMap", csbData.toString());
//		System.out.println("csbData:" + csbData.toString());
		String result = HttpCaller.invoke(builder.build());
//		System.out.println("result==" + result);
		return result;
	}

}
