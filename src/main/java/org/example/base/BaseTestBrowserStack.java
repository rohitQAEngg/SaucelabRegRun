package org.example.base;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BaseTestBrowserStack {


    public static final String URLBrowserStack = "https://rohitlamsonge_EDA1Nr:xuhy47W1dp47x7qi74LV@hub-cloud.browserstack.com/wd/hub";

    protected WebDriver driver;
    public static final String USERNAME = "rohitlamsonge_EDA1Nr";
    public static final String AUTOMATE_KEY = "xuhy47W1dp47x7qi74LV";



    @BeforeMethod
    public void setUp() throws MalformedURLException {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com");
        }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }


}
