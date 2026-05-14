import org.testng.annotations.Test;
import pagetests.PageObjectTheme;

import static org.testng.Assert.*;

public class ThemeTest extends BaseTest {

    private PageObjectTheme themePage;

    @Override
    protected void initPage() {
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

