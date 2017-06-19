/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.googledriveuploader;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Nickolas
 */
public class ChromeOption {

    private ChromeOptions options;
    private Map<String, Object> prefs = new HashMap<>();
    private WebDriver driver;

    public void ChromeOption() {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        options = new ChromeOptions();
        options.addArguments("--start-maximized");

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        driver = new org.openqa.selenium.chrome.ChromeDriver(options);
    }

    public WebDriver getDriver() {
        return driver;
    }

}
