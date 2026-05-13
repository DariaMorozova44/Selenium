package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PageObjectList {

    private final WebDriverWait wait;
    private final Random random = new Random();

    private static final By TOC_CONTAINER = By.cssSelector("ul[data-test='toc']");
    private static final By COOKIE_ACCEPT_BUTTON = By.xpath("//button[contains(text(),'Accept') or contains(text(),'Got it')]");
    private static final By COOKIE_BANNER = By.className("ch2-container");

    public PageObjectList(WebDriver driver) {
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


    public List<WebElement> getTocItems() {
        WebElement toc = wait.until(ExpectedConditions.visibilityOfElementLocated(TOC_CONTAINER));
        return toc.findElements(By.tagName("li"));
    }


    public int getTocItemsCount() {
        return getTocItems().size();
    }

    public String clickRandomTocItem() {
        List<WebElement> items = getTocItems();
        if (items.isEmpty()) {
            throw new RuntimeException("Список оглавления пуст");
        }
        int randomIndex = random.nextInt(items.size());
        WebElement randomItem = items.get(randomIndex);
        String itemId = randomItem.getAttribute("data-toc-scroll");
        randomItem.click();
        return itemId;
    }

}

