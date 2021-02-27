package com.itcrazy.alanmall.common.client.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5Util {

    public static String MD5(String str) {
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
    public static String MD5(String str, boolean upperCase) {
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

    //__________________________________new_________________________________________

    // 全局数组
    private final static String[] strDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    public static String SHA1(String decript) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes("utf-8"));
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @Author mathyoung
     * @Description: md5 加密
     * @Param: [明文]
     * @Return: 密文
     */
    public static String md5(String str) {
        String encode = DigestUtils.md2Hex(str);
        return encode;
    }


    /**
     * @Author mathyoung
     * @Description: md5 加密
     * @Param: [明文, 盐值]
     * @Return: 密文大写
     */
    public static String md5(String str, String salt) {
        String encode = DigestUtils.md2Hex(str + salt);
        return encode;
    }

    /**
     * @Author mathyoung
     * @Description: 验证新明文生成的密文是否等于旧密文
     * @Param: [str, encode, salt]
     * @Return: boolean
     */
    public static boolean verify(String str, String encode, String salt) {
        String md5text = md5(str, salt);
        return md5text.equalsIgnoreCase(encode);
    }




}
