package com.itcrazy.alanmall.common.client.file;

import com.itcrazy.alanmall.common.client.project.WebProjectName;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class SysConfig {

	private static final Log log = LogFactory.getLog(SysConfig.class);

	public static final String KEY_COMPONENT_APPID = "5i_wx_component_appid";
	public static final String KEY_COMPONENT_APPSECRET = "5i_wx_component_appsecret";
	public static final String KEY_COMPONENT_TOKEN = "5i_wx_component_token";
	public static final String KEY_COMPONENT_ENCODINGAESKEY = "5i_wx_component_encodingAesKey";

	private static Map<String, String> commonMap = new Hashtable<String, String>();

	static {
		try {
			String path = System.getenv("meishi_config_path");
			File commonFile = new File(path + "/"
					+ WebProjectName.getProjectName() + "/common.properties");
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

	public static void main(String[] args) {
		String path = System.getenv("meishi_config_path");
		System.out.println(path);
	}

}
