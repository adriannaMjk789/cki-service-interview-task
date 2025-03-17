package com.circlek;

import com.circleK.pages.FormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FormTest {

    private WebDriver driver;
    private FormPage formPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://circlek-public.github.io/cki-service-recruitment-task/");

        formPage = new FormPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifySuccessfulLoginWithValidCredentials() {
        formPage.login("test01@example.com", "pass123");

        assertTrue(formPage.isLoginSuccessMessageVisible(), "\"Login successful\" message is not displyed.");
    }
}
