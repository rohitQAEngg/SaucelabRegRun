package org.example;


import org.example.base.BaseTestSauceLab;
import org.example.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.base.BaseTest1.driver;

public class LoginTest extends BaseTestSauceLab {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Valid login credentials
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        // Assertion to verify successful login
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("inventory.html"), "URL does not contain inventory.html");
    }

    @Test
    public void testLockedLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Invalid login credentials
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        // Assertion to verify error message
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void testInvalidUserLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Invalid login credentials
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        // Assertion to verify error message
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }
}
