package com.itcrazy.alanmall.common.client.util;

public class MemberIdFormat {

	public static String idToString(Long memberId) {
		if (memberId == null) {
			return "";
		}

		// String formatId = "";
		String formatId = String.format("6%010d", memberId);
		// if (memberId < 10) {
		// formatId = "6000000000" + memberId;
		// }else if (memberId < 100) {
		// formatId = "600000000" + memberId;
		// }else if (memberId < 1000) {
		// formatId = "60000000" + memberId;
		// }else if (memberId < 10000) {
		// formatId = "6000000" + memberId;
		// }else if (memberId < 100000) {
		// formatId = "600000" + memberId;
		// }else if (memberId < 1000000) {
		// formatId = "60000" + memberId;
		// }else if (memberId < 10000000) {
		// formatId = "6000" + memberId;
		// }else if (memberId < 100000000) {
		// formatId = "600" + memberId;
		// }else if (memberId < 1000000000) {
		// formatId = "60" + memberId;
		// }

		return formatId;
	}
}
