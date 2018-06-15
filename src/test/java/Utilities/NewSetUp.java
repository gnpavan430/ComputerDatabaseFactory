package Utilities;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class NewSetUp {
    public static WebDriver driver;
    PropertyUtils properties;
    public static int testCasesCount=0;
    public static String screenshotsPath=System.getProperty("user.dir") + File.separator + "screenshots\\";
    @BeforeMethod
    public void setUp() throws IOException {
        System.out.println("I am from Before Method");
        properties= new PropertyUtils();
        System.setProperty("webdriver.chrome.driver", "C:/ComputerDatabase/ChromeDriver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(properties.getPropertyValue("appURL"));



    }
    @BeforeClass
    public void startReport() throws IOException {
        HTMLUtility.createHTMLTemplate();
    }
    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        testCasesCount=testCasesCount+1;
        if(result.getStatus()==ITestResult.SUCCESS){
            System.out.println(screenshotsPath+result.getName()+"\\"+"path");


            HTMLUtility.testCaseExecutionStatus(testCasesCount,result.getName(),"Pass",screenshotsPath+result.getName()+"\\");


        }
        else if(result.getStatus()==ITestResult.FAILURE){
            System.out.println(screenshotsPath+result.getName()+"\\"+"path");
            HTMLUtility.testCaseExecutionStatus(testCasesCount,result.getName(),"Fail",screenshotsPath+result.getName()+"\\");
        }
        else if(result.getStatus()==ITestResult.SKIP){
            System.out.println(screenshotsPath+result.getName()+"\\"+"path");
            HTMLUtility.testCaseExecutionStatus(testCasesCount,result.getName(),"No Run",screenshotsPath+result.getName()+"\\");
        }


    }
    @AfterMethod
    public void tearDown()
    {
        System.out.println("I am from After Method");
        driver.quit();
    }
    @AfterClass
    public void endReport() throws IOException {
        HTMLUtility.closeHTMLReport();


    }
}
