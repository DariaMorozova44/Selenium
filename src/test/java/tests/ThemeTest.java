package tests;

import org.testng.annotations.Test;
import pages.PageObjectTheme;

import static org.testng.Assert.*;

public class ThemeTest extends BaseTest {

    private PageObjectTheme themePage;

    @Override
    protected void initPage() {
        themePage = new PageObjectTheme(driver);
    }


    @Test
    public void testThemeSwitcherButtonIsClickable() {
        boolean wasDark = themePage.isDarkThemeActive();
        themePage.clickThemeSwitcher();
        if (wasDark) {
            assertTrue(themePage.isLightThemeActive(), "После клика тема не стала светлой");
        } else {
            assertTrue(themePage.isDarkThemeActive(), "После клика тема не стала тёмной");
        }
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
}


