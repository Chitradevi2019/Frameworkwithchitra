package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUteObj {

	 static XSSFCell wc;
	 static XSSFSheet ws;
	 static XSSFRow wr;
	 static XSSFWorkbook wb;
	 static int rownum;
    static int colnum;
    static int sheetnum;
    static XSSFRow row;
    static XSSFCell  cell;
    static String[][] data;
    
	public static  String[][] ReadExcelData(String excelpath, String sheetname) throws IOException
	{
		File xlx  = new File (excelpath);
		FileInputStream fis = new FileInputStream(xlx);                 // Getting excel File
		
       wb= new XSSFWorkbook(fis);      // Getting the Workbook
	   sheetnum =wb.getNumberOfSheets();                                  //Getting to know how many Sheets	
	   ws = wb.getSheet(sheetname);
	rownum=  ws.getLastRowNum()+1 ;		
	 wr = ws.getRow(0);
		 colnum = wr.getLastCellNum();		
	data =new  String[rownum][colnum];

	for (int k =1;k<rownum;k++) {
			
		    row= ws.getRow(k);
			
			  for (int m =0;m<colnum;m++) {
				
		      wc =row.getCell(m);
				 
				if (wc !=null)  
				{
					  switch (wc.getCellType()) {
	                    case STRING:
	                        data[k][m] = wc.getStringCellValue();
	                        break;
	                    case NUMERIC:
	                     data[k][m] =  Double.toString(wc.getNumericCellValue() ) ;
	                        break;
	                    case BOOLEAN:
	                      data[k][m] = Boolean.toString(wc.getBooleanCellValue());
	                    	
	                        break;
					default:
						break;
	                }
							
				}
       	
				
	}	}
		return data;
	}
		

	

	public static void setCellData(String excel, String Result,  int RowNum, int ColNum) throws Exception	{
        int nuc = ColNum+1;

		row  = ws.getRow(RowNum);
        row.createCell(nuc).setCellValue(Result);
			
        FileOutputStream fileOut = new FileOutputStream(excel);
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
			}

public static void writeXL(String fPath, String fSheet, String[][] xData) throws Exception{

    	File outFile = new File(fPath);
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet osheet = wb.createSheet(fSheet);
        int xR_TS = xData.length;
        int xC_TS = xData[0].length;
    	for (int myrow = 0; myrow < xR_TS; myrow++) {
	        XSSFRow row = osheet.createRow(myrow);
	        for (int mycol = 0; mycol < xC_TS; mycol++) {
	        	XSSFCell cell = row.createCell(mycol);
	        	cell.setCellValue(xData[myrow][mycol]);
	        }
	        FileOutputStream fOut = new FileOutputStream(outFile);
	        wb.write(fOut);
	        fOut.flush();
	        fOut.close();
    	}
	
	}
		
		
		
	
		

}
