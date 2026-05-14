package helpers;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvDataProvider {

    @DataProvider(name = "searchQueries")
    public static Object[][] getSearchQueries() throws Exception {
        InputStream is = CsvDataProvider.class.getClassLoader().getResourceAsStream("search-data.csv");
        if (is == null) throw new RuntimeException("CSV not found");
        try (CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            List<String[]> rows = reader.readAll();
            List<Object[]> data = new ArrayList<>();
            for (int i = 1; i < rows.size(); i++) {
                String query = rows.get(i)[0];
                String expectedResult = rows.get(i)[1];
                data.add(new Object[]{query, expectedResult});
            }
            return data.toArray(new Object[0][]);
        }
    }
}