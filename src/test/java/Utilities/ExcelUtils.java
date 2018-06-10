package Utilities;

        import java.io.FileInputStream;

        import java.io.FileOutputStream;

        import com.google.common.base.Verify;
        import org.apache.poi.xssf.usermodel.XSSFCell;

        import org.apache.poi.xssf.usermodel.XSSFRow;

        import org.apache.poi.xssf.usermodel.XSSFSheet;

        import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;
    private static final String filePath="C:\\Users\\X085271\\Downloads\\automated-testing-master@a4715cf2524\\ComputerDatabasePageFactory\\src\\test\\java\\testData\\Book1.xlsx";
    private static final String sheetName="Sheet1";
    public static PropertyUtils propertyUtils;

    /*public static void main(String args[]) throws Exception {
        setExcelFile(filePath,sheetName);
        System.out.println(ExcelUtils.getCellData(1,1));
        System.out.println("Current data in 1st cell is"+ExcelUtils.getCellData(0,0));
        System.out.println("Last row number is"+ExcelWSheet.getLastRowNum());

        ExcelUtils.setCellData("Result",0,0);
        ExcelWSheet.getRow(4).createCell(4).setCellValue("Pass");
        System.out.println("Data in 1st cell after setting the value"+ExcelUtils.getCellData(0,0));
        System.out.println("User directory is"+System.getProperty("user.dir"));
        System.out.println("Value in the cell is"+ExcelWSheet.getRow(4).getCell(4));

    }*/
    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    public static void setExcelFile(String Path,String SheetName) throws Exception {

        try {
            propertyUtils=new PropertyUtils();

            // Open the Excel file

            FileInputStream excelFile = new FileInputStream(propertyUtils.getPropertyValue("excelPath"));

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(excelFile);

            ExcelWSheet = ExcelWBook.getSheet(propertyUtils.getPropertyValue(propertyUtils.getPropertyValue("sheetName")));

        } catch (Exception e){

            throw (e);

        }

    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public String getCellData(String sheetName,int RowNum, int ColNum) throws Exception{
        //XSSFWorkbook ExcelWBook = new XSSFWorkbook()

        try{
            propertyUtils=new PropertyUtils();

            // Open the Excel file

            FileInputStream excelFile = new FileInputStream(propertyUtils.getPropertyValue("excelPath"));

            // Access the required test data sheet


            ExcelWBook = new XSSFWorkbook(excelFile);

           ExcelWSheet = ExcelWBook.getSheet(sheetName);

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            String CellData = Cell.getStringCellValue();


            return Cell.toString();

        }catch (Exception e){
            e.printStackTrace();
            return"";

        }

    }

    //This method is to write in the Excel cell, Row num and Col num are the parameters

    public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

        try{
            propertyUtils=new PropertyUtils();

            // Open the Excel file

            FileInputStream excelFile = new FileInputStream(propertyUtils.getPropertyValue("excelPath"));

            // Access the required test data sheet


            ExcelWBook = new XSSFWorkbook(excelFile);

            ExcelWSheet = ExcelWBook.getSheet(sheetName);

            Row  = ExcelWSheet.getRow(RowNum);

            Cell = Row.getCell(ColNum);

            if (Cell == null) {

                Cell = Row.createCell(ColNum);

                Cell.setCellValue(Result);

            } else {

                Cell.setCellValue(Result);

            }

            // Constant variables Test Data path and Test Data file name

            FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

            ExcelWBook.write(fileOut);

            fileOut.flush();

            fileOut.close();

        }catch(Exception e){

            throw (e);

        }

    }

}
