package io.cucumber.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SortableDataTablesPage extends Page {

  public SortableDataTablesPage(ChromeDriver driver) {
    super(driver);
  }

  // The assessment requires five data columns; the site's sixth Action column is out of scope.
  public List<String> getRequiredHeaders() {
    List<String> names = new ArrayList<>();
    List<WebElement> headers = driver.findElements(By.cssSelector("#table1 thead th"));
    for (int i = 0; i < 5; i++) {
      names.add(headers.get(i).getText().trim());
    }
    return names;
  }

  public List<List<String>> getRequiredRows() {
    List<List<String>> results = new ArrayList<>();
    List<WebElement> rows = driver.findElements(By.cssSelector("#table1 tbody tr"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.cssSelector("td"));
      List<String> values = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
        values.add(cells.get(i).getText().trim());
      }
      results.add(values);
    }
    return results;
  }
}
