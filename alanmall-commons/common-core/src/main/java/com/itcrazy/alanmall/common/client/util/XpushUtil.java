package com.itcrazy.alanmall.common.client.util;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * 调用科大讯飞的XPush REST API推送消息https://www.xfyun.cn/static/xpush/restapi.html
 * 
 * @see
 */
@Slf4j
public class XpushUtil {
	private static Map<String, String> configMap = new Hashtable<String, String>();

	static {
		InputStream is = null;
		Properties prop = new Properties();
		try {
			String path = System.getenv("meishi_config_path");
			is = new FileInputStream(new File(path + "/xpush.properties"));
			prop.load(is);

			for (Object okey : prop.keySet()) {
				String key = (String) okey;
				String value = prop.getProperty(key);
				configMap.put(key, value);
			}
		} catch (IOException e) {
			log.error("Load [xpush.properties] error:", e);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
	}

	/**
	 * 推送消息
	 * 
	 * @param did
	 *            设备唯一标示，Android下传获取的did， 多个以Enter换行（即转义字符\r\n）分隔；一次最多推送5000个did
	 * @param content
	 *            推送的消息内容
	 */
	public static boolean push(String did, String content) {
		if (isBlank(did) || isBlank(content)) {
			return false;
		}

		HttpURLConnection conn = null;
		OutputStream out = null;
		InputStream in = null;

		try {
			URL realUrl = new URL(configMap.get("server_url"));
			// 打开和URL之间的连接
			conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestMethod("POST");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			List<String> params = new ArrayList<String>();
			params.add("appid="
					+ URLEncoder.encode(configMap.get("appid"), "UTF-8"));
			params.add("did=" + URLEncoder.encode(did, "UTF-8"));
			params.add("push_type=" + URLEncoder.encode("2", "UTF-8"));// 2:列表推，对一批指定的设备
			params.add("extra_content=" + URLEncoder.encode(content, "UTF-8"));// 透传消息
			params.add("timestamp="
					+ URLEncoder.encode((System.currentTimeMillis() / 1000)
							+ "", "UTF-8"));
			params.add("msg_type=" + URLEncoder.encode("1", "UTF-8"));// 消息类型，0:通知，
																		// 1:透传

			Collections.sort(params);

			StringBuilder sbParam = new StringBuilder();
			int i = 0;
			for (String str : params) {
				sbParam.append(str);
				if (i != params.size() - 1) {
					sbParam.append("&");
				}
				i++;
			}

			List<String> md5params = new ArrayList<String>();
			md5params.add("appid=" + configMap.get("appid"));
			md5params.add("did=" + did);
			md5params.add("push_type=2");
			md5params.add("extra_content=" + content);
			md5params.add("timestamp=" + System.currentTimeMillis() / 1000);
			md5params.add("msg_type=1");

			Collections.sort(md5params);

			StringBuilder sbMd5Param = new StringBuilder();
			for (String str : md5params) {
				sbMd5Param.append(str);
			}

			String pushUrl = configMap.get("server_url")
					.replaceAll("http://", "").replaceAll("https://", "");
			String md5Str = "POST" + pushUrl + sbMd5Param.toString()
					+ configMap.get("api_key");
			String sign = MD5Util.MD5(md5Str, false);
			String strParam = sbParam.toString() + "&sign=" + sign;

			// 连接超时
			conn.setConnectTimeout(15000);
			// 读取超时
			conn.setReadTimeout(15000);
			HttpURLConnection.setFollowRedirects(true);

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.connect();
			// 获取URLConnection对象对应的输出流
			out = conn.getOutputStream();
			// 发送请求参数
			out.write(strParam.getBytes("UTF-8"));
			out.flush();

			in = conn.getInputStream();
			BufferedReader read = new BufferedReader(new InputStreamReader(in,
					"UTF-8"));
			String valueString = null;
			StringBuffer bufferRes = new StringBuffer();
			while ((valueString = read.readLine()) != null) {
				bufferRes.append(valueString);
			}

			String result = bufferRes.toString();

			JSONObject obj = JSONObject.fromObject(result);
			String ret = obj.getString("ret");
			if (!ret.equals("0")) {
				log.error("[XPush]推送消息失败，错误码：" + ret);
				return false;
			}
			return true;
		} catch (SocketTimeoutException se) {
			log.error("[XPush]推送消息超时，异常: " + se.getMessage());
		} catch (Exception e) {
			log.error("[XPush]推送消息异常: " + e.getMessage());
		} finally {
			try {
				if (out != null) {
					out.close();
					out = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			try {
				if (in != null) {
					in.close();
					in = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (conn != null) {
				conn.disconnect();
				conn = null;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out
				.println(XpushUtil.push("d11111\r\nd22222", "Hello world!!!"));
	}
}
