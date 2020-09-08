package com.itcrazy.alanmall.mscard.util;

import com.itcrazy.alanmall.common.client.util.DateFormat;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;

public class CSVUtils {

	/** CSV文件列分隔符 */
	private static final String CSV_COLUMN_SEPARATOR = ",";

	/** CSV文件列分隔符 */
	private static final String CSV_RN = "\r\n";

	/**
	 *
	 * @param datas 数据库查出来的数据
	 * @param headerMaps csv表头
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> String formatCsvData(List<T> datas, HashMap<String, String> headerMaps
			) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		StringBuffer buf = new StringBuffer();
		// 输出表头
		for (Iterator<String> i = headerMaps.keySet().iterator(); i.hasNext();) {
			String key = i.next();
			buf.append(key).append(CSV_COLUMN_SEPARATOR);
		}
		buf.append(CSV_RN);

		if (null != datas) {
			// 输出内容
			for (T data : datas) {
				Method[] methods = data.getClass().getDeclaredMethods();

				for (Iterator<String> i = headerMaps.keySet().iterator(); i.hasNext();) {
					String key = i.next();
					String fieldName = headerMaps.get(key);

					String getMethodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
					for (Method method : methods) {
						if (method.getName().equals(getMethodName)) {
							method.setAccessible(true);
							Object obj = method.invoke(data);
							if(obj !=null && obj.toString().length() !=0) {
								buf.append(obj.toString()).append(CSV_COLUMN_SEPARATOR);
							}else{
								buf.append(CSV_COLUMN_SEPARATOR);
							};
						}
					}
				}
				buf.append(CSV_RN);
			}
		}
		return buf.toString();
	}

	/**
	 * 导出
	 * @param fileName 文件名
	 * @param content 内容
	 * @param request
	 * @param response
	 * @throws IOException
	 */
 	public static void exportCsv(String fileName, String content,HttpServletRequest request,
			HttpServletResponse response) throws IOException {

 		fileName += " " + DateFormat.dateToString(new Date()) + ".csv";

		// 读取字符编码
		String csvEncoding = "UTF-8";


		// 设置响应
		response.setCharacterEncoding(csvEncoding);
		response.setContentType("text/csv; charset=" + csvEncoding);
		response.setHeader("Pragma", "public");
		response.setHeader("Cache-Control", "max-age=30");

		final String userAgent = request.getHeader("USER-AGENT");
		if(StringUtils.contains(userAgent, "MSIE")){//IE浏览器
			 fileName = URLEncoder.encode(fileName,"UTF8");
        }else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
        	fileName = new String(fileName.getBytes(), "ISO8859-1");
        }else{
        	 fileName = URLEncoder.encode(fileName,"UTF8");//其他浏览器
        }
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

		// 写出响应
		OutputStream os = response.getOutputStream();
		// 加上UTF-8文件的标识字符
		os.write(new   byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });
		os.write(content.getBytes("UTF-8"));
		os.flush();
		os.close();
	}


 	/**
 	 * demo,请勿调用！
 	 * @param request
 	 * @param response
 	 */
 	public static void demo(HttpServletRequest request,HttpServletResponse response) {

 		String fileName = "充值.csv";

 		//csv表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    // key 为表头名， value为对象对应的属性名
	    headerMaps.put("门店入库单号", "storeInReceiptNo");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("卡类别", "categoryName");
	    headerMaps.put("卡状态", "status");
	    headerMaps.put("门店入库时间", "storeInTime");
	    headerMaps.put("门店入库操作人", "storeInPerson");

	    List<Object> dataList= new ArrayList<Object>();
		try {
			String content =  CSVUtils.formatCsvData(dataList, headerMaps);
			CSVUtils.exportCsv(fileName, content,request, response);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}