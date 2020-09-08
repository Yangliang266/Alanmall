package com.itcrazy.alanmall.common.client.file;

import java.io.File;

public class FolderUtil {

	public static void appendFolder(String rootPath, String appendPath) {

		if (appendPath != null) {
			appendPath = appendPath.toLowerCase();
		}
		StringBuilder path = new StringBuilder(rootPath);

		String[] pathArr = appendPath.split("/");
		if (pathArr.length <= 1)
			return;
		for (int iFile = 0; iFile < pathArr.length; iFile++) {
			File file1;
			String str = null;
			String folder = pathArr[iFile];
			File file = new File(path.toString());
			File[] files = file.listFiles();
			if (files != null) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						if (files[i].getName().equals(folder)) {
							str = files[i].getName();
						}
					}
				}
			}
			if (str == null) {
				file1 = new File(path.append("/" + folder).toString());
				file1.mkdir();

			} else {
				path.append("/" + str);

			}
		}

	}

	public static String getImageDir(Long imageTypeId, Long imageId) {
		String appendPath = "pic/t" + imageTypeId + "/f" + (imageId / 1000)
				+ "/i" + imageId;
		return appendPath;

	}

}