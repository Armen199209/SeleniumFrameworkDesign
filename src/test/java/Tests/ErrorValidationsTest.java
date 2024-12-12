package Tests;

import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class ErrorValidationsTest extends BaseTest {
    @Test
    public void LoginErrorValidation() throws IOException {
        landingPage.loginApplication("11arm.avagyan11@gmail.com", "Armen11!");
        Assert.assertEquals("Incorrect email password.",landingPage.getErrorMessage());
    }
}
