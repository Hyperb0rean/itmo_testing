package edu.itmo.hyperb0rean.lab3.model;

import edu.itmo.hyperb0rean.lab3.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("http://worldoftanks.ru/");
        Utils.waitUntilPageLoads(driver, Duration.ofSeconds(10));
    }

    public LoginPage goToLoginPage() {
        WebElement loginButton = Utils.getElementBySelector(driver, By.xpath("//a[contains(text(), 'Вход')]"));
        loginButton.click();
        Utils.waitUntilPageLoads(driver, Duration.ofSeconds(5));
        return new LoginPage(driver);
    }

    public RegistrationPage goToRegistrationPage() {
        WebElement registerButton = Utils.getElementBySelector(driver, By.xpath("//a[contains(text(), 'Регистрация')]"));
        registerButton.click();
        Utils.waitUntilPageLoads(driver, Duration.ofSeconds(5));
        return new RegistrationPage(driver);
    }

    public SearchPage goToSearchPage() {
        WebElement searchIcon = Utils.getElementBySelector(driver, By.xpath("//button[@aria-label='Поиск']"));
        searchIcon.click();
        return new SearchPage(driver);
    }
}
