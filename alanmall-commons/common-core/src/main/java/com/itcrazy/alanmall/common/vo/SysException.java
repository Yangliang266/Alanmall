package com.itcrazy.alanmall.common.vo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

/**
 * 直接读取class/sys/config/common.properties下配置文件
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("deprecation")
public class SysException {

	private static final Log log = LogFactory.getLog(SysException.class);

	private static Map<String, String> exceptionMap = new Hashtable<String, String>();

	static {
		try {
			String root = (new SysException()).getClass().getResource("/")
					.getPath();
			root = URLDecoder.decode(root);
			File commonFile = new File(root
					+ "sys/exception/exception_app.properties");
			exceptionMap = SysException.loadProperties(commonFile);

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

	public static String getCommonConf(Integer code) {
		String k = "E" + code;
		return exceptionMap.get(k);
	}

}
