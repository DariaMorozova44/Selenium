package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriverWait wait;

    private static final By COOKIE_ACCEPT_BUTTON = By.xpath("//button[contains(text(),'Accept') or contains(text(),'Got it')]");
    private static final By COOKIE_BANNER = By.xpath("//div[contains(@class, 'ch2-container')]");

    public BasePage(WebDriver driver) {
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
}
