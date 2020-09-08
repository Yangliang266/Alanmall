package com.itcrazy.alanmall.mscard.util;

import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;
import java.util.List;


public class PDFUtil{

	/**
	 * 预览pdf(纵向),可下载和打印
	 * @param fileName
	 * @param tableData
	 * @param columnsWidth
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void  portraitPreview(String fileName, List<List<String>> tableData, float[] columnsWidth,
										HttpServletRequest request, HttpServletResponse response) throws Exception {
		rotatePreview(true, fileName, tableData, columnsWidth,	 request, response);
	}


	/**
	 * 预览pdf,可下载和打印
	 * @param isRotate
	 * @param fileName
	 * @param tableData
	 * @param columnsWidth
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void  rotatePreview(Boolean isRotate,String fileName,List<List<String>> tableData,float[] columnsWidth,
			HttpServletRequest request,HttpServletResponse response) throws Exception {

		if(tableData==null) {
			return;
		}
		fileName += " "+ DateFormat.dateToString(new Date());

		// 写出响应
		OutputStream os = response.getOutputStream();

		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);

        // 第一步，创建document对象
        Rectangle rectPageSize = new Rectangle(PageSize.A4);

        //下面代码设置页面横置
        if (!isRotate) {
        	 rectPageSize = rectPageSize.rotate();
		}

        //创建document对象并指定边距
        Document document = new Document(rectPageSize);
        // 第二步,将Document实例和文件输出流用PdfWriter类绑定在一起
		//从而完成向Document写，即写入PDF文档
//            PdfWriter.getInstance(document,new FileOutputStream("HelloWorld.pdf"));
		PdfWriter.getInstance(document, os);
		//第3步,打开文档
		document.open();
		//第4步,向文档添加文字. 文档由段组成

		// 设置列宽
//		float[] columnsWidth = {25f, 30f, 30f, 20f, 25f, 30f };// 设置表格的列宽和列数 默认是4列 
		PdfPTable table = new PdfPTable(columnsWidth);// 建立一个pdf表格 
		table.setSpacingBefore(20f);
		table.setWidthPercentage(100);// 设置表格宽度为100% 

		if(isRotate) {
			// 标题列
			PdfPCell titleCell = new PdfPCell();
			titleCell.setColspan(columnsWidth.length);
			Paragraph titlePar = new Paragraph(fileName , FontChinese);
			titlePar.setAlignment(Paragraph.ALIGN_CENTER);
			titleCell.addElement(titlePar);
			titleCell.setUseAscender(true);
			titleCell.setHorizontalAlignment(Paragraph.ALIGN_CENTER); //水平居中
			titleCell.setVerticalAlignment(Paragraph.ALIGN_MIDDLE); //垂直居中
			table.addCell(titleCell);

			// 内容
	    	List<String> titleData = tableData.get(0);
	    	List<String> rowData = tableData.get(1);
	        for(int j=0; j<titleData.size(); j++) {
	        	PdfPCell cell = new PdfPCell();
	        	Paragraph par = new Paragraph(titleData.get(j) , FontChinese);
	        	cell.addElement(par);
	        	cell.setUseAscender(true);
	        	cell.setVerticalAlignment(Paragraph.ALIGN_RIGHT); //垂直居中
	        	table.addCell(cell);

	        	PdfPCell cellD = new PdfPCell();
	        	Paragraph parD = new Paragraph(rowData.get(j) , FontChinese);
	        	cellD.addElement(parD);
	        	cellD.setUseAscender(true);
	        	cellD.setVerticalAlignment(Paragraph.ALIGN_LEFT); //垂直居中
	        	table.addCell(cellD);
        	}
		}else {
			// 标题列
			PdfPCell titleCell = new PdfPCell();
			titleCell.setColspan(tableData.get(0).size());
			Paragraph titlePar = new Paragraph(fileName , FontChinese);
			titlePar.setAlignment(Paragraph.ALIGN_CENTER);
			titleCell.addElement(titlePar);
			titleCell.setUseAscender(true);
			titleCell.setHorizontalAlignment(Paragraph.ALIGN_CENTER); //水平居中
			titleCell.setVerticalAlignment(Paragraph.ALIGN_MIDDLE); //垂直居中
			table.addCell(titleCell);

			// 内容
		    for(int i=0; i<tableData.size(); i++) {
		    	List<String> rowData = tableData.get(i);
		        for(int j=0; j<rowData.size(); j++) {
		        	PdfPCell cell = new PdfPCell();
		        	Paragraph par = new Paragraph(rowData.get(j) , FontChinese);
		        	cell.addElement(par);
		        	cell.setUseAscender(true);
		        	cell.setVerticalAlignment(Paragraph.ALIGN_MIDDLE); //垂直居中
		        	table.addCell(cell);
	        	}
			}
		}

		document.add(table);
        //关闭document
        document.close();

        fileName += ".pdf";
        // 读取字符编码
        String csvEncoding = "UTF-8";
		// 设置响应
		response.setCharacterEncoding(csvEncoding);
		response.setContentType("text/csv; charset=" + csvEncoding);
		response.setHeader("Pragma", "public");
		response.setHeader("Cache-Control", "max-age=30");
		final String userAgent = request.getHeader("USER-AGENT");
		if(StringUtils.contains(userAgent, "MSIE")){//IE浏览器
			fileName = URLEncoder.encode(fileName,csvEncoding);
     	}else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
    	 	fileName = new String(fileName.getBytes(),csvEncoding);
     	}else{
    	 	fileName = URLEncoder.encode(fileName,csvEncoding);//其他浏览器
     	}
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		// 加上UTF-8文件的标识字符
		os.write(new   byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });
		os.flush();
		os.close();
	}

	/**
	 * 预览pdf(横向),可下载和打印
	 * @param fileName
	 * @param tableData
	 * @param columnsWidth
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void preview(String fileName,List<List<String>> tableData,float[] columnsWidth,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		rotatePreview(false, fileName, tableData, columnsWidth, request, response);
     }


	/**
	 *
	 * @param datas 数据库查出来的数据
	 * @param headerMaps pdf表头
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> List<List<String>> formatPDFData(List<T> datas, HashMap<String, String> headerMaps
			) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		List<List<String>> table = new ArrayList<>();

		List<String> header = new ArrayList<>();

		// 输出表头
		for (Iterator<String> i = headerMaps.keySet().iterator(); i.hasNext();) {
			String key = i.next();
			header.add(key);
		}
		table.add(header);

		if (null != datas) {
			// 输出内容
			for (T data : datas) {
				Method[] methods = data.getClass().getDeclaredMethods();
				List<String> rows = new ArrayList<>();
				for (Iterator<String> i = headerMaps.keySet().iterator(); i.hasNext();) {
					String key = i.next();
					String fieldName = headerMaps.get(key);
					String getMethodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
					for (Method method : methods) {
						if (method.getName().equals(getMethodName)) {
							method.setAccessible(true);
							Object obj = method.invoke(data);
							if(obj !=null && obj.toString().length() !=0) {
								rows.add(obj.toString());
							}else{
								rows.add("");
							};
						}
					}
				}
				table.add(rows);
			}
		}
		return table;
	}
}