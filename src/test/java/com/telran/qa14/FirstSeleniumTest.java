package com.telran.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumTest {
    WebDriver driver;  //declare everything we use
    //every test structure
    //before - setUp(){}
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize(); //to auth.open site in fullscreen
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //give time to properly manage driver

    }

    //Test
    @Test
    public void searchProductTest() {
        driver.findElement(By.name("search_query")).sendKeys("summer dresses" + Keys.ENTER);
        String text = driver.findElement(By.className("lighter")).getText();
        Assert.assertEquals(text.toLowerCase(), "\"summer dresses\"");
    }


    @AfterMethod(enabled = false) //for window not to close after
    public void tearDown() {
        driver.quit();    //quit closes fully, close just shades
    }

}
