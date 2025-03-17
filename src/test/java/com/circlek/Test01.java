package com.circlek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test01 {

    //CODE REVIEW - By Adrianna
    @Test
    public void assertTextOnPage(){
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://circlek-public.github.io/cki-service-recruitment-task/");

        //assert Remember Me Button
        WebElement rememeberMeLabel = driver.findElement(By.id("remember_me_label"));
        assertEquals("Remember Me", rememeberMeLabel.getText());

        //assert Sign In text
        WebElement signInButton = driver.findElement(By.className("login"));
        assertEquals("Sign In", signInButton.getText());
    }

    @Test
    public void checkRememberMeCheckBox(){
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://circlek-public.github.io/cki-service-recruitment-task/");

        //click Remember Me checkbox
        WebElement rememberMeCheckBox = driver.findElement(By.xpath("//*[contains(text(), \"Remember Me\")]/../input"));
        rememberMeCheckBox.click();

        //check if clicked
        assertEquals(rememberMeCheckBox.isSelected(), true);

    }
}