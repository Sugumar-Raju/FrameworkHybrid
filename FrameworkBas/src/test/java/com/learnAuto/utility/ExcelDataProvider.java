package com.learnAuto.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelDataProvider {

	XSSFWorkbook wb;
	
public ExcelDataProvider() throws IOException
{
	File src =new File("./TestData/Data.xlsx");
	FileInputStream fis = new FileInputStream(src);
	wb= new XSSFWorkbook(fis);
}

public String getStringData(String SheetName, int row, int column)
{
	
return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
}

public double getNumData(String SheetName, int row, int column)
{
	
return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
}


}
