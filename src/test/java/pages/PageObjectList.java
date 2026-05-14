package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class PageObjectList extends BasePage {

    private final Random random = new Random();

    private static final By TOC_CONTAINER = By.xpath("//ul[@data-test='toc']");


    public PageObjectList(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getTocItems() {
        WebElement toc = wait.until(ExpectedConditions.visibilityOfElementLocated(TOC_CONTAINER));
        return toc.findElements(By.tagName("li"));
    }


    public int getTocItemsCount() {
        return getTocItems().size();
    }

    public String clickRandomTocItem() {
        List<WebElement> items = getTocItems();
        if (items.isEmpty()) {
            throw new RuntimeException("Список оглавления пуст");
        }
        int randomIndex = random.nextInt(items.size());
        WebElement randomItem = items.get(randomIndex);
        String itemId = randomItem.getAttribute("data-toc-scroll");
        randomItem.click();
        return itemId;
    }

}

