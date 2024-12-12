package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='cartSection']/h3")
    List<WebElement> cartProducts;

    @FindBy(xpath = "//li /button[@class='btn btn-primary']")
    WebElement checkOutEle;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyProductDisplay(String productName) {
        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
        return match;
    }


    public CheckOutPage goToCheckout() {
        checkOutEle.click();
        return new CheckOutPage(driver);
    }


}
