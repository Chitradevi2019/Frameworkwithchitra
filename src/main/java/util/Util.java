package util;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public  class Util extends BaseTest{
	
	public static int  PAGE_LOAD_WAIT_TIME = 20;
	public static int  IMPLICIT_WAIT_TIME = 20;
	
	public void switchToFrame()
	{d.switchTo().frame("mainpanel");}
			
	 @SuppressWarnings("resource")
	public static Object[][] getTestData(String excelpath, String Sheet) throws IOException
	 
	 {FileInputStream fis = null;
		File xlx  = new File (excelpath);
	      fis = new FileInputStream(xlx);                 // Getting excel File
		     // Getting the Workbook
		                              //Getting to know how many Sheets	
		  XSSFSheet  ws = new XSSFWorkbook(fis).getSheet(Sheet);
		  int rownum=  ws.getLastRowNum()+1 ;		
		  int  colnum = ws.getRow(0).getLastCellNum();		
	
	      Object[][] data =new  Object[rownum-1][colnum];
		 
		  for (int k =1;k<rownum;k++) {
          for (int m =0;m<colnum;m++) {
		  data[k-1][m] =ws.getRow(k).getCell(m).toString();
          }
          }
	return data;	  
	 }

	 public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		}

	
		
	}




