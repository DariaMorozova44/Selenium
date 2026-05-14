package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.PageObjectList;

import java.util.List;

import static org.testng.Assert.*;

public class ListTest extends BaseTest {
    private PageObjectList pageObjectList;

    @Override
    protected void initPage() {
        pageObjectList = new PageObjectList(driver);

    }

    @Test
    public void testGetTocItemsNotEmpty() {
        List<WebElement> items = pageObjectList.getTocItems();
        assertNotNull(items, "Список элементов оглавления не должен быть null");
        assertTrue(items.size() > 0, "Оглавление должно содержать хотя бы один пункт");
    }

    @Test
    public void testGetTocItemsCount() {
        int count = pageObjectList.getTocItemsCount();
        List<WebElement> items = pageObjectList.getTocItems();
        assertEquals(count, items.size(), "Количество элементов, возвращаемое getTocItemsCount(), не совпадает с реальным размером списка");
        assertTrue(count > 0, "Количество пунктов должно быть больше 0");
    }

    @Test
    public void testClickRandomTocItem() {
        String itemId = pageObjectList.clickRandomTocItem();
        assertNotNull(itemId, "Метод clickRandomTocItem() вернул null");
        assertFalse(itemId.isEmpty(), "Идентификатор выбранного элемента не должен быть пустым");
    }

}