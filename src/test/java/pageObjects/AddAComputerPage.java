package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddAComputerPage {
    WebDriver driver;
    public AddAComputerPage(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(how=How.ID,using = "name")
    public WebElement computerName;
    @FindBy(how=How.ID,using = "introduced")
    public WebElement introducedDate;
    @FindBy(how=How.ID,using = "discontinued")
    public WebElement discontinuedDate;
    @FindBy(how=How.ID,using = "company")
    public WebElement company;
    @FindBy(how=How.XPATH,using="//input[@value='Create this computer']")
    public WebElement createThisComputer;
    @FindBy(how=How.XPATH,using="//input[@value='Save this computer']")
    public WebElement saveThisComputer;
}
