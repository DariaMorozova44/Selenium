import org.example.PageObjectPages;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertNotEquals;

public class PageTest extends BaseTest{
    private WebDriverWait wait;
    private PageObjectPages pageObjectPages;


    @BeforeMethod
    public void initPage() {
        pageObjectPages = new PageObjectPages(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
