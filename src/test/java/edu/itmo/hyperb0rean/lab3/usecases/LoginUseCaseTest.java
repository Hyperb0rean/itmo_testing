package edu.itmo.hyperb0rean.lab3.usecases;

import edu.itmo.hyperb0rean.lab3.model.HomePage;
import edu.itmo.hyperb0rean.lab3.model.LoginPage;
import edu.itmo.hyperb0rean.lab3.util.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginUseCaseTest {

    @BeforeAll
    static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    void testLogin() {
        Utils.getDrivers().forEach(this::executeWithCapabilities);
    }

    private void executeWithCapabilities(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("correct_username", "correct_password");
        assertTrue(loginPage.isLoginSuccessful());
        driver.quit();
    }
}
