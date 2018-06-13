package testCases;

import Utilities.*;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.AddAComputerPage;
import pageObjects.HomePage;
import testData.TestCaseExecutor;
import testData.TestCaseScenario;

import java.io.File;
import java.io.IOException;

public class Computer extends NewSetUp {
    String sheetName;
    int rowNumber;

    public static String testCaseStatus="Pass";
    @Test
    public void addComputer() throws Exception {

        System.out.println("I am from Test method");
        System.out.println("Add Computer test is executed");
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        ExcelUtils excelUtils = new ExcelUtils();
        TestCaseExecutor testCaseExecutor = new TestCaseExecutor();
        //getTestScenario("addComputer");
        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        TestCaseScenario testCaseScenario =testCaseExecutor.getTestScenario(currentMethodName);
        sheetName=testCaseExecutor.getSheetName(testCaseScenario.getTestData());
        rowNumber=Integer.parseInt(testCaseExecutor.getRowNumber(testCaseScenario.getTestData()));
        AddAComputerPage addAComputerPage = PageFactory.initElements(driver,AddAComputerPage.class);
        ClientUtils clientUtils = new ClientUtils(driver);
        /*logger=extent.startTest("Adding of ComputerTest");
        logger.log(LogStatus.INFO,"Before clicking the computername");*/
        //System.out.println("Screenshot path is"+logger.addScreenCapture(SetUp.getScreenshot(driver,"Home Page")));
        String screenshotPath = System.getProperty("user.dir") + File.separator + "/screenshots/"+"screenshotName"+".jpeg";
        System.out.println("Data is"+excelUtils.getCellData(sheetName,rowNumber,0));

       // logger.log(LogStatus.INFO,logger.addScreenCapture(screenshotPath));
        clientUtils.click(driver,homePage.computerName);
        //logger.log(LogStatus.INFO,"After clicking the computername");
        //logger.log(LogStatus.INFO,logger.addScreenCapture(SetUp.getScreenshot(driver,"Add ComputerTest Page")));
        clientUtils.sendText(driver,addAComputerPage.computerName,excelUtils.getCellData(sheetName,rowNumber,0));
        clientUtils.sendText(driver,addAComputerPage.introducedDate,excelUtils.getCellData(sheetName,rowNumber,1));
        clientUtils.sendText(driver,addAComputerPage.discontinuedDate,excelUtils.getCellData(sheetName,rowNumber,2));
        clientUtils.selectElementFromDropdown(driver,addAComputerPage.company,excelUtils.getCellData(sheetName,rowNumber,3));
        clientUtils.click(driver,addAComputerPage.createThisComputer);
        //logger.log(LogStatus.INFO,"After adding the computer");
        //logger.log(LogStatus.INFO,logger.addScreenCapture(SetUp.getScreenshot(driver,"After adding ComputerTest")));

    }
    @Test
    public void updateComputer() throws Exception {

        System.out.println("I am from Test method");
        System.out.println("Add Computer test is executed");
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        ExcelUtils excelUtils = new ExcelUtils();
        TestCaseExecutor testCaseExecutor = new TestCaseExecutor();
        //getTestScenario("addComputer");
        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        TestCaseScenario testCaseScenario =testCaseExecutor.getTestScenario(currentMethodName);
        sheetName=testCaseExecutor.getSheetName(testCaseScenario.getTestData());
        rowNumber=Integer.parseInt(testCaseExecutor.getRowNumber(testCaseScenario.getTestData()));
        AddAComputerPage addAComputerPage = PageFactory.initElements(driver,AddAComputerPage.class);
        ClientUtils clientUtils = new ClientUtils(driver);
        /*logger=extent.startTest("Adding of ComputerTest");
        logger.log(LogStatus.INFO,"Before clicking the computername");*/
        //System.out.println("Screenshot path is"+logger.addScreenCapture(SetUp.getScreenshot(driver,"Home Page")));
        String screenshotPath = System.getProperty("user.dir") + File.separator + "/screenshots/"+"screenshotName"+".jpeg";
        System.out.println("Data is"+excelUtils.getCellData(sheetName,rowNumber,0));

        // logger.log(LogStatus.INFO,logger.addScreenCapture(screenshotPath));

        //logger.log(LogStatus.INFO,"After clicking the computername");
        //logger.log(LogStatus.INFO,logger.addScreenCapture(SetUp.getScreenshot(driver,"Add ComputerTest Page")));
        clientUtils.sendText(driver,addAComputerPage.computerName,excelUtils.getCellData(sheetName,rowNumber,0));
        clientUtils.click(driver,homePage.computerName);
        clientUtils.sendText(driver,addAComputerPage.introducedDate,excelUtils.getCellData(sheetName,rowNumber,1));
        clientUtils.sendText(driver,addAComputerPage.discontinuedDate,excelUtils.getCellData(sheetName,rowNumber,2));
        clientUtils.selectElementFromDropdown(driver,addAComputerPage.company,excelUtils.getCellData(sheetName,rowNumber,3));
        clientUtils.click(driver,addAComputerPage.createThisComputer);
        //logger.log(LogStatus.INFO,"After adding the computer");
        //logger.log(LogStatus.INFO,logger.addScreenCapture(SetUp.getScreenshot(driver,"After adding ComputerTest")));

    }
}
