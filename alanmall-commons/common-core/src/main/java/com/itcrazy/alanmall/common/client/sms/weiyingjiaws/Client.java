package com.itcrazy.alanmall.common.client.sms.weiyingjiaws;

import com.itcrazy.alanmall.common.client.sms.weiyingjia.SingletonWeiyingjiaClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Client {
	/*
	 * webservice服务器定义
	 */

	private String userName = "";// 用户名
	private String password = "";

	/*
	 * 构造函数
	 */
	public Client(String userName, String password)
			throws UnsupportedEncodingException {
		this.userName = userName;
		this.password = password;
	}

	public static String getHttp(String myurl) throws Exception {
		URL url = new URL(myurl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("user-agent",
				"mozilla/4.0 (compatible; msie 6.0; windows 2000)");
		connection.setConnectTimeout(15000);
		connection.setReadTimeout(30000);
		connection.connect();
		StringBuffer sb = new StringBuffer();
		if (connection.getResponseCode() == 200) {
			InputStream in = connection.getInputStream();
			BufferedReader breader = new BufferedReader(new InputStreamReader(
					in, "gbk"));
			String str = breader.readLine();
			while (str != null) {
				sb.append(str);
				str = breader.readLine();
			}
			in.close();
		}
		connection.disconnect();
		connection = null;
		url = null;
		return sb.toString();
	}

	/**
	 * 发送短信
	 * 
	 * @param mobile
	 *            手机号码
	 * @param content
	 *            发送内容
	 * @return
	 */
	public String sendMessage(String mobile, String content) {

		try {
			StringBuffer sb = new StringBuffer();
			sb.append("http://sms.weiyingjia.cn:8080/dog3/httpUTF8SMS.jsp");
			sb.append("?username=" + userName);// 用户名
			sb.append("&pwd=" + password);// 密码
			sb.append("&msg=" + URLEncoder.encode(content, "utf-8"));
			sb.append("&mobile=" + mobile);// 手机号码
			sb.append("&gwid=" + "2");// 不动
			return Client.getHttp(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 发送营销短信
	 * 
	 * @param mobile
	 *            手机号码
	 * @param content
	 *            发送内容
	 * @return
	 */
	public String sendSalesMessage(String mobile, String content) {

		try {
			StringBuffer sb = new StringBuffer();
			sb.append("http://sms.weiyingjia.cn:8080/dog3/httpUTF8SMS.jsp");
			sb.append("?username=" + "tailiansc");// 用户名
			sb.append("&pwd=" + "t6y7w3f9");// 密码
			sb.append("&msg=" + URLEncoder.encode(content, "utf-8"));
			sb.append("&mobile=" + mobile);// 手机号码
			sb.append("&gwid=" + "2");// 不动
			return Client.getHttp(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/*
	 * 方法名称：getBalance 功 能：查询余额 返 回 值：余额
	 */
	public double getBalance() {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("http://sms.weiyingjia.cn:8080/dog3/httpUTF8Balance.jsp");
			sb.append("?username=" + userName);// 用户名
			sb.append("&pwd=" + password);// 密码
			String balance = Client.getHttp(sb.toString());
			return Double.parseDouble(balance);
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
	}

	/*
	 * 方法名称：getSalesBalance 功 能：查询营销帐号余额 返 回 值：余额
	 */
	public double getSalesBalance() {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("http://sms.weiyingjia.cn:8080/dog3/httpUTF8Balance.jsp");
			sb.append("?username=" + "tailiansc");// 用户名
			sb.append("&pwd=" + "t6y7w3f9");// 密码
			String balance = Client.getHttp(sb.toString());
			return Double.parseDouble(balance);
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
	}

	public static void main(String[] args) throws Throwable {
		// System.out.println(new Client("tailian",
		// "t6y7w3f9").sendMessage("18616124869", "测试验证码是：1100"));
		// System.out.println(SingletonWeiyingjiaClient.getClient().sendMessage("18616124869",
		// "亲爱的会员,您好！母亲节快乐.现赠送您20元代金券一张,欢迎光临刘巧儿使用此券,祝您用餐愉快."));
		System.out.println(new Client("tailian", "t6y7w3f9").getBalance());
		System.out.println(SingletonWeiyingjiaClient.getClient()
				.getSalesBalance());
	}
}
