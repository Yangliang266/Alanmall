package com.itcrazy.alanmall.common.client.project;

public class WebProjectName {
	private static String name;

	public static String getProjectName() {
		return name;
	}

	public String getName() {
		return name;
	}

	@SuppressWarnings("static-access")
	public void setName(String name) {
		this.name = name;
	}
}
