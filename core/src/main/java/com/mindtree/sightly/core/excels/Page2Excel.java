package com.mindtree.sightly.core.excels;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.mindtree.sightly.core.excels.*;

public class Page2Excel {
	
	public List<PagePojos2> returnDataToService() throws FileNotFoundException 
	{
		XSSFWorkbook wb = null;
		FileInputStream readFile = new FileInputStream("C:\\Work Files\\ExcelsForLife\\Page1.xlsx");
		List<PagePojos2> ls=new ArrayList<PagePojos2>();
		try {
			wb = new XSSFWorkbook(readFile);
			XSSFSheet sh = wb.getSheetAt(0);
			int firstRow = sh.getFirstRowNum();
			int lastRow = sh.getLastRowNum();
			for (int i = firstRow + 1; i <= lastRow; i++) {
				XSSFRow r = sh.getRow(i);
				String pageName=r.getCell(0).getStringCellValue();
				String pagePath=r.getCell(1).getStringCellValue();
				String templatePath=r.getCell(2).getStringCellValue();
				String pageTitle=r.getCell(3).getStringCellValue();
				String category=r.getCell(4).getStringCellValue();
				String title=r.getCell(5).getStringCellValue();
				String description=r.getCell(6).getStringCellValue();
				String abt1=r.getCell(7).getStringCellValue();
				String abt2=r.getCell(8).getStringCellValue();
				String abt3=r.getCell(9).getStringCellValue();
				String price=r.getCell(10).getStringCellValue();
				String imagePath=r.getCell(11).getStringCellValue();
				String offer1=r.getCell(12).getStringCellValue();
				String offer2=r.getCell(13).getStringCellValue();
			    PagePojos2 data=new PagePojos2(pageName,pagePath,templatePath,pageTitle,category,title,description,abt1,abt2,abt3,price,imagePath,offer1,offer2);
				ls.add(data);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}
	

}
