package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement passwordEle;

    @FindBy(id = "login")
    WebElement submit;


    @FindBy(css = ".ng-animating")
    WebElement spinner;

    @FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
    WebElement errorMessage;





    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }

    public ProductCataloguePage loginApplication(String email, String password) {
        userEmail.sendKeys(email);
        passwordEle.sendKeys(password);
        submit.click();
        waitElementToDisappear(spinner);
        return new ProductCataloguePage(driver);
    }

    public String getErrorMessage(){
        waitWebElementToAppear(errorMessage);
        return errorMessage.getText();

    }
}


