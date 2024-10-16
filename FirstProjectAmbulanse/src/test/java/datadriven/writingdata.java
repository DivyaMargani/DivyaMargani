package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class writingdata {
	public static void main(String[] args) throws IOException {
        // Create a new workbook (XSSFWorkbook for .xlsx files)
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create a sheet within the workbook
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        // Create a row in the sheet
        XSSFRow headerRow = sheet.createRow(0);

        // Create cells in the header row and set values
        XSSFCell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("ID");
        XSSFCell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("Name");

        // Create another row to store data
        XSSFRow dataRow = sheet.createRow(1);
        XSSFCell dataCell1 = dataRow.createCell(0);
        dataCell1.setCellValue(1);  // Example ID
        XSSFCell dataCell2 = dataRow.createCell(1);
        dataCell2.setCellValue("John Doe");  // Example Name

        // Write the data to a file
        try (FileOutputStream fileOut = new FileOutputStream("example.xlsx")) {
            workbook.write(fileOut);  // Save the workbook to a file
        }

        // Close the workbook
        workbook.close();

        System.out.println("Excel file written successfully!");
    }
}