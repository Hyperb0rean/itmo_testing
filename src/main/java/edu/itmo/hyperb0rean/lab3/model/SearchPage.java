package edu.itmo.hyperb0rean.lab3.model;

import edu.itmo.hyperb0rean.lab3.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends Page {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String query) {
        WebElement searchField = Utils.getElementBySelector(driver, By.xpath("//input[@name='search']"));
        WebElement searchButton = Utils.getElementBySelector(driver, By.xpath("//button[contains(text(), 'Поиск')]"));

        searchField.clear();
        searchField.sendKeys(query);
        searchButton.click();
    }

    public boolean isSearchResultDisplayed() {
        WebElement searchResult = Utils.getElementBySelector(driver, By.xpath("//div[@class='search-result']"));
        return searchResult.isDisplayed();
    }
}
