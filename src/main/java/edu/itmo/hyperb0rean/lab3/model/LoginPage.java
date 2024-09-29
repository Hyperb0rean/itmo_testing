package edu.itmo.hyperb0rean.lab3.model;

import edu.itmo.hyperb0rean.lab3.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
        Utils.waitUntilPageLoads(driver, Duration.ofSeconds(5));
    }

    public void login(String username, String password) {
        WebElement usernameField = Utils.getElementBySelector(driver, By.xpath("//input[@name='login']"));
        WebElement passwordField = Utils.getElementBySelector(driver, By.xpath("//input[@name='password']"));
        WebElement loginButton = Utils.getElementBySelector(driver, By.xpath("//button[contains(text(), 'Войти')]"));

        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);

        loginButton.click();
        Utils.waitUntilPageLoads(driver, Duration.ofSeconds(5));
    }

    public boolean isLoginSuccessful() {
        WebElement profileMenu = Utils.getElementBySelector(driver, By.xpath("//a[@id='user-profile']"));
        return profileMenu.isDisplayed();
    }
}
