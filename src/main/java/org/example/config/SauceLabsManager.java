package org.example.config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsManager {
    private static final java.lang.String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME"); // From ENV variable
    private static final String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY"); // From ENV variable
    private static final String SAUCE_URL = "https://ondemand.saucelabs.com:443/wd/hub";
}