package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicAuthSteps extends Context {

  public BasicAuthSteps(Manager manager) {
    super(manager);
  }

  // Register the HTTP credentials before clicking the protected link.
  @Given("valid credentials are supplied")
  public void supplyCredentials() {
    ((HasAuthentication) getDriver()).register(
        uri -> "the-internet.herokuapp.com".equals(uri.getHost()),
        UsernameAndPassword.of("admin", "admin"));
  }

  @When("the 'Basic Auth' example is opened")
  public void openBasicAuth() {
    new io.cucumber.pages.Home(getDriver()).openExample("Basic Auth");
  }

  @Then("Congratulations should be displayed")
  public void verifySuccess() {
    String message = getDriver().findElement(By.cssSelector("#content p"))
        .getText();
    assertTrue(message.contains("Congratulations!"),
        "Basic Auth did not show the expected success message: " + message);
  }
}
