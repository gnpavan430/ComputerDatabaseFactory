package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
     WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    @FindBy(how= How.ID,using = "add")
    public WebElement computerName;
    @FindBy(how=How.ID,using = "searchbox")
    public WebElement searchComputer;
    @FindBy(how=How.ID,using = "searchsubmit")
    public WebElement searchSubmitElement;
}
