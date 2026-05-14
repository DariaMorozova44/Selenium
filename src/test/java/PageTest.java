import org.testng.annotations.Test;
import pagetests.PageObjectPages;

import static org.testng.Assert.assertNotEquals;

public class PageTest extends BaseTest {

    private PageObjectPages pageObjectPages;

    @Override
    protected void initPage() {
        pageObjectPages = new PageObjectPages(driver);

    }

    @Test
    public void testClickNextPage() {
        String currentUrl = driver.getCurrentUrl();
        pageObjectPages.clickNextPage();
        wait.until(webDriver -> !webDriver.getCurrentUrl().equals(currentUrl));
        assertNotEquals(driver.getCurrentUrl(), currentUrl, "Переход на следующую страницу не произошёл");
    }

    @Test
    public void testClickPrevPage() {
        pageObjectPages.clickNextPage();
        String afterNextUrl = driver.getCurrentUrl();
        pageObjectPages.clickPrevPage();
        wait.until(webDriver -> !webDriver.getCurrentUrl().equals(afterNextUrl));
        assertNotEquals(driver.getCurrentUrl(), afterNextUrl, "Переход на предыдущую страницу не произошёл");
    }


}
