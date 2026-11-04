package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.pages.SortableDataTablesPage;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableSteps extends Context {

  public TableSteps(Manager manager) {
    super(manager);
  }

  @Then("the Example 1 table on the Sortable Data Tables page should display exactly the following four records, with all column values matching the expected results:")
  public void verifyExampleOneTable(DataTable expectedTable) {
    List<List<String>> expected = expectedTable.asLists(String.class);
    SortableDataTablesPage page = new SortableDataTablesPage(getDriver());

    assertEquals(expected.get(0), page.getRequiredHeaders(),
        "Example 1 table headers did not match");
    assertEquals(expected.subList(1, expected.size()), page.getRequiredRows(),
        "Example 1 table data did not match");
  }
}
