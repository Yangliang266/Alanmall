package com.itcrazy.alanmall.common.client.file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;

@Slf4j
public class HttpDownLoad {
	public static boolean getFile(String fileUrl, String localUrl) {
		URL url = null;
		File outFile = new File(localUrl);
		OutputStream os = null;
		InputStream is = null;
		try {
			url = new URL(fileUrl);
			os = new FileOutputStream(outFile);
			is = url.openStream();
			byte[] buff = new byte[1024];
			while (true) {
				int readed = is.read(buff);
				if (readed == -1) {
					break;
				}
				byte[] temp = new byte[readed];
				System.arraycopy(buff, 0, temp, 0, readed);
				os.write(temp);
			}
			is.close();
			os.close();
		} catch (Exception e) {
			log.error("httpdownload error", e);
			return false;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("httpdownload error", e);
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					log.error("httpdownload error", e);
				}
			}
		}
		return true;
	}

}
