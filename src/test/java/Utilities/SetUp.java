package Utilities;


/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetUp  {
    public static WebDriver driver;
    PropertyUtils properties;
    //ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;
    @BeforeClass
    public void startReport(){
        //ExtentReports(String filePath,Boolean replaceExisting)
        //filepath - path of the file, in .htm or .html format - path where your report needs to generate.
        //replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
        //True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
        //False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
        extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
        //extent.addSystemInfo("Environment","Environment Name")
        extent
                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Pavan");
        //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
        //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
    }


    @BeforeMethod
    public void setUp() throws IOException {
        System.out.println("I am from Before Method");
        properties= new PropertyUtils();
       System.setProperty("webdriver.chrome.driver", "C:/ComputerDatabase/ChromeDriver/chromedriver.exe");
       driver=new ChromeDriver();
       driver.get(properties.getPropertyValue("appURL"));



    }
    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
            logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
            logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }
        // ending test
        //endTest(logger) : It ends the current test and prepares to create HTML report
        extent.endTest(logger);
    }
    public static String getScreenshot(WebDriver driver, String screenshotName,String methodName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder

        String destination = System.getProperty("user.dir") + File.separator + "screenshots/"+methodName+"/"+screenshotName+".jpeg";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        System.out.println("Destination is"+destination);
        return destination;
    }

    @AfterClass
    public void endReport(){
        System.out.println("I am from After class");
        // writing everything to document
        //flush() - to write or update test information to your report.
        extent.flush();
        //Call close() at the very end of your session to clear all resources.
        //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
        //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream.
        //Once this method is called, calling any Extent method will throw an error.
        //close() - To close all the operation

    }
    @AfterMethod
    public void tearDown()
    {
        System.out.println("I am from After Method");
        driver.quit();
    }
}
