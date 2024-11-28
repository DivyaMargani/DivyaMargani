import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileFirst {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream file=new FileInputStream("C:\\Users\\user\\git\\repository\\FirstProjectAmbulanse\\DDT\\FirstFile.xlsx");
		Workbook w1=WorkbookFactory.create(file);
        String username= w1.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
        String password=w1.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
        
        System.out.println(username);
        System.out.println(password);
	}

}
