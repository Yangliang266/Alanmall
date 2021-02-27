package com.itcrazy.alanmall.common.client.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.security.Signature;
import java.util.Arrays;

/**
 * @Auther: mathyoung
 * @description:
 */
public class AESUtil {

    public static byte[] encryptAndDecrypt(byte[] buffer, String secretKey,  Integer mode) throws Exception {
        //1、加载加密处理对象，该对象会提供加密算法、秘钥生成、秘钥转换、秘钥管理等功能
        Security.addProvider(new BouncyCastleProvider());
        //2、创建秘钥对象，并指定算法
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"),"AES");
        //3、设置Cipher的加密模式，AES/ECB/PKCS7Padding BC指定算法对象（BouncyCastleProvider）
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding","BC");
        //4、初始化加密配置
        cipher.init(mode, secretKeySpec);
        //5、执行加密/解密
        return cipher.doFinal(buffer);
    }

    public static void main(String[] args) throws Exception {
        String test = "wo shi yi ge da boss";
        String key = "1234567891234567";
        byte[] bytes = encryptAndDecrypt(test.getBytes("UTF-8"), key, 1);
        String base = BASE64Util.encode(bytes);
        System.out.println(base);


        byte[] de = BASE64Util.decode(base);
        System.out.println(de);

        byte[] bytes1 = encryptAndDecrypt(de, key, 2);
//        String base1 = BASE64Util.decryptBASE64(Arrays.toString(bytes1));
        System.out.println(new String(bytes1, "utf-8"));
    }
}
