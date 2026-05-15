package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObjectTheme extends BasePage {

    private static final By DARK_THEME = By.xpath("/html[contains(@class, 'theme-dark')]");
    private static final By LIGHT_THEME = By.xpath("/html[contains(@class, 'theme-light')]");

    public PageObjectTheme(WebDriver driver) {
        super(driver);
    }

    public void clickThemeSwitcher() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Switch theme']")));
        element.click();
    }


    public boolean isDarkThemeActive() {
        WebElement html = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));
        return !html.findElements(DARK_THEME).isEmpty();
    }

    public boolean isLightThemeActive() {
        WebElement html = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));
        return !html.findElements(LIGHT_THEME).isEmpty();
    }

}

