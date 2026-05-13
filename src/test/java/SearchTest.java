import org.example.PageObjectSearch;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    private PageObjectSearch pageObjectSearch;

    @BeforeMethod
    public void initPage() {
        pageObjectSearch = new PageObjectSearch(driver);
    }

    @Test(dataProvider = "searchQueries", dataProviderClass = CsvDataProvider.class)
    public void testSearchWithCsvData(String query, String expectedResult) {
        pageObjectSearch.searchFor(query);

        if ("positive".equals(expectedResult)) {
            assertTrue(pageObjectSearch.areResultsDisplayed(), "No results for: " + query);
        } else {
            assertTrue(pageObjectSearch.isNoResultsMessageDisplayed(), "Expected no results for: " + query);
        }
    }


}