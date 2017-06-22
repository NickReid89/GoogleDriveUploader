package com.mycompany.googledriveuploader;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;


// All this does is set up either a headless Chrome browser or a normal browser.
public class ChromeOption {

    private ChromeOptions options;
    private Map<String, Object> prefs = new HashMap<>();
    private WebDriver driver;

    public void ChromeOption() {

    }

    public void setNormalDriver() {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        options = new ChromeOptions();
        options.addArguments("--start-maximized");

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        driver = new org.openqa.selenium.chrome.ChromeDriver(options);
    }
    
        public void setHeadlessDriver() {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nickolas\\AppData\\Local\\Google\\Chrome SxS\\Application\\chrome.exe\\");

        options = new ChromeOptions();
        options.setBinary("C:\\Users\\Nickolas\\AppData\\Local\\Google\\Chrome SxS\\Application\\chrome.exe\\");
        options.addArguments("--headless");

        //prefs.put("credentials_enable_service", false);
       // prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        driver = new org.openqa.selenium.chrome.ChromeDriver(options);
    }

    public WebDriver getDriver() {
        return driver;
    }

}
