package pagetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObjectTheme extends BasePage {

    private static final String DARK_THEME_CLASS = "theme-dark";
    private static final String LIGHT_THEME_CLASS = "theme-light";


    public PageObjectTheme(WebDriver driver) {
        super(driver);
    }

    public void clickThemeSwitcher() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Switch theme']")));
        element.click();
    }


    public boolean isDarkThemeActive() {
        WebElement html = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));
        String bodyClass = html.getAttribute("class");
        return bodyClass != null && bodyClass.contains(DARK_THEME_CLASS);
    }


    public boolean isLightThemeActive() {
        WebElement html = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));
        String bodyClass = html.getAttribute("class");
        return bodyClass != null && html.getAttribute("class").contains(LIGHT_THEME_CLASS);
    }

    public String getCurrentTheme() {
        return isDarkThemeActive() ? "dark" : "light";
    }
}

