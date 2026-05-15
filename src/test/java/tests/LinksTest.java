package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PageObjectLinks;

import static org.testng.Assert.assertTrue;

public class LinksTest extends BaseTest {
    private PageObjectLinks pageObjectLinks;

    @Override
    protected void initPage() {
        pageObjectLinks = new PageObjectLinks(driver);

    }

    @DataProvider(name = "socialLinks")
    public Object[][] socialLinksData() {
        return new Object[][]{
                {PageObjectLinks.YOUTUBE,  "youtube.com"},
                {PageObjectLinks.BLOG,     "blog.jetbrains.com"},
                {PageObjectLinks.TWITTER,  "x.com"},
                {PageObjectLinks.BLUESKY,  "bsky.app"},
                {PageObjectLinks.FACEBOOK, "facebook.com"},
                {PageObjectLinks.LINKEDIN, "linkedin.com"},
                {PageObjectLinks.REDDIT,   "reddit.com"},
                {PageObjectLinks.CONTACT_US, "mailto:mailto:youtrack-feedback@jetbrains.com"},
        };
    }

    @Test(dataProvider = "socialLinks")
    public void testSocialLinkOpensCorrectUrl(By locator, String expectedUrlPart) {
        String originalUrl = driver.getCurrentUrl();
        pageObjectLinks.click(locator);
        wait.until(webDriver -> !webDriver.getCurrentUrl().equals(originalUrl));
        assertTrue(driver.getCurrentUrl().contains(expectedUrlPart),
                "URL не содержит " + expectedUrlPart);
    }


}
