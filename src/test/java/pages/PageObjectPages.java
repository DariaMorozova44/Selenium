package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObjectPages extends BasePage {
    private static final By PREV_BUTTON = By.xpath("//a[@data-test='internal-link prev-page']");
    private static final By NEXT_BUTTON = By.xpath("//a[@data-test='internal-link next-page']");


    public PageObjectPages(WebDriver driver) {
       super(driver);
    }

    public void clickPrevPage() {
       WebElement prev = wait.until(ExpectedConditions.elementToBeClickable(PREV_BUTTON));
       prev.click();
    }
    public void clickNextPage() {
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON));
        next.click();
    }
}
