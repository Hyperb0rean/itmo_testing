package edu.itmo.hyperb0rean.lab3.model;

import edu.itmo.hyperb0rean.lab3.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class GuidePage extends Page {

    public GuidePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        Utils.waitUntilPageLoads(driver, Duration.ofSeconds(1));
        driver.get("https://worldoftanks.eu/en/content/guide/");
        Utils.waitUntilPageLoads(driver, Duration.ofSeconds(1));
    }

    public boolean isSearchResultDisplayed() {
        WebElement title = Utils.getElementBySelector(driver, By.xpath("//h1[@class='header-inner_title']"));
        return title.isDisplayed();
    }
}
