package libraryy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 

public class ReadFromExcel {
	XSSFWorkbook book1;
	XSSFSheet sheet1;
	
	public ReadFromExcel(String filepath) throws Exception 
		   {
		
		//String filepath=System.getProperty("user.dir")+"\\src\\main\\java\\libraryy\\logindetails.xlsx";
		//FileInputStream read= new FileInputStream(filepath);
				
			File ld= new File(filepath);
			FileInputStream inputfile= new FileInputStream(ld);
			book1= new XSSFWorkbook(inputfile);
			}
			
			public int getSheet(int sn) 
			{
			int rn =book1.getSheetAt(sn).getLastRowNum();
			rn++;
			return rn;	
			}
			//sn=sheet number; cn-=cell number rn= row number
			public String getData(int sn, int rn, int cn) 
			{
			sheet1 = book1.getSheetAt(sn);
			String data = sheet1.getRow(rn).getCell(cn).getStringCellValue();
			return data;
			}
			

		
	
}
