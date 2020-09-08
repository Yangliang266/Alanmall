package com.itcrazy.alanmall.common.client.util;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * 新浪微博长链接转短链接工具类
 */
@Slf4j
public class ShortUrlUtil {

	/**
	 * 长网址转短网址
	 * 
	 * @param longUrl
	 * @return
	 */
	public static String shortUrl(String longUrl) {
		if (isBlank(longUrl)) {
			return "";
		}
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		try {
			// 新浪短网址API
			// URL url = new
			// URL("https://api.weibo.com/2/short_url/shorten.json");
			longUrl = URLEncoder.encode(longUrl.trim().replaceAll("\r|\n", ""),
					"utf-8");
			URL url = new URL(
					"http://api.t.sina.com.cn/short_url/shorten.json?source=82966982&url_long="
							+ longUrl);
			URLConnection connection = url.openConnection();
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line = "";
			while ((line = in.readLine()) != null) {
				result.append(line);
			}

			if (isBlank(result.toString())) {
				return "";
			}

			try {
				String rs = result.toString();
				if (rs.startsWith("[")) {
					rs = rs.replaceFirst("\\[", "");
				}
				if (rs.endsWith("]")) {
					rs = rs.substring(0, rs.length() - 1);
				}
				JSONObject jObject = JSONObject.fromObject(rs);
				return jObject.getString("url_short");
			} catch (Exception e) {
				return "";
			}
		} catch (Exception e) {
			log.error("===长链接：" + longUrl + "转微博短链异常：" + e.getMessage());
			return "";
		} finally {
			try {
				if (out != null) {
					out.close();
					out = null;
				}
				if (in != null) {
					in.close();
					in = null;
				}
			} catch (Exception ex) {
			}
		}
	}

	public static void main(String[] args) {
		// String url =
		// shortUrl("http://testm.5imeishi.com/v2/settlement/index.html?wechatUserName=owvpLt2hfPuAoUhooyToHmxBgpmE&wechatConfigId=16&orderCode=140710182&amount=0.01&store_id=3000796&no=2016122100012&device_id=22195&r=53&time=20161221154234");
		String url = shortUrl("\n        http://m.5imeishi.com/v2/settlement/index.html?order_id=142986127&store_id=3000500&money=154.00&site_no=203来客:5&device_id=9343&no=105201612231336&version=2&time=20161223182223");
		System.out.println(url);
	}
}
