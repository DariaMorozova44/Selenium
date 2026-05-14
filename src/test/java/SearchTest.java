import org.testng.annotations.Test;
import pagetests.PageObjectSearch;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    private PageObjectSearch pageObjectSearch;

    @Override
    protected void initPage() {
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