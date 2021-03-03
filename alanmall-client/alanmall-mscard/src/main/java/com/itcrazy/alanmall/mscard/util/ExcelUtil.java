package com.itcrazy.alanmall.mscard.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {

	/**
	 * 数据准备
	 * @param datas
	 * @param headerMaps
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> List<Object[]> formatCsvData(List<T> datas, HashMap<String, String> headerMaps
			) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		List<Object[]> objArrList = new ArrayList<>();

		if (null != datas) {
			// 输出内容
			for (T data : datas) {
				List<Object> objList=new ArrayList<Object>();
				Method[] methods = data.getClass().getDeclaredMethods();
				for (Iterator<String> i = headerMaps.keySet().iterator(); i.hasNext();) {
					String key = i.next();
					String fieldName = headerMaps.get(key);
					String getMethodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
					for (Method method : methods) {
						if (method.getName().equals(getMethodName)) {
							method.setAccessible(true);
							Object obj = method.invoke(data);
							objList.add(obj);
						}
					}
				}
				objArrList.add(objList.toArray());
			}
		}
		return objArrList;
	}

    /*
     * 导出数据
     * */
    public static void exportXls(String fileName, String title,String[] rowName,
		List<Object[]>  dataList,HttpServletRequest request, HttpServletResponse response) throws Exception{

    	fileName += ".xls";

        HSSFWorkbook workbook = new HSSFWorkbook();                        // 创建工作簿对象
        HSSFSheet sheet = workbook.createSheet(StringUtils.isNoneBlank(title)?title:"Sheet1");                     // 创建工作表

        //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】
//            HSSFCellStyle columnTopStyle = getColumnTopStyle(workbook);//获取列头样式对象
//            HSSFCellStyle style = getStyle(workbook);                    //单元格样式对象

        int rowIndex = 0;
        if (StringUtils.isNoneBlank(title)) {
        	 // 产生表格标题行
            HSSFRow rowm = sheet.createRow(rowIndex);
            HSSFCell cellTiltle = rowm.createCell(0);
            rowm.setHeight((short) (25 * 35)); //设置高度
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (rowName.length-1)));
//          cellTiltle.setCellStyle(columnTopStyle);
            cellTiltle.setCellValue(title);
            rowIndex += 1;
		}


        // 定义所需列数
        int columnNum = rowName.length;
        HSSFRow rowRowName = sheet.createRow(rowIndex);                // 在索引2的位置创建行(最顶端的行开始的第二行)
        rowIndex += 1;
        rowRowName.setHeight((short) (25 * 25)); //设置高度

        // 将列头设置到sheet的单元格中
        for(int n=0;n<columnNum;n++){
            HSSFCell  cellRowName = rowRowName.createCell(n);                //创建列头对应个数的单元格
            cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);                //设置列头单元格的数据类型
            HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
            cellRowName.setCellValue(text);                                    //设置列头单元格的值
//                cellRowName.setCellStyle(columnTopStyle);                        //设置列头单元格样式
        }

        //将查询出的数据设置到sheet对应的单元格中
        for(int i=0;i<dataList.size();i++){

            Object[] obj = dataList.get(i);//遍历每个对象
            HSSFRow row = sheet.createRow(i+rowIndex);//创建所需的行数

            row.setHeight((short) (25 * 20)); //设置高度

            for(int j=0; j<obj.length; j++){
                HSSFCell  cell = null;   //设置单元格的数据类型
                if(j == 0){
                    cell = row.createCell(j,HSSFCell.CELL_TYPE_NUMERIC);
                    cell.setCellValue(i+1);
                }else{
                    cell = row.createCell(j,HSSFCell.CELL_TYPE_STRING);
                    if(!"".equals(obj[j]) && obj[j] != null){
                        cell.setCellValue(obj[j].toString());                        //设置单元格的值
                    }
                }
//                    cell.setCellStyle(style);                                    //设置单元格样式
            }
        }
        //让列宽随着导出的列长自动适应
        for (int colNum = 0; colNum < columnNum; colNum++) {
            int columnWidth = sheet.getColumnWidth(colNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                HSSFRow currentRow;
                //当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(colNum) != null) {
                    HSSFCell currentCell = currentRow.getCell(colNum);
                    if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        int length = currentCell.getStringCellValue().getBytes().length;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }
            }
            if(colNum == 0){
                sheet.setColumnWidth(colNum, (columnWidth-2) * 128);
            }else{
                sheet.setColumnWidth(colNum, (columnWidth+4) * 256);
            }
        }

        if(workbook !=null){
        	if(response != null) {
//                String headStr = "attachment; filename=" + fileName ;
//              response.setHeader("Content-Disposition", headStr);
//                response.setContentType("APPLICATION/OCTET-STREAM");

                response.setContentType("application/x-msdownload");
                // 解决不同浏览器下载文件名乱码
                final String userAgent = request.getHeader("USER-AGENT");
        		if(StringUtils.contains(userAgent, "MSIE")){//IE浏览器
        			 fileName = URLEncoder.encode(fileName,"UTF8");
                }else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
                	fileName = new String(fileName.getBytes(), "ISO8859-1");
                }else{
                	 fileName = URLEncoder.encode(fileName,"UTF8");//其他浏览器
                }
        		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
                OutputStream out = response.getOutputStream();
                workbook.write(out);
        	}else {
        		HSSFSheet my_worksheet = workbook.getSheetAt(0);
        		// To iterate over the rows
                Iterator<Row> rowIterator = my_worksheet.iterator();
                //We will create output PDF document objects at this point
                Document iText_xls_2_pdf = new Document();
                PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("Excel2PDF_Output.pdf"));
                iText_xls_2_pdf.open();
                //we have two columns in the Excel sheet, so we create a PDF table with two columns
                //Note: There are ways to make this dynamic in nature, if you want to.
                PdfPTable my_table = new PdfPTable(10);
                //We will use the object below to dynamically add new data to the table
                PdfPCell table_cell;
                //Loop through rows.
                while(rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        Iterator<Cell> cellIterator = row.cellIterator();
                                while(cellIterator.hasNext()) {
                                        Cell cell = cellIterator.next(); //Fetch CELL
                                        switch(cell.getCellType()) { //Identify CELL type
                                                //you need to add more code here based on
                                                //your requirement / transformations
                                        case Cell.CELL_TYPE_STRING:
                                                //Push the data from Excel to PDF Cell
                                                 table_cell=new PdfPCell(new Phrase(cell.getStringCellValue()));
                                                 //feel free to move the code below to suit to your needs
                                                 my_table.addCell(table_cell);
                                                break;
                                        }
                                        //next line
                                }

                }
                //Finally add the table to PDF document
                iText_xls_2_pdf.add(my_table);
                iText_xls_2_pdf.close();
//	                    FileOutputStream out = new FileOutputStream("D:/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() +".xls");
//	                    workbook.write(out);
//	            		out.close();
        	}
        }
    }

    /**
     * 导出xlsx
     * @param fileName
     * @param title
     * @param rowName
     * @param dataList
     * @param request
     * @param response
     * @throws Exception
     */
    public static void exportXlsx(String fileName, String title,String[] rowName,
    		List<Object[]>  dataList,HttpServletRequest request, HttpServletResponse response) throws Exception{

		fileName += ".xlsx";

		XSSFWorkbook workbook = new XSSFWorkbook();                        // 创建工作簿对象
        XSSFSheet sheet = workbook.createSheet(StringUtils.isNoneBlank(title)?title:"Sheet1");                     // 创建工作表

        //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】
//                HSSFCellStyle columnTopStyle = getColumnTopStyle(workbook);//获取列头样式对象
//                HSSFCellStyle style = getStyle(workbook);                    //单元格样式对象

        int rowIndex = 0;
        if (StringUtils.isNoneBlank(title)) {
        	 // 产生表格标题行
            XSSFRow rowm = sheet.createRow(rowIndex);
            XSSFCell cellTiltle = rowm.createCell(0);
            rowm.setHeight((short) (25 * 35)); //设置高度
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (rowName.length-1)));
//              cellTiltle.setCellStyle(columnTopStyle);
            cellTiltle.setCellValue(title);
            rowIndex += 1;
		}


        // 定义所需列数
        int columnNum = rowName.length;
        XSSFRow rowRowName = sheet.createRow(rowIndex);                // 在索引2的位置创建行(最顶端的行开始的第二行)
        rowIndex += 1;
        rowRowName.setHeight((short) (25 * 25)); //设置高度

        // 将列头设置到sheet的单元格中
        for(int n=0;n<columnNum;n++){
            XSSFCell  cellRowName = rowRowName.createCell(n);                //创建列头对应个数的单元格
            cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);                //设置列头单元格的数据类型
            XSSFRichTextString text = new XSSFRichTextString(rowName[n]);
            cellRowName.setCellValue(text);                                    //设置列头单元格的值
//                    cellRowName.setCellStyle(columnTopStyle);                        //设置列头单元格样式
        }

        //将查询出的数据设置到sheet对应的单元格中
        for(int i=0;i<dataList.size();i++){

            Object[] obj = dataList.get(i);//遍历每个对象
            XSSFRow row = sheet.createRow(i+rowIndex);//创建所需的行数

            row.setHeight((short) (25 * 20)); //设置高度

            for(int j=0; j<obj.length; j++){
                XSSFCell  cell = null;   //设置单元格的数据类型
//                if(j == 0){
//                    cell = row.createCell(j,XSSFCell.CELL_TYPE_NUMERIC);
//                    cell.setCellValue(i+1);
//                }else{
                    cell = row.createCell(j,XSSFCell.CELL_TYPE_STRING);
                    if(!"".equals(obj[j]) && obj[j] != null){
                        cell.setCellValue(obj[j].toString());                        //设置单元格的值
                    }
//                }
//                        cell.setCellStyle(style);                                    //设置单元格样式
            }
        }
        //让列宽随着导出的列长自动适应
        for (int colNum = 0; colNum < columnNum; colNum++) {
            int columnWidth = sheet.getColumnWidth(colNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                XSSFRow currentRow;
                //当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(colNum) != null) {
                    XSSFCell currentCell = currentRow.getCell(colNum);
                    if (currentCell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                        int length = currentCell.getStringCellValue().getBytes().length;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }
            }
            if(colNum == 0){
                sheet.setColumnWidth(colNum, (columnWidth-2) * 128);
            }else{
                sheet.setColumnWidth(colNum, (columnWidth+4) * 256);
            }
        }

        if(workbook !=null){
        	if(response != null) {
//                    String headStr = "attachment; filename=" + fileName ;
//                  response.setHeader("Content-Disposition", headStr);
//                    response.setContentType("APPLICATION/OCTET-STREAM");

                response.setContentType("application/x-msdownload");
                // 解决不同浏览器下载文件名乱码
                final String userAgent = request.getHeader("USER-AGENT");
        		if(StringUtils.contains(userAgent, "MSIE")){//IE浏览器
        			 fileName = URLEncoder.encode(fileName,"UTF8");
                }else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
                	fileName = new String(fileName.getBytes(), "ISO8859-1");
                }else{
                	 fileName = URLEncoder.encode(fileName,"UTF8");//其他浏览器
                }
        		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
                OutputStream out = response.getOutputStream();
                workbook.write(out);
        	}else {
        		XSSFSheet my_worksheet = workbook.getSheetAt(0);
        		// To iterate over the rows
                Iterator<Row> rowIterator = my_worksheet.iterator();
                //We will create output PDF document objects at this point
                Document iText_xls_2_pdf = new Document();
                PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("Excel2PDF_Output.pdf"));
                iText_xls_2_pdf.open();
                //we have two columns in the Excel sheet, so we create a PDF table with two columns
                //Note: There are ways to make this dynamic in nature, if you want to.
                PdfPTable my_table = new PdfPTable(10);
                //We will use the object below to dynamically add new data to the table
                PdfPCell table_cell;
                //Loop through rows.
                while(rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        Iterator<Cell> cellIterator = row.cellIterator();
                                while(cellIterator.hasNext()) {
                                        Cell cell = cellIterator.next(); //Fetch CELL
                                        switch(cell.getCellType()) { //Identify CELL type
                                                //you need to add more code here based on
                                                //your requirement / transformations
                                        case Cell.CELL_TYPE_STRING:
                                                //Push the data from Excel to PDF Cell
                                                 table_cell=new PdfPCell(new Phrase(cell.getStringCellValue()));
                                                 //feel free to move the code below to suit to your needs
                                                 my_table.addCell(table_cell);
                                                break;
                                        }
                                        //next line
                                }

                }
                //Finally add the table to PDF document
                iText_xls_2_pdf.add(my_table);
                iText_xls_2_pdf.close();
//    	                    FileOutputStream out = new FileOutputStream("D:/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() +".xls");
//    	                    workbook.write(out);
//    	            		out.close();
        	}
        }
    }

    /*
     * 列头单元格样式
     */
	private static HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

    	// 设置字体
        HSSFFont font = workbook.createFont();
		//设置字体大小
		font.setFontHeightInPoints((short)11);
		//字体加粗
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		//设置字体名字
		font.setFontName("Courier New");
		//设置样式;
		HSSFCellStyle style = workbook.createCellStyle();
		//设置底边框;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		//设置底边框颜色;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		//设置左边框;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		//设置左边框颜色;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		//设置右边框;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		//设置右边框颜色;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		//设置顶边框;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		//设置顶边框颜色;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		//在样式用应用设置的字体;
		style.setFont(font);
		//设置自动换行;
		style.setWrapText(false);
		//设置水平对齐的样式为居中对齐;
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//设置垂直对齐的样式为居中对齐;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//设置单元格背景颜色
		style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		return style;
    }

    /*
     * 列数据信息单元格样式
     */
	private static HSSFCellStyle getStyle(HSSFWorkbook workbook) {
    	// 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;
    }

}