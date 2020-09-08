package com.itcrazy.alanmall.common.client.sms.mandaows;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AudioClient {

	// 服务器
	private String serverURl = "http://117.79.237.3:8060/webservice.asmx";

	private String sn = "";

	private String pwd = "";

	public AudioClient(String sn, String pass)
			throws UnsupportedEncodingException {
		this.sn = sn;

		this.pwd = getMD5(sn + pass);
	}

	/*
	 * 方法名称：getMD5 功 能：字符串MD5加密 参 数：待转换字符串 返 回 值：加密之后字符串
	 */
	public String getMD5(String sourceStr) throws UnsupportedEncodingException {
		String resultStr = "";
		try {
			byte[] temp = sourceStr.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(temp);
			// resultStr = new String(md5.digest());
			byte[] b = md5.digest();
			for (int i = 0; i < b.length; i++) {
				char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
						'9', 'A', 'B', 'C', 'D', 'E', 'F' };
				char[] ob = new char[2];
				ob[0] = digit[(b[i] >>> 4) & 0X0F];
				ob[1] = digit[b[i] & 0X0F];
				resultStr += new String(ob);
			}
			return resultStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * 方法名称：mdAudioSend 功 能：提交彩信基本信息 参 数：title 传真标题，mobile 手机号，txt 文本内容, content
	 * 传真base64内容，schTime 定时时间，如果不需要置为空间 返 回 值：返回一个唯一值rrid
	 */
	public String mdAudioSend(String title, String mobile, String txt,
			String content, String srcnumber, String stime) {
		String result = "";
		String soapAction = "http://tempuri.org/mdAudioSend";
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		xml += "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">";
		xml += "<soap12:Body>";
		xml += "<mdAudioSend xmlns=\"http://tempuri.org/\">";
		xml += "<sn>" + sn + "</sn>";
		xml += "<pwd>" + pwd + "</pwd>";
		xml += "<title>" + title + "</title>";
		xml += "<mobile>" + mobile + "</mobile>";
		xml += "<txt>" + txt + "</txt>";
		xml += "<content>" + content + "</content>";
		xml += "<srcnumber>" + srcnumber + "</srcnumber>";
		xml += "<stime>" + stime + "</stime>";
		xml += "</mdAudioSend>";
		xml += "</soap12:Body>";
		xml += "</soap12:Envelope>";

		URL url;
		HttpURLConnection conn = null;
		OutputStream out = null;
		BufferedReader in = null;

		try {
			url = new URL(serverURl);

			conn = (HttpURLConnection) url.openConnection();
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			bout.write(xml.getBytes("GBK"));
			byte[] b = bout.toByteArray();
			conn.setRequestProperty("Content-Length", String.valueOf(b.length));
			conn.setRequestProperty("Content-Type", "text/xml; charset=gb2312");
			conn.setRequestProperty("SOAPAction", soapAction);
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);

			out = conn.getOutputStream();
			out.write(b);

			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			while (null != (inputLine = in.readLine())) {
				Pattern pattern = Pattern
						.compile("<mdAudioSendResult>(.*)</mdAudioSendResult>");
				Matcher matcher = pattern.matcher(inputLine);
				while (matcher.find()) {
					result = matcher.group(1);
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
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
	}
}
