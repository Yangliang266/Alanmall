package com.itcrazy.alanmall.common.cache.jedis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RedisCacheConfig {

	@Autowired
	public static JedisPool pool;

	public static void remove(String key) {
		Jedis redis = null;
		try {
			redis = pool.getResource();
			redis.expire(key, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeJedis(redis);
		}
	}

	private static  byte[] strToBytes(String str) {
		try {
			return str.getBytes("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public  static void set(String key, Object value, int timeOutSecond) {
		Jedis redis = null;
		try {
			redis = pool.getResource();
			redis.setex(strToBytes(key), timeOutSecond, objectToBytes(value));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			 
			closeJedis(redis);
		}
	}

	public void set(String key, Object value) {
		Jedis redis = null;
		try {
			redis = pool.getResource();
			redis.set(strToBytes(key), objectToBytes(value));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			 
			closeJedis(redis);
		}
	}
	public static String setnx(String key,int timeOutSecond) {
		Jedis redis = null;
		String ret="";
		try {
			redis = pool.getResource();
			 ret = redis.set(key, key, "NX", "PX", timeOutSecond);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			 
			closeJedis(redis);
		}
		return ret;
	}
	public static Object get(String key) {
		Jedis redis = null;
		try {
			redis = pool.getResource();
			byte[] bytes = redis.get(strToBytes(key));
			return bytesToObject(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			 
			closeJedis(redis);
		}
		return null;
	}
	
	public static String getStrValue(String key) {
		Jedis redis = null;
		try {
			redis = pool.getResource();
			return redis.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeJedis(redis);
		}
		return null;
	}

	public static  boolean isKeyExists(String key) {
		Jedis redis = null;
		try {
			redis = pool.getResource();
			boolean exists = redis.exists(key);
			return exists;
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			 
			closeJedis(redis);
		}
		return false;
	}

	public static  byte[] objectToBytes(Object obj) throws Exception {
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOut = new ObjectOutputStream(byteOutputStream);
		try {
			objectOut.writeObject(obj);
			byte[] objByte = byteOutputStream.toByteArray();
			return objByte;
		} catch (Exception e) {
			throw e;
		} finally {
			byteOutputStream.close();
			objectOut.close();
		}
	}

	private static Object bytesToObject(byte[] bytes) throws Exception {
		if (bytes == null) {
			return null;
		}
		ByteArrayInputStream byteInputStream = null;
		ObjectInputStream objectIn = null;
		try {
			byteInputStream = new ByteArrayInputStream(bytes);
			objectIn = new ObjectInputStream(byteInputStream);
			Object obj = objectIn.readObject();
			byteInputStream.close();
			objectIn.close();
			return obj;
		} catch (Exception e) {
			throw e;
		} finally {
			if (byteInputStream != null) {
				byteInputStream.close();
			}
			if (objectIn != null) {
				byteInputStream.close();
			}
		}
	}
	
	public static String getHashValue(String key, String field){
		Jedis redis = null;
		try {
			redis = pool.getResource();
			return redis.hget(key, field);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeJedis(redis);
		}
		return null;
	}

	private static void closeJedis(Jedis jedis) {
		try {
			if (jedis != null) {
				jedis.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public JedisPool getPool() {
		return pool;
	}

	public void setPool(JedisPool pool) {
		RedisCacheConfig.pool = pool;
	}
}
