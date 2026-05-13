package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectTheme {

    private final WebDriverWait wait;

    private static final String DARK_THEME_CLASS = "theme-dark";
    private static final String LIGHT_THEME_CLASS = "theme-light";
    private static final By COOKIE_ACCEPT_BUTTON = By.xpath("//button[contains(text(),'Accept') or contains(text(),'Got it')]");
    private static final By COOKIE_BANNER = By.className("ch2-container");

    public PageObjectTheme(WebDriver driver) {
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

    public void clickThemeSwitcher() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Switch theme']")));
        element.click();
        ;
    }


    public boolean isDarkThemeActive() {
        WebElement html = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));
        String bodyClass = html.getAttribute("class");
        return bodyClass != null && bodyClass.contains(DARK_THEME_CLASS);
    }


    public boolean isLightThemeActive() {
        WebElement html = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));
        String bodyClass = html.getAttribute("class");
        return bodyClass != null && html.getAttribute("class").contains(LIGHT_THEME_CLASS);
    }

    public String getCurrentTheme() {
        return isDarkThemeActive() ? "dark" : "light";
    }
}

