package com.Facena;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTests {
    protected WebDriver driver;

    @BeforeTest
    public void before(){
        System.setProperty("webdriver.chrome.driver","..\\testchallenge\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterTest
    public void after(){

        driver.quit();
    }


    public void resetDriverForTabs() {
        driver.quit();
        driver = new ChromeDriver();
    }

}