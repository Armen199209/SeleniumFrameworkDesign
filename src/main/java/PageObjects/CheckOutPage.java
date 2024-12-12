package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends AbstractComponent {
    WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//div[@class='form-group'] /input[@class='input txt text-validated']")
    WebElement country;

    @FindBy (xpath = "//span[text()=' India']")
    WebElement selectCountry;

    @FindBy (xpath = "//a[@class='btnn action__submit ng-star-inserted']")
    WebElement submit;

    By results = By.cssSelector(".ta-results");


    public void selectCountry(String countryName){
        Actions action = new Actions(driver);
        action.sendKeys(country, "india").build().perform();
        waitElementToAppear(results);
        selectCountry.click();
    }

    public ConformationPage submitOrder(){
        submit.click();
        return new ConformationPage(driver);
    }




}
