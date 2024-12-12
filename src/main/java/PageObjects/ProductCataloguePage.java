package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCataloguePage extends AbstractComponent {

    WebDriver driver;

    public ProductCataloguePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'mb-3')]")
    List<WebElement> products;
    @FindBy(css = ".ng-animating")
    WebElement spinner;


//    By addToCart = By.xpath("//div[@class='card-body']/button[2]");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By productsBy = By.xpath("//div[contains(@class, 'mb-3')]");
    By toastMessage = By.id("toast-container");


    public List<WebElement> getProducList() {
        waitElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        WebElement prod = getProducList().stream()
                .filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
                .findFirst().orElse(null);
        return prod;
    }

    public void addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitElementToAppear(toastMessage);
        waitElementToDisappear(spinner);
    }
}
