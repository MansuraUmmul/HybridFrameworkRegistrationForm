package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
    String excelpath = "C:\\Users\\mummu\\OneDrive\\Desktop\\UserInformation.xlsx";

    public String[] readExcel() throws IOException {
        String[] data = new String[3]; 

        // path of the excel file
        FileInputStream fls = new FileInputStream(excelpath);

        // read the workbook
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(fls);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(1);

        Cell cell1 = row.getCell(0);
        String userid = cell1.getStringCellValue();

        Cell cell2 = row.getCell(1);
        String newpassword = cell2.getStringCellValue();

        Cell cell3 = row.getCell(2);
        String rptpassword = cell3.getStringCellValue();

        data[0] = userid;
        data[1] = newpassword;
        data[2] = rptpassword;

        return data;
    }
}
