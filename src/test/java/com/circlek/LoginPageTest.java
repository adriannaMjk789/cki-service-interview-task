package com.circlek;

import com.circleK.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://circlek-public.github.io/cki-service-recruitment-task/");

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifySuccessfulLoginWithValidCredentials() {
        loginPage.login("test01@example.com", "pass123");

        assertTrue(loginPage.isLoginSuccessMessageVisible(), "\"Login successful\" message is not displyed.");
    }
}
