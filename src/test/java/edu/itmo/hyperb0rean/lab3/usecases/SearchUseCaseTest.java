package edu.itmo.hyperb0rean.lab3.usecases;

import edu.itmo.hyperb0rean.lab3.model.HomePage;
import edu.itmo.hyperb0rean.lab3.model.SearchPage;
import edu.itmo.hyperb0rean.lab3.util.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchUseCaseTest {

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
        SearchPage searchPage = homePage.goToSearchPage();
        searchPage.searchFor("test_search_query");
        assertTrue(searchPage.isSearchResultDisplayed());
        driver.quit();
    }
}
