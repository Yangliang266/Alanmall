package com.itcrazy.alanmall.common.client.util;

import com.itcrazy.alanmall.common.client.constains.PayConstants;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;

public class WechatPayUtil {

	public static String refund(Long mchId, String param, Integer isSubAccount)
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

			HttpPost httpPost = new HttpPost(PayConstants.REFUND_URL);

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

	/**
	 * 企业付款API
	 * 
	 * @param mchId
	 * @param param
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 */
	public static String transfer(Long mchId, String param)
			throws IllegalStateException, IOException, KeyStoreException,
			NoSuchAlgorithmException, CertificateException,
			KeyManagementException, UnrecoverableKeyException {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		String path = System.getenv("meishi_config_path") + "/wechatpay/"
				+ mchId + ".p12";
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

			HttpPost httpPost = new HttpPost(
					"https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers");

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

	/**
	 * 撤销订单
	 * 
	 * @param mchId
	 *            商户号（服务商的情况，是服务商的商户号）
	 * @param param
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 */
	public static String reverse(Long mchId, String param)
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

			HttpPost httpPost = new HttpPost(PayConstants.REVERSE_URL);

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

}
