import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {

	public static void main(String[] args) throws IOException {

		FileInputStream file=new FileInputStream("C:\\Users\\user\\git\\repository\\FirstProjectAmbulanse\\DDT\\FirstFile.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(file);		
		XSSFSheet sheet=book.getSheet("sheet1");
		int totalrows=sheet.getLastRowNum();
		int totalcells=sheet.getRow(0).getLastCellNum();
		System.out.println(totalrows);
		System.out.println(totalcells);
		
		for(int r=0;r<=totalrows;r++) {
			XSSFRow currentrow=sheet.getRow(r);
			
			for(int c=0;c<totalcells;c++) {
				XSSFCell currentcell=currentrow.getCell(c);
				System.out.print(currentcell.toString()+"\t");
			}
			System.out.println();
		}
	
	}

}
