package com.itcrazy.alanmall.common.client.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public final static String MD5(String str) {
        return MD5(str, true);
    }

    /**
     * MD5加密
     * 
     * @param str
     *            需加密的内容
     * @param upperCase
     *            加密值是否转换为大写字母
     * @return
     */
    public final static String MD5(String str, boolean upperCase) {
        return MD5(str, upperCase, "UTF-8");
    }

    /**
     * MD5加密
     * 
     * @param str
     *            需加密的内容
     * @param upperCase
     *            加密值是否转换为大写字母
     * @param charset
     *            Charset, 默认UTF-8
     * @return
     */
    public final static String MD5(String str, boolean upperCase, String charset) {
        if (charset == null || charset.length() == 0) {
            charset = "UTF-8";
        }
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();

            messageDigest.update(str.getBytes(charset));
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

        if (upperCase) {
            return md5StrBuff.toString().toUpperCase();
        }
        return md5StrBuff.toString();
    }
}
