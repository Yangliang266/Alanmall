package com.itcrazy.alanmall.mscard.util;

import org.apache.struts2.util.StrutsTypeConverter;

import java.math.BigDecimal;
import java.util.Map;

public class BigDecimalConverter extends StrutsTypeConverter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		BigDecimal bd = null;
		if(BigDecimal.class ==toClass){
			String bdStr = values[0];
			if(bdStr!=null&&!"".equals(bdStr)){
				bd = new BigDecimal(bdStr);
			}else{
				//bd = BigDecimal.valueOf(-1);
			}
			return bd;
		}		
		return BigDecimal.ZERO;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		
		if(o instanceof BigDecimal){
			BigDecimal b = new BigDecimal(o.toString()).setScale(2,BigDecimal.ROUND_HALF_DOWN);
			return b.toString();
		}		
		return o.toString();
	}

}
