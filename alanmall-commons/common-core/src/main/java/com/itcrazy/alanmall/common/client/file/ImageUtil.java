package com.itcrazy.alanmall.common.client.file;

import com.itcrazy.alanmall.common.client.util.RandomNumUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {

	public static String getImageName() {
		SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");
		String name = df.format(new Date()) + System.currentTimeMillis() % 1000
				+ "" + RandomNumUtil.getNumber(3);
		return name;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(ImageUtil.getImageName());
		}
	}

	/**
	 * 生成新文件名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String generateFileName(String fileName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatDate = sdf.format(new Date());
		int random = new Random().nextInt(1000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + random + extension;
	}

}
