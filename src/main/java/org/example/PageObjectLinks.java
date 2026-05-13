package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectLinks {
    private WebDriverWait wait;
    private final WebDriver driver;

    public static final By COOKIE_ACCEPT_BUTTON = By.xpath("//button[contains(text(),'Accept') or contains(text(),'Got it')]");
    public static final By COOKIE_BANNER = By.className("ch2-container");
    public static final By CONTACT_US = By.xpath("//a[@data-test='button' and @title='Contact us']");
    public static final By YOUTUBE = By.xpath("//a[@data-test='button' and @title='Watch our videos on YouTube']");
    public static final By BLOG = By.xpath("//a[@data-test='button' and @title='Get the latest news from the YouTrack Blog']");
    public static final By TWITTER = By.xpath("//a[@data-test='button' and @title='Follow YouTrack on X']");
    public static final By BLUESKY = By.xpath("//a[@data-test='button' and @title='Follow YouTrack on Bluesky']");
    public static final By FACEBOOK = By.xpath("//a[@data-test='button' and @title='Follow YouTrack on Facebook']");
    public static final By LINKEDIN = By.xpath("//a[@data-test='button' and @title='Learn about YouTrack on LinkedIn']");
    public static final By REDDIT = By.xpath("//a[@data-test='button' and @title='Join our community on Reddit']");

    public PageObjectLinks(WebDriver driver) {
        this.driver = driver;
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


    public void clickContactUs() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(CONTACT_US));
        el.click();
    }

    public void clickYouTube() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(YOUTUBE));
        el.click();
    }

    public void clickBlog() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(BLOG));
        el.click();
    }

    public void clickTwitter() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(TWITTER));
        el.click();
    }

    public void clickBluesky() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(BLUESKY));
        el.click();
    }

    public void clickFacebook() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(FACEBOOK));
        el.click();
    }

    public void clickLinkedIn() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(LINKEDIN));
        el.click();
    }

    public void clickReddit() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(REDDIT));
        el.click();

}}
