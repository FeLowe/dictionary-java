
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

  }
  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#word").with("Home");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been saved.");
  }
  @Test
    public void wordIsDisplayedTest() {
      goTo("http://localhost:4567/");
      fill("#word").with("Home");
      submit(".btn");
      click("a", withText("Go Back"));
      assertThat(pageSource()).contains("Home");
    }

   @Test
  public void multipleWordsAreDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#word").with("Home");
    submit(".btn");
    click("a", withText("Go Back"));
    fill("#word").with("Friendship");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Home");
    assertThat(pageSource()).contains("Friendship");
  }


}
