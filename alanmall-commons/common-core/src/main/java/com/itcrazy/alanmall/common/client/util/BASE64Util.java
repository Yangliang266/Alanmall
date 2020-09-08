package com.itcrazy.alanmall.common.client.util;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@SuppressWarnings("restriction")
public class BASE64Util {
	/**
	 * 生成公私钥对
	 * @return
	 * @throws Exception
	 */
	public static KeyPair pkAndPub() throws Exception{
		KeyPairGenerator gen=KeyPairGenerator.getInstance("RSA");
		gen.initialize(1024, new SecureRandom());
		KeyPair pair=gen.generateKeyPair();
		PrivateKey pk=pair.getPrivate();
		PublicKey pub=pair.getPublic();
        KeyPair kp=new KeyPair(pub, pk);
        return kp;
	}

	/**
	 * 报文加密
	 * @param aesKey
	 * @param plainData
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public static String encryptAES(String aesKey,String plainData) throws Exception{
		BASE64Encoder encoder=new BASE64Encoder();
		KeyGenerator aesGen = KeyGenerator.getInstance("AES");
		SecureRandom secureRadmon= new SecureRandom().getInstance("SHA1PRNG");
		secureRadmon.setSeed(aesKey.getBytes());
		aesGen.init(128,secureRadmon);
		SecretKey secretKey =aesGen.generateKey();
		Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		aesCipher.init(Cipher.ENCRYPT_MODE,secretKey);
		byte[] aesData =aesCipher.doFinal(plainData.getBytes());
		String aesBase64 =encoder.encode(aesData).replaceAll("[\r\n]","");
		return aesBase64;
	}

	/**
	 * 报文解密
	 * @param aesBase64
	 * @param aesKey
	 * @return
	 * @throws Exception
	 */
	public static String decryptAES(String aesBase64,String aesKey) throws Exception{
		BASE64Decoder decoder=new BASE64Decoder();
		byte[] aesData =decoder.decodeBuffer(aesBase64);
		KeyGenerator aesGen = KeyGenerator.getInstance("AES");
		aesGen.init(128, new SecureRandom(aesKey.getBytes()));
		SecretKey secretKey = aesGen.generateKey();
		Cipher aesCipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
		aesCipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] plain =aesCipher.doFinal(aesData);
		String  decrypt=new String(plain,Charset.forName("utf-8"));
		return decrypt;
	}


	/**
	 * 生成随机密钥
	 * @return
	 */
	public static String getRandomkey(){
		SecureRandom  symkey =  new SecureRandom();
		long sym_l=symkey.nextLong();
		return ""+sym_l;
	}

	/**
	 * 密钥加密
	 * @param aesKey
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public static  String encryptRSA(String aesKey,PrivateKey pk) throws Exception{
		BASE64Encoder encoder=new BASE64Encoder();
		Cipher cipher =Cipher.getInstance("RSA/ECB/PKCs1padding");
		cipher.init(Cipher.ENCRYPT_MODE, pk);
		cipher.update(aesKey.getBytes());
		byte[] encryptData =cipher.doFinal();
		String keyBase64=encoder.encode(encryptData).replaceAll("[\r\n]","");
		return keyBase64;
	}

	/**
	 * 密钥解密
	 * @param keyBase64
	 * @param pub
	 * @return
	 * @throws Exception
	 */
	public static String decryptRSA(String keyBase64,PublicKey pub) throws Exception{
		BASE64Decoder decoder=new BASE64Decoder();
		//解密时，先使用我们的公钥解密出aes密钥
		byte[] encryptData = decoder.decodeBuffer(keyBase64);
		Cipher cipher =Cipher.getInstance("RSA/ECB/PKCs1padding");
		cipher.init(Cipher.DECRYPT_MODE,pub);
		cipher.update(encryptData);
		byte[] data=cipher.doFinal();
		String decrypt=new String(data,Charset.forName("utf-8"));
		return decrypt;
	}
	/**
	 * 转换为public Key类型
	 */
	public static PublicKey getPublicKey(String key) throws Exception {
		byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(key);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}
	/**
	 * 转换为PrivateKey类型
	 */
	public static PrivateKey getPrivateKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = (new BASE64Decoder()).decodeBuffer(key);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}

	/**
	 * 加密DES
	 * @param key
	 * @param encryptStr
	 * @return
	 * @throws Exception
	 */
	public static String encryptDES(String key, String encryptStr)
			throws Exception {
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(),"DES"));
		byte[] encryptedData = cipher.doFinal(encryptStr.getBytes("UTF-8"));
		return Base64.encodeBase64String(encryptedData);
	}

	 /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
	public static String decryptBASE64(String key) {
        byte[] bt;
        try {
            bt = (new BASE64Decoder()).decodeBuffer(key);
            return new String(bt, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
	public static String encryptBASE64(String key) {
        byte[] bt = key.getBytes();
        return (new BASE64Encoder()).encodeBuffer(bt);
    }
}
