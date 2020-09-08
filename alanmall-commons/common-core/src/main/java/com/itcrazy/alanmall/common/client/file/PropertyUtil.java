package com.itcrazy.alanmall.common.client.file;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {
	/**
	 * 读取资源文件
	 * 
	 * @author Administrator
	 * 
	 */
	private static final Log log = LogFactory.getLog(SysConfig.class);

	private static Map<String, String> commonMap = new Hashtable<String, String>();

	public PropertyUtil(String path) {
		try {
			File commonFile = new File(path);
			commonMap = SysConfig.loadProperties(commonFile);

		} catch (Exception e) {
			log.error(" getconfig error:", e);
		}

	}

	public static Hashtable<String, String> loadProperties(File propFile) {
		if (!propFile.exists())
			throw new RuntimeException("Config file <"
					+ propFile.getAbsolutePath() + "> doesn't exists.");
		Properties prop = new Properties();
		try {
			InputStream is = new FileInputStream(propFile);
			prop.load(is);
			is.close();
		} catch (IOException e) {
			log.error(" read properties:", e);
			throw new RuntimeException(e);
		}

		Hashtable<String, String> result = new Hashtable<String, String>();
		for (Object okey : prop.keySet()) {
			String key = (String) okey;
			String value = prop.getProperty(key);
			result.put(key, value);
		}
		return result;
	}

	public static String getCommonConf(String k) {
		return commonMap.get(k);
	}

}
