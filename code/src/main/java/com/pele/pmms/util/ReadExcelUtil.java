package com.pele.pmms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtil {
	
	
	/**
	 * 从excel第二行开始读取数据，将数据存入List<String[]>返回
	 * @param excelFile excel文件
	 * @param columnSize 需要读取的列数
	 * @return
	 * @throws Exception
	 */
	public static List<String[]> excelContent2Obj(File excelFile,int columnSize)throws Exception{
		List<String[]> resultList = null;//声明返回值
		InputStream is = null;//声明接收文件的输入流
		Workbook wb = null;//声明excel workbook对象
		Sheet sheet = null;//声明excel sheet对象
		if(excelFile != null){
			try {
		        String fileName = excelFile.getName();//获取文件名
		        String suffix = fileName.substring(fileName.lastIndexOf("."));//获取文件名后缀,如.xlsx
		        is = new FileInputStream(excelFile);
		        //根据后缀生成不同类型workbook对象
		        if(".xls".equals(suffix)){
					wb = new HSSFWorkbook(is);
				}else if(".xlsx".equals(suffix)){
					wb = new XSSFWorkbook(is);
				}
		        if(wb != null){
		        	resultList = new ArrayList<String[]>();//创建返回行数据集合对象
		        	sheet = wb.getSheetAt(0);
		    		int rowNum = sheet.getLastRowNum();// 得到总行数
		    		Row row = null;//声明数据行对象
		    		// 正文内容应该从第二行开始,第一行为表头的标题
		    		for (int i = 1; i <= rowNum; i++) {
		    			String[] colValArray =new String[columnSize];//声明列数据存放的数组
		    			row = sheet.getRow(i);
		    			int j = 0;
		    			while (j < columnSize) {
		    				String colVal = getCellFormatValue(row.getCell(j));//获取个单元格的值
		    				colValArray[j] = colVal;
		    				j++;
		    			}
		    			resultList.add(colValArray);//收集完一行所有单元格的值后将数组放入行集合
		    		}
		        }else{
		        	throw new Exception("文件不是Excel文件!");
		        }
			} catch (Exception e) {
				throw new Exception("读取文件出错!");
			}finally {
				sheet = null;
				wb = null;
				if(is != null){
					try {
						is.close();
					} catch (Exception e2) {
					}
				}
			}
		}else{
			throw new Exception("文件不存在!");
		}
		return resultList;
	}
	
	/**
	 * 根据Cell类型设置数据
	 * @param cell
	 * @return
	 */
	private static String getCellFormatValue(Cell cell) {
		String cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC
			case Cell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				if (DateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式
					// data格式是带时分秒的：2013-7-10 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();
					// data格式是不带带时分秒的：2013-7-10
					//Date date = cell.getDateCellValue();
					//cellvalue = date;
					cellvalue = cell.getDateCellValue().toLocaleString();
				} else {// 如果是纯数字
					// 取得当前Cell的数值
					cellvalue = numericFormat(cell.getNumericCellValue());//
				}
				break;
			}
			case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			default:// 默认的Cell值
				cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}
	
	private static String numericFormat(double numeric){
		String s = String.format("%.4f", numeric);//使用String.format格式化取整,避免出现科学计数法
		if(CommonUtil.isNotEmptyString(s) && s.indexOf(".0000") > -1){
			s = s.replace(".0000", "");
		}
		return s;
	}

	public static void main(String[] args) {
		String fileName = "D:\\temp\\工作簿1.xlsx";
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.println(suffix);
	}
	
}
