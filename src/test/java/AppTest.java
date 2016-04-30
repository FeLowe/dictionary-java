
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("My Dictionary");
    assertThat(pageSource()).contains("View words");
    assertThat(pageSource()).contains("Add a new word");

  }
  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a new word"));
    fill("#word").with("Home");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been saved.");
  }
  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Home");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Home");
  }

  @Test
  public void wordShowPageDisplaysWord() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("School");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("School"));
    assertThat(pageSource()).contains("School");
  }
  @Test
  public void wordDefinitionsFormIsDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Family");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Family"));
    click("a", withText("Add a definition"));
    assertThat(pageSource()).contains("Add a definition to Family");
  }

}
