package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingData {

		public static void main(String[] args) throws IOException {
	        // Set up the file and input stream
	        FileInputStream file = new FileInputStream(new File("C:\\Users\\user\\eclipse-workspace\\FirstProjectAmbulanse\\example.xlsx"));

	        // Create a workbook instance
	        Workbook workbook = WorkbookFactory.create(file);

	        // Get the first sheet
	        Sheet sheet = workbook.getSheetAt(0);

	        // Get the value of a specific cell (Row 0, Column 1)
	        Row row = sheet.getRow(0);
	        Cell cell = row.getCell(0);
	        Cell celll = row.getCell(1);
	        

	        // Print the value of the cell
	        System.out.println(cell.getStringCellValue());
	        System.out.println(celll.getStringCellValue());
	        


	        // Close the file
	        file.close();

	}

}
