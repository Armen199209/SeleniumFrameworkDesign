package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConformationPage extends AbstractComponent {
    WebDriver driver;

    public ConformationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[@class='hero-primary']")
    WebElement confirmationMessage;

    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }

}