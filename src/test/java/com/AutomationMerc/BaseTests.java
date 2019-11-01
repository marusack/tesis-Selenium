package com.AutomationMerc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTests {
    protected WebDriver driver;

    @BeforeTest
    public void before(){
        driver = new ChromeDriver();
    }

    @AfterTest
    public void after(){
        //driver.quit();
    }




}