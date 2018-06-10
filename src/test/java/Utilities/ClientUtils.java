package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientUtils {
    static WebDriver driver;
    public ClientUtils(WebDriver driver){
        this.driver=driver;
    }

    public  void click(WebDriver driver, WebElement webElement) {
        try{
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        }
        catch (StaleElementReferenceException sere) {
            // simply retry finding the element in the refreshed DOM
            webElement.click();
        }


    }
    public  void sendText(WebDriver driver, WebElement webElement,String text) {
        try{
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.clear();
            webElement.sendKeys(text);
        }
        catch(Exception e){


        }


    }
    public void selectElementFromDropdown(WebDriver driver,WebElement webElement,String text){
        try{
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(webElement));
            Select selectDropdownElement = new Select(webElement);
            selectDropdownElement.selectByVisibleText(text);
        }
        catch (Exception e){

        }

    }


}
