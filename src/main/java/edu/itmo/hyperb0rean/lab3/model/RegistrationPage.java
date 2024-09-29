package edu.itmo.hyperb0rean.lab3.model;

import edu.itmo.hyperb0rean.lab3.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends Page {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void register(String username, String password, String email) {
        WebElement usernameField = Utils.getElementBySelector(driver, By.xpath("//input[@name='username']"));
        WebElement passwordField = Utils.getElementBySelector(driver, By.xpath("//input[@name='password']"));
        WebElement emailField = Utils.getElementBySelector(driver, By.xpath("//input[@name='email']"));
        WebElement registerButton = Utils.getElementBySelector(driver, By.xpath("//button[contains(text(), 'Зарегистрироваться')]"));

        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        emailField.clear();
        emailField.sendKeys(email);

        registerButton.click();
    }

    public boolean isRegistrationSuccessful() {
        WebElement confirmationMessage = Utils.getElementBySelector(driver, By.xpath("//div[@class='confirmation-message']"));
        return confirmationMessage.isDisplayed();
    }
}
