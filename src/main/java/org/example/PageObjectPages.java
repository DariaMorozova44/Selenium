package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectPages {
    private final WebDriverWait wait;
    private static final By PREV_BUTTON = By.xpath("//a[@data-test='internal-link prev-page']");
    private static final By NEXT_BUTTON = By.xpath("//a[@data-test='internal-link next-page']");
    private static final By COOKIE_ACCEPT_BUTTON = By.xpath("//button[contains(text(),'Accept') or contains(text(),'Got it')]");
    private static final By COOKIE_BANNER = By.className("ch2-container");

    public PageObjectPages(WebDriver driver) {
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

    public void clickPrevPage() {
       WebElement prev = wait.until(ExpectedConditions.elementToBeClickable(PREV_BUTTON));
       prev.click();
    }
    public void clickNextPage() {
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON));
        next.click();
    }
}
