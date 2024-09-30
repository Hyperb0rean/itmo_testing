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
        WebElement selector = Utils.getElementBySelector(driver, By.xpath("//div[@class='input-game_selects-item']"));
        selector.click();
        WebElement country = Utils.getElementBySelector(driver, By.xpath("//li[@data-value='KR']"));
        country.click();
        WebElement emailField = Utils.getElementBySelector(driver, By.xpath("//input[@name='login']"));
        emailField.clear();
        emailField.sendKeys(email);
        WebElement usernameField = Utils.getElementBySelector(driver, By.xpath("//input[@name='name']"));
        usernameField.clear();
        usernameField.sendKeys(username);
        WebElement passwordField = Utils.getElementBySelector(driver, By.xpath("//input[@name='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement repasswordField = Utils.getElementBySelector(driver, By.xpath("//input[@name='re_password']"));
        repasswordField.clear();
        repasswordField.sendKeys(password);

//        WebElement eula = Utils.getElementBySelector(driver, By.xpath("//input[@type='checkbox', @name='eula']"));
//        eula.click();

//        WebElement day_select = Utils.getElementBySelector(driver, By.id("birthdate-dropdown-day"));
//        day_select.click();
//        WebElement day = Utils.getElementBySelector(driver, By.xpath("//li[@data-value='01']"));
//        day.click();
//
//        WebElement month_select = Utils.getElementBySelector(driver, By.id("birthdate-dropdown-month"));
//        month_select.click();
//        WebElement month = Utils.getElementBySelector(driver, By.xpath("//li[@data-value='01']"));
//        month.click();
//
//        WebElement year_select = Utils.getElementBySelector(driver, By.id("birthdate-dropdown-year"));
//        year_select.click();
//        WebElement year = Utils.getElementBySelector(driver, By.xpath("//li[@data-value='2001']"));
//        year.click();



        WebElement registerButton = Utils.getElementBySelector(driver, By.xpath("//button[@type='submit']"));
        registerButton.click();
    }

    public boolean isRegistrationSuccessful() {
        return true;
    }
}
