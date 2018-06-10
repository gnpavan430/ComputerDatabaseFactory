package testData;

import Utilities.ExcelUtils;
import Utilities.PropertyUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

import static Utilities.ExcelUtils.propertyUtils;

public class Sample {
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;
    public static void main(String args[]) throws Exception {
        String testData = "Sheet1,1";
        String[] parts = testData.split(",");
        String part1 = parts[0]; // 004
        String part2 = parts[1];
        System.out.println("Part 1 is"+part1+"Part 2 is"+part2);
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println("Current method name is"+name);
        ExcelUtils excelUtils = new ExcelUtils();
//        ExcelUtils.setCellData("Update",1,4);
        propertyUtils=new PropertyUtils();

        // Open the Excel file

        FileInputStream excelFile = new FileInputStream(propertyUtils.getPropertyValue("excelPath"));

        // Access the required test data sheet


        ExcelWBook = new XSSFWorkbook(excelFile);

        ExcelWSheet = ExcelWBook.getSheet("Sheet1");

        //Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
        for(int i=0;i<ExcelWSheet.getLastRowNum();i++){
            System.out.println("Row is"+ExcelWSheet.getRow(i).getCell(4));
            if(ExcelWSheet.getRow(i).getCell(4).toString().equalsIgnoreCase("Update")){
                System.out.println("Test data elements are:Computer name"+ExcelWSheet.getRow(i).getCell(0));
                System.out.println("Introduced Date:"+ExcelWSheet.getRow(i).getCell(1));
                System.out.println("Discontinued date:"+ExcelWSheet.getRow(i).getCell(2));
                System.out.println("Company:"+ExcelWSheet.getRow(i).getCell(3));
                System.out.println("Integrated project with Git");
                System.out.println("Core Java");
                System.out.println("New title");