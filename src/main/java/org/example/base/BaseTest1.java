package org.example.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class BaseTest1 {

    public static final String URLI = "https://rohitlamsonge_EDA1Nr:xuhy47W1dp47x7qi74LV@hub-cloud.browserstack.com/wd/hub";
public static WebDriver driver ;
    public void setUp() throws Exception {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 1);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.useDownloadDir", true);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.closeWhenDone", true);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        // You will need to find the content-type of your app and set it here.
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");

        FirefoxOptions capabilities = new FirefoxOptions();
        capabilities.setCapability("browserName", "Firefox");
        capabilities.setCapability("browserVersion", "95.0");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("os", "OS X");
        browserstackOptions.put("osVersion", "Monterey");
        browserstackOptions.put("buildName", "Selenium Java Firefox Profile");
        browserstackOptions.put("sessionName", "Selenium Java Firefox Profile");
        browserstackOptions.put("userName", "rohitlamsonge_EDA1Nr");
        browserstackOptions.put("accessKey", "xuhy47W1dp47x7qi74LV");
        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setProfile(profile);

        WebDriver driver = new RemoteWebDriver(new URL(URLI), capabilities);
    }
}
