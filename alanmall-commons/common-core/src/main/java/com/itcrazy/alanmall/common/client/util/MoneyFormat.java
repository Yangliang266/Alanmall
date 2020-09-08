package com.itcrazy.alanmall.common.client.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MoneyFormat {

	public static String doubleToString(Double amount) {
		if (amount == null) {
			return "0.00";
		}
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(amount);

	}

	public static String bigDecimalToString(BigDecimal bd) {
		if (bd == null) {
			return "0.00";
		}
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP).toString();

	}

}
