package io.cucumber.glue;

import io.cucumber.java.en.Given;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;

public class Navigation extends Context {

  private static final String HOME_URL = "https://the-internet.herokuapp.com";

  public Navigation(Manager manager) {
    super(manager);
  }

  @Given("^the page under test is '(.+)'$")
  public void navToPage(String urlOrExample) {
    if (urlOrExample.startsWith("https://") || urlOrExample.startsWith("http://")) {
      getDriver().get(urlOrExample);
    } else {
      getDriver().get(HOME_URL);
      new io.cucumber.pages.Home(getDriver()).openExample(urlOrExample);
    }
    stash("exampleKey1", "exampleValue1");
  }
}
