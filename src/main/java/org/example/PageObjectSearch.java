package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectSearch {
    private final WebDriverWait wait;

    private static final By SEARCH_BUTTON = By.xpath("//button[@title='Search']");
    private static final By SEARCH_INPUT = By.xpath("//input[@data-test-id='search-input']");
    private static final By RESULTS_CONTAINER = By.xpath("//ul[@data-test='search-results']");
    private static final By NO_RESULTS_MESSAGE = By.xpath("//div[@data-test='no-results']");
    private static final By COOKIE_ACCEPT_BUTTON = By.xpath("//button[contains(text(),'Accept') or contains(text(),'Got it')]");
    private static final By COOKIE_BANNER = By.className("ch2-container");

    public PageObjectSearch(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        acceptCookies();
    }

    public void acceptCookies() {
        try {
            WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(COOKIE_ACCEPT_BUTTON));
            acceptBtn.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(COOKIE_BANNER));
        } catch (TimeoutException e) {
        }
    }

    public void searchFor(String query) {
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON));
        searchBtn.click();
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT));
        input.sendKeys(query);
    }
    public boolean areResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(RESULTS_CONTAINER));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isNoResultsMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(NO_RESULTS_MESSAGE));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


}

