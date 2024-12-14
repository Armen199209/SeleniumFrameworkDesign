package Tests;

import TestComponents.BaseTest;
import TestComponents.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class ErrorValidationsTest extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    public void LoginErrorValidation() throws IOException {
        landingPage.loginApplication("11arm.avagyan11@gmail.com", "Armen11!");
        Assert.assertEquals("Incorrect email password.",landingPage.getErrorMessage());
    }
}
