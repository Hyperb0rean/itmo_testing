package edu.itmo.hyperb0rean.lab3.usecases;

import edu.itmo.hyperb0rean.lab3.model.HomePage;
import edu.itmo.hyperb0rean.lab3.model.RegistrationPage;
import edu.itmo.hyperb0rean.lab3.util.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationUseCaseTest {

    @BeforeAll
    static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    void testRegistration() {
        Utils.getDrivers().forEach(this::executeWithCapabilities);
    }

    private void executeWithCapabilities(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.goToRegistrationPage();
        registrationPage.register("test_user", "test_password", "test_email@example.com");
        assertTrue(registrationPage.isRegistrationSuccessful());
        driver.quit();
    }
}
