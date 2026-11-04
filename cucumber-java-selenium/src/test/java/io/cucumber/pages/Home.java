package io.cucumber.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Home extends Page {

  public Home(ChromeDriver driver) {
    super(driver);
    System.out.println("Homepage title is : " + getTitle().getText());
  }

  @FindBy(css = "h1")
  private WebElement title;

  public WebElement getTitle() {
    return title;
  }

  public List<String> getExampleNames() {
    List<String> names = new ArrayList<>();
    for (WebElement item : driver.findElements(By.cssSelector("#content ul li"))) {
      names.add(item.getText().trim());
    }
    return names;
  }

  public void openExample(String linkText) {
    driver.findElement(By.linkText(linkText)).click();
  }

  public void refresh() {
    driver.navigate().refresh();
    System.out.println("Refreshed page");
  }
}
