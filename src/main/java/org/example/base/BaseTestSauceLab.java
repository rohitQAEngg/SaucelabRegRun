package org.example.base;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTestSauceLab {


    private static String saucelabUsername = "oauth-qaengg.rohit-480f2";
    protected WebDriver driver;
    private static String saucelabAccesskey = "8b7c3783-30df-4fec-b95c-5efddfed8f0b";

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) throws MalformedURLException {
        AbstractDriverOptions browserOptions = null;
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", saucelabUsername);
        sauceOptions.put("accessKey", saucelabAccesskey);
        sauceOptions.put("build", "buid 0012");
        sauceOptions.put("name", "Rohit sauce lab test project");
        if (browser.equalsIgnoreCase("chrome")) {
            browserOptions = new ChromeOptions();
            // start the session
        } else if (browser.equalsIgnoreCase("firefox")) {
            browserOptions = new FirefoxOptions();
        }
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        browserOptions.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com");
    }


    @AfterMethod
    public void teardown(ITestResult result) {
        String status = result.isSuccess() ? "passed" : "failed";
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + status);
        if (driver != null) {
            driver.quit();
        }
    }
}


