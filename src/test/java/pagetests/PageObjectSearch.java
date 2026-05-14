package pagetests;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObjectSearch extends BasePage {

    private static final By SEARCH_BUTTON = By.xpath("//button[@title='Search']");
    private static final By SEARCH_INPUT = By.xpath("//input[@data-test-id='search-input']");
    private static final By RESULTS_CONTAINER = By.xpath("//ul[@data-test='search-results']");
    private static final By NO_RESULTS_MESSAGE = By.xpath("//div[@data-test='no-results']");

    public PageObjectSearch(WebDriver driver) {
       super(driver);
    }

    public void searchFor(String query) {
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON));
        searchBtn.click();
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT));
        input.sendKeys(query);
    }
    public boolean areResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(RESULTS_CONTAINER));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isNoResultsMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(NO_RESULTS_MESSAGE));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


}

