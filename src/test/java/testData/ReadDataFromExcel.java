/*
package testData;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.*;

public class ReadDataFromExcel{

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;
    public static void main(String args[]) throws Exception {
        readDataFromExcel();
        //setCellData("Setting the value",4,4);
    }

    public static void readDataFromExcel() throws IOException {
        FileInputStream excelFile = new FileInputStream("C:\\Users\\X085271\\Downloads\\automated-testing-master@a4715cf2524\\ComputerDatabasePageFactory\\src\\test\\java\\testData\\Book1.xlsx");
        XSSFWorkbook excelworkbook =  new XSSFWorkbook(excelFile);
        XSSFSheet excelworksheet = excelworkbook.getSheet("Sheet1");
        System.out.println(excelworksheet.getRow(0).getCell(0));

            Cell cell = excelworksheet.getRow(0).getCell(0);

        System.out.println(cell);
       // System.out.println(excelworksheet.getRow(1).getCell(3));

        excelFile.close();


    }


}

*/
