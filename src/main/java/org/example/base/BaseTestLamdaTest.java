package org.example.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTestLamdaTest {


    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "qaenggrohit";
        String authkey = "LT_9TMzeWDguoWfPKOxY95lSyQX5lq4DyNMUQ3uVXgjlDIamWC";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Catalina");
        caps.setCapability("browserName", "Safari");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        String[] Tags = new String[]{"Feature", "Falcon", "Severe"};

        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com");

    }


    @AfterMethod
    public void tearDown() throws Exception {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }


}
