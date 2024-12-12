package AbstractComponents;

import PageObjects.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractComponent
{
    public WebDriver driver;

    public Header(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    public CartPage goToCartPage() {
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
}
