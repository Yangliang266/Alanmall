package com.itcrazy.alanmall.mscard.util;

import org.apache.struts2.util.StrutsTypeConverter;

import java.util.Map;

public class DoubleConvert extends StrutsTypeConverter {
	@SuppressWarnings("rawtypes")
	@Override  
    public Object convertFromString(Map context, String[] values, Class toClass) {   

        if (Double.class == toClass) {   
            String doubleStr = values[0];   
            if(doubleStr!=null&&!doubleStr.equals(""))
            {
            	 Double d = Double.parseDouble(doubleStr);   
                 return d; 
            }else{
            	 Double d = Double.parseDouble("0");   
                 return d; 
            }
        }   
        return 0;   
    }   
  
	@SuppressWarnings("rawtypes")
    @Override  
    public String convertToString(Map context, Object o) {   
        return o.toString();   
    }   
  
  public static void main(String args[])
  {
	  Double d = Double.parseDouble(""); 
	  System.out.println( d);
  }

}
