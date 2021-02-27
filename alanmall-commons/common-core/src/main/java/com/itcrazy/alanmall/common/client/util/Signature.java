package com.itcrazy.alanmall.common.client.util;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @Auther: mathyoung
 * @description:
 */
@Data
public class Signature {
    private String skey;

    private String salt;

    public Signature(String key, String salt) {
        this.skey = key;
        this.salt = salt;
    }

    /**
     * @Author mathyoung
     * @Description: 密文 -> aes解密 -> treemap -> 移除签名 -> 比较
     * @Param: [text]
     * @Return: java.util.Map<java.lang.String,java.lang.String>
     */
    public Map<String, String> security(String text, String sign) throws Exception {
        // 解密
        String encodestr = new String(AESUtil.encryptAndDecrypt(BASE64Util.decodeURL(text), skey, 2), "utf-8");
        // 转换成map
        Map<String, String> map = JSON.parseObject(encodestr, TreeMap.class);
        // 移除标记
        String signature = map.remove(sign);
        // 重新成MD5标记
        String newsignature = MD5Util.md5(JSON.toJSONString(map), salt);
        // 判断
        return signature.equals(newsignature) ? map : null;
    }

    /**
     * @Author mathyoung
     * @Description: 明文 -> md5加密 -> 存入map -> aes加密
     * @Param: [map]
     * @Return: java.lang.String
     */
    public String security(Map<String, String> map, String sign) throws Exception {
        map = JSON.parseObject(JSON.toJSONString(map), TreeMap.class);
        // md5加密
        String signature = MD5Util.md5(JSON.toJSONString(map), salt);
        // 将密文放入map
        map.put(sign, signature);
        // map -> json
        String newsign = JSON.toJSONString(map);
        // json -> aes加密
        byte[] aes = AESUtil.encryptAndDecrypt(newsign.getBytes("utf-8"), skey, 1);
        // base64加密
        return BASE64Util.encodeURL(aes);
    }

    /**
     * 随机字符串，不长于32位。
     *
     * @return
     */
    public  String getNonceStr() {
        Random random = new Random();
        return MD5Util.md5(String.valueOf(random.nextInt(10000)));
    }
}
