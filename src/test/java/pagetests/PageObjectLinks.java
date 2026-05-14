package pagetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObjectLinks extends BasePage {

    private static final By CONTACT_US = By.xpath("//a[@data-test='button' and @title='Contact us']");
    private static final By YOUTUBE = By.xpath("//a[@data-test='button' and @title='Watch our videos on YouTube']");
    private static final By BLOG = By.xpath("//a[@data-test='button' and @title='Get the latest news from the YouTrack Blog']");
    private static final By TWITTER = By.xpath("//a[@data-test='button' and @title='Follow YouTrack on X']");
    private static final By BLUESKY = By.xpath("//a[@data-test='button' and @title='Follow YouTrack on Bluesky']");
    private static final By FACEBOOK = By.xpath("//a[@data-test='button' and @title='Follow YouTrack on Facebook']");
    private static final By LINKEDIN = By.xpath("//a[@data-test='button' and @title='Learn about YouTrack on LinkedIn']");
    private static final By REDDIT = By.xpath("//a[@data-test='button' and @title='Join our community on Reddit']");

    public PageObjectLinks(WebDriver driver) {
        super(driver);
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

    }
}
