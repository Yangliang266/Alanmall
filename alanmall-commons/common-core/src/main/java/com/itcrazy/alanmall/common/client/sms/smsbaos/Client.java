package com.itcrazy.alanmall.common.client.sms.smsbaos;

import com.itcrazy.alanmall.common.client.sms.mandao.SingletonMandaoClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 短信宝短信发送工具类
 * 
 * @author lukai
 *
 */
public class Client {

	/**
	 * 默认连接超时时间（毫秒）
	 */
	private static final int DFT_CONN_TIMEOUT_MS = 10000;
	/**
	 * 默认读取超时时间（毫秒）
	 */
	private static final int DFT_READ_TIMEOUT_MS = 10000;

	/**
	 * 短信发送接口URL
	 */
	private static final String SMS_SEND_URL = "http://api.smsbao.com/api/orange/sms.action";

	/**
	 * 短信宝华北地区vip通道 private static final String
	 * VIP_SMS_SEND_URL="http://vapi.smsbao.com/api/orange/sms.action";
	 */

	/**
	 * 余额获取接口URL
	 */
	private static final String SMS_BALANCE_URL = "http://api.smsbao.com/api/orange/query.action";

	/**
	 * 用户名
	 */
	private String username = "";
	/**
	 * 密码
	 */
	private String password = "";

	public Client(String _username, String _password) {
		this.username = _username;
		this.password = _password;
	}

	/**
	 * 发送短信
	 * 
	 * @param mobile
	 * @param content
	 * @return
	 */
	public String sendSMS(String mobile, String content) {
		String result = null;

		StringBuffer httpArg = new StringBuffer();
		httpArg.append("u=").append(username).append("&");
		httpArg.append("p=").append(md5(password)).append("&");
		httpArg.append("m=").append(mobile).append("&");
		httpArg.append("c=").append(encodeUrlString(content, "UTF-8"));

		result = request(SMS_SEND_URL, httpArg.toString());

		return result;
	}

	/**
	 * 查询短信账户余额 原始数据返回内容： 第一行返回 '0' 视为发送成功，其他内容为错误提示内容 如果第一行返回成功，则第二行返回
	 * '发送条数,剩余条数'
	 * 
	 * @return
	 */
	public String getBalance() {
		String result = null;

		StringBuffer httpArg = new StringBuffer();
		httpArg.append("u=").append(username).append("&");
		httpArg.append("p=").append(md5(password));

		result = request(SMS_BALANCE_URL, httpArg.toString());

		return result;
	}

	/**
	 * GET方式发起HTTP请求
	 * 
	 * @param httpUrl
	 *            请求URL
	 * @param httpArg
	 *            请求参数
	 * @return 返回内容
	 */
	public static String request(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		InputStream is = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(DFT_CONN_TIMEOUT_MS);
			connection.setReadTimeout(DFT_READ_TIMEOUT_MS);
			connection.connect();
			is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = reader.readLine();
			if (strRead != null) {
				sbf.append(strRead);
				while ((strRead = reader.readLine()) != null) {
					sbf.append("\n");
					sbf.append(strRead);
				}
			}
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
					is = null;
				}
				if (reader != null) {
					reader.close();
					reader = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 生成MD5加密值
	 * 
	 * @param plainText
	 *            字符串原文
	 * @return 字符串密文
	 */
	public static String md5(String plainText) {
		StringBuffer buf = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return buf.toString();
	}

	/**
	 * URL编码
	 * 
	 * @param str
	 *            URL字符串
	 * @param charset
	 *            字符编码名称
	 * @return 编码后的字符串
	 */
	public static String encodeUrlString(String str, String charset) {
		String strret = null;
		if (str == null)
			return str;
		try {
			strret = java.net.URLEncoder.encode(str, charset);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return strret;
	}

	public static void main(String[] args) throws Throwable {
		System.out.println(SingletonMandaoClient.getClient().getBalance());
	}

}
