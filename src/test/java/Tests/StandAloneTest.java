package Tests;

import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import PageObjects.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class StandAloneTest extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String, String> input) throws IOException {
        ProductCataloguePage productCataloguePage = landingPage.loginApplication(input.get("email"),input.get("password"));

        List<WebElement> products = productCataloguePage.getProducList();
        productCataloguePage.addProductToCart(input.get("productName"));
        CartPage cartPage = productCataloguePage.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay(input.get("productName"));
        Assert.assertTrue(match);
        CheckOutPage checkOutPage = cartPage.goToCheckout();

        checkOutPage.selectCountry("india");
        ConformationPage conformationPage = checkOutPage.submitOrder();

        String confirmMessage = conformationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest() {
        ProductCataloguePage productCataloguePage = landingPage.loginApplication("arm.avagyan11@gmail.com", "Armen11!");
        OrderPage orderPage = productCataloguePage.goToOrdersPage();
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
//        OrderPage orderPage = landingPage.loginApplication("arm.avagyan11@gmail.com", "Armen11!").goToOrdersPage();
//        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));

    }


    @DataProvider
    public Object[][] getData(){
        HashMap<String, String> map = new HashMap<>();
        map.put("email", "arm.avagyan11@gmail.com");
        map.put("password", "Armen11!");
        map.put("productName", "ZARA COAT 3");

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("email", "shetty@gmail.com");
        map1.put("password", "Iamking@000");
        map1.put("productName", "ADIDAS ORIGINAL");


        return new Object[][]{{map},{map1}};
    }




//    @DataProvider
//    public Object[][] getData() {
//        return new Object[][]{
//                {"arm.avagyan11@gmail.com", "Armen11!","ZARA COAT 3"},
//                {"shetty@gmail.com", "Iamking@000","ADIDAS ORIGINAL"},
//        };
//    }


}
