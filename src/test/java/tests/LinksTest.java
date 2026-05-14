package tests;

import org.testng.annotations.Test;
import pages.PageObjectLinks;

import static org.testng.Assert.assertTrue;

public class LinksTest extends BaseTest {
    private PageObjectLinks pageObjectLinks;

    @Override
    protected void initPage() {
        pageObjectLinks = new PageObjectLinks(driver);

    }


    @Test
    public void testContactUsLink() {
        pageObjectLinks.clickContactUs();
        assertTrue(driver.getCurrentUrl().contains("mailto:"), "Не mailto: ссылка");
    }

    @Test
    public void testYouTubeLink() {
        pageObjectLinks.clickYouTube();
        assertTrue(driver.getCurrentUrl().contains("youtube.com"), "Не YouTube");
    }

    @Test
    public void testBlogLink() {
        pageObjectLinks.clickBlog();
        assertTrue(driver.getCurrentUrl().contains("blog.jetbrains.com"), "Не блог");
    }

    @Test
    public void testTwitterLink() {
        pageObjectLinks.clickTwitter();
        assertTrue(driver.getCurrentUrl().contains("twitter.com") || driver.getCurrentUrl().contains("x.com"), "Не Twitter/X");
    }

    @Test
    public void testBlueskyLink() {
        pageObjectLinks.clickBluesky();
        assertTrue(driver.getCurrentUrl().contains("bsky.app"), "Не Bluesky");
    }

    @Test
    public void testFacebookLink() {
        pageObjectLinks.clickFacebook();
        assertTrue(driver.getCurrentUrl().contains("facebook.com"), "Не Facebook");
    }

    @Test
    public void testLinkedInLink() {
        pageObjectLinks.clickLinkedIn();
        assertTrue(driver.getCurrentUrl().contains("linkedin.com"), "Не LinkedIn");
    }

    @Test
    public void testRedditLink() {
        pageObjectLinks.clickReddit();
        assertTrue(driver.getCurrentUrl().contains("reddit.com"), "Не Reddit");
    }

}
