package com.itcrazy.alanmall.common.client.util;

import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * 生成sign工具类
 *
 * @author XiZh on 2018年4月22日 下午2:35:17
 * @update
 */
@SuppressWarnings("restriction")
public class GetSignUtil {

	public static String createSign(String str,String key){
		try {
			return URLEncoder.encode(new BASE64Encoder().encode(encrypt(md5(str).getBytes("utf-8"), key)), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}



	public static byte[] encrypt(byte[] content, String password) {
		try {
			byte[] enCodeFormat = password.getBytes();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(1, key);
			return cipher.doFinal(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String md5(String str){
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return md5(bytes);
	}

	public static String md5(byte[] plainByte) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainByte);
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                    i = b[offset];
                    if(i<0) i+= 256;
                    if(i<16)
                    buf.append("0");
                    buf.append(Integer.toHexString(i));
            }
            return buf.toString();

        } catch (Exception e) {
                e.printStackTrace();
        }
        return null;
    }

	public static String postApplicationJson(String url, String data) throws Exception {
        try {
            StringBuilder result = new StringBuilder();
            URL urlRequest = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlRequest.openConnection();
            connection.setConnectTimeout(60 * 1000);
            connection.setReadTimeout(60 * 1000);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("content-type", "application/json");
            OutputStream out = connection.getOutputStream();
            if (data != null)
                out.write(data.getBytes("UTF-8"));
            out.flush();
            out.close();
            // 获取输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "ISO-8859-1"));
            int code = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == code) {
                String temp = in.readLine();
                /* 连接成一个字符串 */
                while (temp != null) {
                    result.append(temp);
                    temp = in.readLine();
                }
            }
            return new String(result.toString().getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

}
