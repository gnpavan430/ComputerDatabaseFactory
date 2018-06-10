package test;

import Utilities.ClientUtils;
import Utilities.SetUp;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AddAComputerPage;
import pageObjects.HomePage;
//import reports.ExtentReportsClass;

import java.io.IOException;


public class Test extends SetUp
{
    public Test() throws IOException {
    }

    @org.testng.annotations.Test
    public void addComputer() throws InterruptedException {
        System.out.println("This test case is executed of Test Class");
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        AddAComputerPage addAComputerPage = PageFactory.initElements(driver,AddAComputerPage.class);
        ClientUtils clientUtils = new ClientUtils(driver);
        clientUtils.click(driver,homePage.computerName);
        clientUtils.sendText(driver,addAComputerPage.computerName,"Apple");
        clientUtils.sendText(driver,addAComputerPage.introducedDate,"1111-12-12");
        clientUtils.sendText(driver,addAComputerPage.discontinuedDate,"4444-12-12");
        clientUtils.selectElementFromDropdown(driver,addAComputerPage.company,"Netronics");
        clientUtils.click(driver,addAComputerPage.createThisComputer);
        Thread.sleep(4000);




    }
}
