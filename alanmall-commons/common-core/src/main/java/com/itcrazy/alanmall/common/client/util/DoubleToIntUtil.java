package com.itcrazy.alanmall.common.client.util;

import java.math.BigDecimal;

/**
 * double转int，四舍五入
 * 
 * @author tom
 *
 */
public class DoubleToIntUtil {

	// 积分的四舍五入
	public static Integer scoreRound(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("必须是一个正整数或者0");
		}

		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");

		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).intValue();
	}
}
