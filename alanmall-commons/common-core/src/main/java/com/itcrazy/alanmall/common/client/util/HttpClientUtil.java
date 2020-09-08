package com.itcrazy.alanmall.common.client.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpClientUtil {

	/**
	 * http raw post
	 * 
	 * @param url
	 * @param data
	 * @return
	 */
	public static String rawPostRequest(String url, String data) {
		if (StringUtils.isBlank(url)) {
			return null;
		}
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		String responseStr = null;
		try {
			httpClient = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			// raw data编码
			StringEntity postingString = new StringEntity(data,
					StandardCharsets.UTF_8);
			post.setEntity(postingString);
			// 设置超时
			RequestConfig config = RequestConfig.custom()
					.setConnectionRequestTimeout(5 * 1000)
					.setConnectTimeout(5 * 1000).setSocketTimeout(5 * 1000)
					.build();
			post.setConfig(config);
			response = httpClient.execute(post);
			// response编码
			responseStr = EntityUtils.toString(response.getEntity(),
					StandardCharsets.UTF_8);
			EntityUtils.consume(response.getEntity());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (httpClient != null) {
					httpClient.close();
					httpClient = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (response != null) {
					response.close();
					response = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseStr;
	}

	public static void main(String[] args) {
		String url = "http://test.semoor.cn/o2o_5imeishi/notify3.php";
		long time = System.currentTimeMillis() / 1000;
		url += "?order_id=4741395&time=" + time;
		JSONObject data = new JSONObject();
		data.put("total", 140);
		data.put("title", "支付金额");
		JSONArray totaldetail = new JSONArray();
		JSONObject cash = new JSONObject();
		cash.put("name", "现金");
		cash.put("value", 10);
		totaldetail.add(cash);
		JSONObject score = new JSONObject();
		score.put("name", "积分");
		score.put("value", 50);
		totaldetail.add(score);
		JSONObject wechatpay = new JSONObject();
		wechatpay.put("name", "微信支付");
		wechatpay.put("value", 100);
		totaldetail.add(wechatpay);
		JSONObject coupon = new JSONObject();
		coupon.put("name", "满减");
		coupon.put("value", 10);
		totaldetail.add(coupon);
		data.put("totaldetail", totaldetail);
		data.put("tableno", "001");

		String json = data.toString();
		String original = "order_id=4741395&post=" + json + "&time=" + time
				+ "&key=testtest";
		String sign = SHA1Util.encode(original);
		url += "&sign=" + sign;

		String returnStr = rawPostRequest(url, json);
		System.out.println(returnStr);
	}
}
