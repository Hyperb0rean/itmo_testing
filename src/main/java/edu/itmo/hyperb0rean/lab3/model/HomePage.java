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
        Utils.waitUntilPageLoads(driver, Duration.ofSeconds(1));
    }

    public LoginPage goToLoginPage() {
        WebElement profile = Utils.getElementBySelector(driver, By.xpath("//a[@class='cm-user-menu-link cm-user-menu-link__unauthorised js-cm-dropdown-link js-cm-event js-cm-user-menu-link']"));
        profile.click();
        driver.get("https://worldoftanks.eu/auth/oid/new/?next=/ru/");
        Utils.waitUntilPageLoads(driver, Duration.ofSeconds(1));
        return new LoginPage(driver);
    }

    public RegistrationPage goToRegistrationPage() {
        WebElement registerButton = Utils.getElementBySelector(driver, By.xpath("//a[@class='big-button big-button__huge js-referer ga4_promo']"));
        registerButton.click();
        Utils.waitUntilPageLoads(driver, Duration.ofSeconds(1));
        return new RegistrationPage(driver);
    }

    public GuidePage goToSearchPage() {
        WebElement searchIcon = Utils.getElementBySelector(driver, By.xpath("//a[@class='sub-button sub-button__huge ga4_promo']"));
        searchIcon.click();
        return new GuidePage(driver);
    }
}
