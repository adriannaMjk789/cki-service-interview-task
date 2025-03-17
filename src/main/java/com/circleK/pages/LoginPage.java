package com.circleK.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriverWait wait;

    @FindBy(id = "email")
    WebElement userEmailField;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(id = "login_btn")
    WebElement signInButton;

    @FindBy(id = "message")
    WebElement loginMessage;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void login(String userEmail, String password) {
        wait.until(ExpectedConditions.visibilityOf(userEmailField)).clear();
        userEmailField.sendKeys(userEmail);

        wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
        passwordField.sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public boolean isLoginSuccessMessageVisible() {
        return isLoginMessageEqual("Login successful");
    }

    private boolean isLoginMessageEqual(String message) {
        String actualMessage = wait.until(ExpectedConditions.visibilityOf(loginMessage)).getText();
        return actualMessage.equals(message);
    }
}
