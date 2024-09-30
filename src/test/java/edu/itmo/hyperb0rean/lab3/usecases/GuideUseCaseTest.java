package edu.itmo.hyperb0rean.lab3.usecases;

import edu.itmo.hyperb0rean.lab3.model.HomePage;
import edu.itmo.hyperb0rean.lab3.model.GuidePage;
import edu.itmo.hyperb0rean.lab3.util.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuideUseCaseTest {

    @BeforeAll
    static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    void testSearch() {
        Utils.getDrivers().forEach(this::executeWithCapabilities);
    }

    private void executeWithCapabilities(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        GuidePage guidePage = homePage.goToSearchPage();
        guidePage.open();
        assertTrue(guidePage.isSearchResultDisplayed());
        driver.quit();
    }
}
