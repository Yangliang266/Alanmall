package com.itcrazy.alanmall.common.client.bs;

public class DishOrderCode {

	public static String getOrderCode(Long operatorId) {

		Long num = (System.currentTimeMillis() % 1000000000) + operatorId;
		return Long.toHexString(num).toUpperCase();
	}

	public static void main(String[] args) {
		String s = DishOrderCode.getOrderCode(1L);
		System.out.println(s);

	}// 1FF548CA
}
