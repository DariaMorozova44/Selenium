import org.apache.commons.io.FileUtils;
import org.example.PageObjectLinks;
import org.example.PageObjectTheme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.*;

public class ThemeTest extends BaseTest {

    private PageObjectTheme themePage;


    @BeforeMethod
    public void initPage() {
        themePage = new PageObjectTheme(driver);
    }


    @Test
    public void testThemeSwitcherButtonIsClickable() {
        themePage.clickThemeSwitcher();
        assertTrue(true);
    }

    @Test
    public void testSwitchToDarkTheme() {
        boolean wasDark = themePage.isDarkThemeActive();

        themePage.clickThemeSwitcher();

        if (wasDark) {
            assertTrue(themePage.isLightThemeActive(), "После переключения должна быть светлая тема");
        } else {
            assertTrue(themePage.isDarkThemeActive(), "После переключения должна быть тёмная тема");
        }
    }

    @Test
    public void testSwitchToLightTheme() {
        if (!themePage.isDarkThemeActive()) {
            themePage.clickThemeSwitcher();
        }
        assertTrue(themePage.isDarkThemeActive(), "Перед тестом должна быть тёмная тема");

        themePage.clickThemeSwitcher();

        assertTrue(themePage.isLightThemeActive(), "После клика должна быть светлая тема");
    }

    @Test
    public void testThemePreservedAfterPageRefresh() {
        boolean originalIsDark = themePage.isDarkThemeActive();
        themePage.clickThemeSwitcher();
        assertNotEquals(themePage.isDarkThemeActive(), originalIsDark);

        driver.navigate().refresh();

        PageObjectTheme freshThemePage = new PageObjectTheme(driver);

        assertEquals(freshThemePage.isDarkThemeActive(), !originalIsDark,
                "Тема не сохранилась после перезагрузки страницы");
    }

    @Test
    public void testGetCurrentTheme() {
        String current = themePage.getCurrentTheme();
        assertTrue(current.equals("dark") || current.equals("light"),
                "getCurrentTheme() вернул некорректное значение: " + current);

        themePage.clickThemeSwitcher();
        String newCurrent = themePage.getCurrentTheme();
        assertNotEquals(current, newCurrent,
                "После переключения тема не изменилась");
    }


}

