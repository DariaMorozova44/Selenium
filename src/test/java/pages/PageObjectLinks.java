package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObjectLinks extends BasePage {

    public static final By CONTACT_US = By.xpath("//a[@data-test='button' and @title='Contact us']");
    public static final By YOUTUBE = By.xpath("//a[@data-test='button' and @title='Watch our videos on YouTube']");
    public static final By BLOG = By.xpath("//a[@data-test='button' and @title='Get the latest news from the YouTrack Blog']");
    public static final By TWITTER = By.xpath("//a[@data-test='button' and @title='Follow YouTrack on X']");
    public static final By BLUESKY = By.xpath("//a[@data-test='button' and @title='Follow YouTrack on Bluesky']");
    public static final By FACEBOOK = By.xpath("//a[@data-test='button' and @title='Follow YouTrack on Facebook']");
    public static final By LINKEDIN = By.xpath("//a[@data-test='button' and @title='Learn about YouTrack on LinkedIn']");
    public static final By REDDIT = By.xpath("//a[@data-test='button' and @title='Join our community on Reddit']");

    public PageObjectLinks(WebDriver driver) {
        super(driver);
    }


    public void click(By locator) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }


}

