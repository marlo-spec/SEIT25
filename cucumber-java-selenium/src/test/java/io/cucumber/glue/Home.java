package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Home extends Context {

  public Home(Manager manager) {
    super(manager);
  }

  @Given("an example Home Page step")
  public void exampleHomePageStep() {
    System.out.println("printing shared stash :" + getTestStash());
  }

  @Then("the homepage should display exactly the following list of example links, with no missing, duplicate, or additional links:")
  public void verifyHomePageExamples(DataTable expectedTable) {
    List<String> expected = expectedTable.asList(String.class);
    List<String> actual = new io.cucumber.pages.Home(getDriver()).getExampleNames();

    assertEquals(expected, actual,
        "Homepage examples must match the required list exactly (including order and duplicates)");
  }
}
