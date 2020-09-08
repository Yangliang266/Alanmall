package com.itcrazy.alanmall.common.client.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class HttpRequest {

	public static String sendUrl(String urlStr, String params) {

		HttpURLConnection conn = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			URL realUrl = new URL(urlStr);
			// 打开和URL之间的连接
			conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestMethod("POST");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("ContentType", "text/plain;charset=UTF-8");

			// 连接超时
			conn.setConnectTimeout(15000);
			// 读取超时
			conn.setReadTimeout(15000);

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(params);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			String line = "";
			StringBuffer result = new StringBuffer();
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} catch (SocketTimeoutException se) {
			log.error("=====访问超时====URL: " + urlStr + ", ERROR: "
					+ se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
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
		return null;
	}

	/**
	 * http post请求（无响应的）
	 */
	public static void sendUrlNoResponse(String urlStr, String params) {

		HttpURLConnection conn = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			URL realUrl = new URL(urlStr);
			// 打开和URL之间的连接
			conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestMethod("POST");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("ContentType", "text/plain;charset=UTF-8");

			// 连接超时
			conn.setConnectTimeout(15000);

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(params);
			// flush输出流的缓冲
			out.flush();

			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			String line = "";
			StringBuffer result = new StringBuffer();
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			log.info("response result: " + result);
		} catch (SocketTimeoutException se) {
			log.error("=====访问超时====URL: " + urlStr + ", ERROR: "
					+ se.getMessage());
		} catch (Exception e) {
			// e.printStackTrace();
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

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		URLConnection connection = null;
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段

			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.error("发送GET请求出现异常！" + e);
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			if (connection != null) {
				connection = null;
			}
		}
		return result;
	}

	/**
	 * 向指定url发送post请求并带微信支付证书
	 * 
	 * @param url
	 * @param param
	 * @param mchId
	 *            微信支付分配的商户号
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 */
	public static String sendPostWithCert(String url, String param, Long mchId)
			throws IllegalStateException, IOException, KeyStoreException,
			NoSuchAlgorithmException, CertificateException,
			KeyManagementException, UnrecoverableKeyException {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		// String path =
		// System.getenv("meishi_config_path")+"/wechatpay/"+mchId+".p12";
		String path = "/var/www/config/wechatpay/" + mchId + ".p12";
		FileInputStream instream = new FileInputStream(new File(path));
		try {
			keyStore.load(instream, mchId.toString().toCharArray());
		} finally {
			instream.close();
		}

		// Trust own CA and all self-signed certs
		SSLContext sslcontext = SSLContexts.custom()
				.loadKeyMaterial(keyStore, mchId.toString().toCharArray())
				.build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		CloseableHttpClient httpclient = HttpClients.custom()
				.setSSLSocketFactory(sslsf).build();
		StringBuilder sb = new StringBuilder();
		try {

			HttpPost httpPost = new HttpPost(url);

			// param 为参数
			StringEntity rentity = new StringEntity(param);
			rentity.setContentType("application/x-www-form-urlencoded");
			httpPost.setEntity(rentity);

			CloseableHttpResponse response = httpclient.execute(httpPost);

			try {
				HttpEntity entity = response.getEntity();

				if (entity != null) {
					System.out.println("Response content length: "
							+ entity.getContentLength());
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(entity.getContent()));
					String text;
					while ((text = bufferedReader.readLine()) != null) {
						sb.append(text);
					}

				}
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		return sb.toString();
	}

	public static String sendHttpsPost(String url, String params) {
		DataOutputStream out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		URL u = null;
		HttpsURLConnection con = null;
		// 尝试发送请求
		try {
			System.out.println(params);
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
					new java.security.SecureRandom());
			u = new URL(url);
			// 打开和URL之间的连接
			con = (HttpsURLConnection) u.openConnection();
			// 设置通用的请求属性
			con.setSSLSocketFactory(sc.getSocketFactory());
			con.setHostnameVerifier(new TrustAnyHostnameVerifier());
			// con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json"); //
			con.setUseCaches(false);
			// 发送POST请求必须设置如下两行
			con.setDoOutput(true);
			con.setDoInput(true);

			con.connect();
			out = new DataOutputStream(con.getOutputStream());
			out.write(params.getBytes("UTF-8"));
			// 刷新、关闭
			out.flush();
			out.close();
			// 读取返回内容
			// InputStream is = con.getInputStream();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(con.getInputStream(),
					"UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line).append(System.lineSeparator());
			}
			System.out.println(result);
			return result.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
				if (con != null) {
					con.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result.toString();
	}

	private static class TrustAnyTrustManager implements X509TrustManager {

		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}

	}

	private static class TrustAnyHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}

	public final static String MD5(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			} else {
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
			}
		}

		return md5StrBuff.toString();
	}

	public static void main(String[] args) {

		HttpURLConnection conn = null;
		OutputStream out = null;
		InputStream in = null;

		try {
			URL realUrl = new URL("http://xpush.voicecloud.cn/rest/3.0/push.do");
			// 打开和URL之间的连接
			conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestMethod("POST");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			List<String> params = new ArrayList<String>();
			// params.add("appid=" + URLEncoder.encode("58d9c01d","UTF-8"));
			// params.add("did=" + URLEncoder.encode("d1383482453","UTF-8"));
			// params.add("push_type=" + URLEncoder.encode("0","UTF-8"));
			// // params.add("message=" +
			// URLEncoder.encode("{'content':'world'}","UTF-8"));
			// params.add("extra_content=" +
			// URLEncoder.encode("Hello world","UTF-8"));
			// params.add("timestamp=" +
			// URLEncoder.encode((System.currentTimeMillis() /
			// 1000)+"","UTF-8"));
			// params.add("msg_type="+ URLEncoder.encode("1","UTF-8"));

			params.add("appid=" + URLEncoder.encode("58d9c01d", "UTF-8"));
			params.add("did="
					+ URLEncoder.encode("d1383482453\r\nd1383482458", "UTF-8"));
			params.add("push_type=" + URLEncoder.encode("2", "UTF-8"));
			params.add("extra_content="
					+ URLEncoder.encode("Hello world", "UTF-8"));
			params.add("timestamp="
					+ URLEncoder.encode((System.currentTimeMillis() / 1000)
							+ "", "UTF-8"));
			params.add("msg_type=" + URLEncoder.encode("1", "UTF-8"));

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
			md5params.add("appid=58d9c01d");
			md5params.add("did=d1383482453\r\nd1383482458");
			md5params.add("push_type=2");
			// md5params.add("message={'content':'world'}");
			md5params.add("extra_content=Hello world");
			md5params.add("timestamp=" + System.currentTimeMillis() / 1000);
			md5params.add("msg_type=1");

			Collections.sort(md5params);

			StringBuilder sbMd5Param = new StringBuilder();
			for (String str : md5params) {
				sbMd5Param.append(str);
			}

			String md5Str = "POSTxpush.voicecloud.cn/rest/3.0/push.do"
					+ sbMd5Param.toString()
					+ "07b870b9018b908d0d5018d962871b09";
			System.out.println("---before md5: " + md5Str);
			String sign = MD5(md5Str);
			String strParam = sbParam.toString() + "&sign=" + sign;
			System.out.println("----原始Params: " + strParam);
			System.out.println("----Encoded Params: " + strParam);

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
			System.out.println("=========result====" + result.toString());
		} catch (SocketTimeoutException se) {
			log.error("ERROR: " + se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
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

		// // String s = HttpRequest
		// // .sendUrl(
		// //
		// "http://www.wangxiangyuan.com/wxy.dingcan800.com/public/getStoreListAll.php?ini=89860f15eea9d7a997a756f86323e80d&brand=1&pageNum=3",
		// // "");
		//
		// String tt = HttpRequest
		// .sendUrl(
		// "http://www.wangxiangyuan.com/wxy.dingcan800.com/public/getStoreListAll.php",
		// "ini=89860f15eea9d7a997a756f86323e80d&brand=1&pageNum=3");
		//
		// String s = tt.substring(3);
		// s = "[{" + s;
		// //s =
		// "[{\"cityId\":\"5\",\"cityName\":\"\u5929\u6d25\",\"cityImg\":\"http:\\/\\/www.southmemory.com\\/wxy.dingcan800.com\\/city\\/city_5_e5fef61d195ce3921e5e827075b523d7.jpg\"}]";
		//
		// System.out.println(tt);
		// System.out.println(s);
		// JSONArray ct = null;
		// try {
		// ct = JSONArray.fromObject(tt);
		// } catch(Exception e) {
		//
		// System.out.println(e.getMessage());
		// }
		// String p =
		// "<xml><ToUserName><![CDATA[gh_6ba1b9c0ccce]]></ToUserName><FromUserName><![CDATA[oo9HFvkeIr56gMk-tsa3VFOkL4P0]]></FromUserName><CreateTime>1459209599</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[user_get_card]]></Event><CardId><![CDATA[po9HFvnqRVpUdw_TS61AQNU6Tyws]]></CardId><IsGiveByFriend>0</IsGiveByFriend><UserCardCode><![CDATA[625932728489]]></UserCardCode><FriendUserName><![CDATA[]]></FriendUserName><OuterId>0</OuterId><OldUserCardCode><![CDATA[]]></OldUserCardCode><IsRestoreMemberCard>0</IsRestoreMemberCard></xml>";
		// //
		// sendUrlNoResponse("http://nearby.redrocks.com.cn/wxmp.php?user=bjb2016",
		// p);
		// // String r =
		// sendUrl("http://nearby.redrocks.com.cn/wxmp.php?user=bjb2016", p);
		// // String r =
		// sendUrl("http://115.28.94.210/nearby/console/wxmp.php?user=bjb2016",
		// p);
		// // System.out.println(r);
		// sendUrlNoResponse("http://115.28.94.210/nearby/console/wxmp.php?user=bjb2016",
		// p);
		//
		// try {
		// File file = new File("D:\\0401.txt");//Text文件
		// BufferedReader br = new BufferedReader(new FileReader(file));
		// String s = null;
		// String p = "";int c = 0;
		// while((s = br.readLine())!=null){//使用readLine方法，一次读一行
		// // System.out.println(s);
		// // s = s.replaceAll("\r\n", "");
		// p += s;
		//
		// if(s.startsWith("</xml>")) {
		// System.out.println(p);
		// c++;
		// System.out.println("call http..." + c);
		// // String r =
		// sendUrl("http://115.28.94.210/nearby/console/wxmp.php?user=bjb2016",
		// p);
		// // System.out.println(r);
		// String r =
		// sendUrl("http://115.28.94.210/nearby/console/wxmp.php?user=bjb2016",
		// p);
		// System.out.println(r);
		// Thread.sleep(325);
		// p = "";
		// }
		// }
		// br.close();;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// String p =
		// "<xml><ToUserName><![CDATA[gh_6ba1b9c0ccce]]></ToUserName><FromUserName><![CDATA[oo9HFviEemfEhCVNYEQx6P1SGLRk]]></FromUserName><CreateTime>1459221817</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[user_consume_card]]></Event><CardId><![CDATA[po9HFvm_2jbRHK9-0PPDQKY6YLtw]]></CardId><UserCardCode><![CDATA[810063165573]]></UserCardCode><ConsumeSource><![CDATA[FROM_MOBILE_HELPER]]></ConsumeSource><LocationName><![CDATA[]]></LocationName><StaffOpenId><![CDATA[oo9HFvlVoE4fLAxcwZFSeNkLUVhc]]></StaffOpenId><VerifyCode><![CDATA[888]]></VerifyCode><RemarkAmount><![CDATA[]]></RemarkAmount><OuterStr><![CDATA[]]></OuterStr></xml>";
		// sendUrlNoResponse("http://115.28.94.210/nearby/console/wxmp.php?user=bjb2016",
		// p);
		//
		// p =
		// "<xml><ToUserName><![CDATA[gh_6ba1b9c0ccce]]></ToUserName><FromUserName><![CDATA[oo9HFvtoOHYczMH3MwyeZi5Hy0g8]]></FromUserName><CreateTime>1459221799</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[user_consume_card]]></Event><CardId><![CDATA[po9HFvm_2jbRHK9-0PPDQKY6YLtw]]></CardId><UserCardCode><![CDATA[047469046495]]></UserCardCode><ConsumeSource><![CDATA[FROM_MOBILE_HELPER]]></ConsumeSource><LocationName><![CDATA[]]></LocationName><StaffOpenId><![CDATA[oo9HFvlVoE4fLAxcwZFSeNkLUVhc]]></StaffOpenId><VerifyCode><![CDATA[888]]></VerifyCode><RemarkAmount><![CDATA[]]></RemarkAmount><OuterStr><![CDATA[]]></OuterStr></xml>";
		//
		// String r =
		// sendUrl("http://115.28.94.210/nearby/console/wxmp.php?user=bjb2016",
		// p);
		// System.out.println(r);

		// String p =
		// "<xml><ToUserName><![CDATA[gh_6ba1b9c0ccce]]></ToUserName><FromUserName><![CDATA[oo9HFvvST8sKmXC5Wy8Cj6G3vYPE]]></FromUserName><CreateTime>1459502511</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[user_get_card]]></Event><CardId><![CDATA[po9HFvnqRVpUdw_TS61AQNU6Tyws]]></CardId><IsGiveByFriend>0</IsGiveByFriend><UserCardCode><![CDATA[640551454046]]></UserCardCode><FriendUserName><![CDATA[]]></FriendUserName><OuterId>0</OuterId><OldUserCardCode><![CDATA[]]></OldUserCardCode><IsRestoreMemberCard>0</IsRestoreMemberCard></xml>";
		// // String r =
		// test("http://115.28.94.210/nearby/console/wxmp.php?user=bjb2016", p);
		// String r =
		// rawPostRequest("http://nearby.redrocks.com.cn/wxmp.php?user=bjb2016&source=5imeishi",
		// p);
		// System.out.println(r);

	}

	// public static String rawPostRequest(String url, String data) {
	// try {
	// HttpClient httpClient = new HttpClient();
	// HttpClientParams httparams = new HttpClientParams();
	// httparams.setSoTimeout(30000);
	// httpClient.setParams(httparams);
	//
	// httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
	// "UTF-8");
	//
	// PostMethod post = new PostMethod(url);
	// NameValuePair keyVal = new NameValuePair("data", data);
	// // post.addRequestHeader("Content-Type",
	// "application/x-www-form-urlencoded; charset=UTF-8");
	// post.addRequestHeader("Content-Type","text/xml;charset=UTF-8");
	//
	// NameValuePair[] nv = { keyVal };
	// post.setRequestBody(nv);
	//
	// int code = httpClient.executeMethod(post);
	// System.out.println("code:" + code);
	// System.out.println("response:" + post.getResponseBodyAsString());
	// return code+"";
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
}
