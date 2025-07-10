package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utils {
	
	
	public static FileInputStream fileInput;
	public static FileOutputStream fileOutput;
	public static XSSFWorkbook wrkbk;
	public static XSSFSheet wrksht;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle cellcolor;
	
	
	public static int getRow(String xlfile,String sheet) throws IOException
	{
		fileInput= new FileInputStream(xlfile);
		wrkbk= new XSSFWorkbook(fileInput);
		wrksht=wrkbk.getSheet(sheet);
	    int totalrows=wrksht.getLastRowNum();
		wrkbk.close();
		fileInput.close();
		return totalrows;
	}
	
	public static int cellCount(String xlfile,String sheet,int rowNum) throws IOException
	{
		fileInput= new FileInputStream(xlfile);
		wrkbk= new XSSFWorkbook(fileInput);
		wrksht=wrkbk.getSheet(sheet);
	    row=wrksht.getRow(rowNum);
	    int cellCount=row.getLastCellNum();
		wrkbk.close();
		fileInput.close();
		return cellCount;
	}
	
	public static String getCellData(String xlfile,String sheet,int rowNum, int colNum) throws IOException
	{
		fileInput= new FileInputStream(xlfile);
		wrkbk= new XSSFWorkbook(fileInput);
		wrksht=wrkbk.getSheet(sheet);
	    row=wrksht.getRow(rowNum);
	    cell=row.getCell(colNum);
	    
	    String data;
	    try
	    {
	     //data=cell.toString();//one way of converting int to string
	     DataFormatter formatter=new DataFormatter();
	     data= formatter.formatCellValue(cell);
	    }
	     
	    catch(Exception e)
	    {
	    	data="";
	    }
	    	
	    wrkbk.close();
		fileInput.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String sheet,int rowNum, int colNum,String data) throws IOException
	{
		fileInput= new FileInputStream(xlfile);
		wrkbk= new XSSFWorkbook(fileInput);
		wrksht=wrkbk.getSheet(sheet);
	    row=wrksht.getRow(rowNum);
	    cell=row.createCell(colNum);
	    cell.setCellValue(data);
	    fileOutput=new FileOutputStream(xlfile);
        wrkbk.write(fileOutput);
        wrkbk.close();
		fileInput.close();
		fileOutput.close();
	}
	
	public static void fillGreenColor(String xlfile,String sheet,int rowNum, int colNum) throws IOException
	{
		fileInput= new FileInputStream(xlfile);
		wrkbk= new XSSFWorkbook(fileInput);
		wrksht=wrkbk.getSheet(sheet);
	    row=wrksht.getRow(rowNum);
	    cell=row.getCell(colNum);
	    cellcolor=wrkbk.createCellStyle();
	    cellcolor.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	    cellcolor.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    cell.setCellStyle(cellcolor);
	    fileOutput=new FileOutputStream(xlfile);
        wrkbk.write(fileOutput);
        wrkbk.close();
		fileInput.close();
		fileOutput.close();
     }
	
	public static void fillRedColor(String xlfile,String sheet,int rowNum, int colNum) throws IOException
	{
		fileInput= new FileInputStream(xlfile);
		wrkbk= new XSSFWorkbook(fileInput);
		wrksht=wrkbk.getSheet(sheet);
	    row=wrksht.getRow(rowNum);
	    cell=row.getCell(colNum);
	    
	    cellcolor=wrkbk.createCellStyle();
	    cellcolor.setFillForegroundColor(IndexedColors.RED.getIndex());
	    cellcolor.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    cell.setCellStyle(cellcolor);
	    fileOutput=new FileOutputStream(xlfile);
        wrkbk.write(fileOutput);
        wrkbk.close();
		fileInput.close();
		fileOutput.close();
     }
	
	
	
	
	
}