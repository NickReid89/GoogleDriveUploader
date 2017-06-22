/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.googledriveuploader;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Nickolas
 */
public class ConnectToDrive {

    protected void upload(UserData connectInfo) throws InterruptedException {
        ChromeOption co = new ChromeOption();
        co.setNormalDriver();
        co.getDriver().navigate().to("https://accounts.google.com/ServiceLogin?service=wise&passive=true&continue=http%3A%2F%2Fdrive.google.com%2F%3Futm_source%3Den_US&utm_medium=button&utm_campaign=web&utm_content=gotodrive&usp=gtd&ltmpl=drive");
        Thread.sleep(1000);
        WebElement email = co.getDriver().findElement(By.xpath(".//input[@type='email']"));
        email.sendKeys(connectInfo.getEmail());
        WebElement submit = co.getDriver().findElement(By.xpath(".//div[@role='button']"));
        submit.click();
        //replace later
        Thread.sleep(1000);
        WebElement password = co.getDriver().findElement(By.xpath(".//input[@type='password']"));
        password.sendKeys(connectInfo.getPassword());
        submit = co.getDriver().findElement(By.xpath(".//div[@id='passwordNext']"));
        submit.click();
        Thread.sleep(1000);

        if (co.getDriver().findElements(By.xpath(".//div[@class='fi tp']")).size() > 0) {
            co.getDriver().findElement(By.xpath(".//div[@role='button']")).click();
            Thread.sleep(1000);
        }

        WebElement upload = co.getDriver().findElement(By.xpath(".//button[@class='RTMQvb Kzazxf fCmhtc hc0pBf x6jRSb a-qb-d h-sb-Ic sXaDqb']"));
        Actions action = new Actions(co.getDriver());
        action.contextClick(upload).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();

        RobotUploader r = new RobotUploader(connectInfo.getDirectory());
        r.run();

        Thread.sleep(1000);
        if (co.getDriver().findElements(By.xpath(".//div[@class='he-ua']")).size() > 0) {
            if (connectInfo.isOverwrite()) {
                System.out.println("overwriting");
                co.getDriver().findElement(By.xpath(".//button[@name='yes']")).click();
            } else {
                System.out.println("not overwriting");
                co.getDriver().findElement(By.xpath(".//button[@name='no']")).click();
            }
        }

        //WORKS SO FAR
        //  driver.quit();
    }

}
