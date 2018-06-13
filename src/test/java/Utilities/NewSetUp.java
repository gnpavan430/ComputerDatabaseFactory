package Utilities;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class NewSetUp {
    public static WebDriver driver;
    PropertyUtils properties;
    public static int testCasesCount=0;
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
    public void getResult(ITestResult result){
        testCasesCount=testCasesCount+1;
        if(result.getStatus()==ITestResult.SUCCESS){

            HTMLUtility.testCaseExecutionStatus(testCasesCount,result.getName(),"Pass");

        }
        else if(result.getStatus()==ITestResult.FAILURE){
            HTMLUtility.testCaseExecutionStatus(testCasesCount,result.getName(),"Fail");
        }
        else if(result.getStatus()==ITestResult.SKIP){
            HTMLUtility.testCaseExecutionStatus(testCasesCount,result.getName(),"No Run");
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
