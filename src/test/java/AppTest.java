
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
//
//     @Test
//       public void twoCategoriesIsDisplayedTest() {
//       goTo("http://localhost:4567/categories/new");
//       fill("#name").with("Household chores");
//       submit(".btn");
//       click("a", withText("All categories"));
//       click("a", withText("Add New category"));
//       fill("#name").with("Outside chores");
//       submit(".btn");
//       click("a", withText("All categories"));
//       assertThat(pageSource()).contains("Household chores");
//       assertThat(pageSource()).contains("Outside chores");
//       }
//
//       @Test
//       public void categoryShowPageDisplaysName() {
//         goTo("http://localhost:4567/categories/new");
//         fill("#name").with("Household chores");
//         submit(".btn");
//         click("a", withText("All categories"));
//         click("a", withText("Household chores"));
//         assertThat(pageSource()).contains("Household chores");
//       }
//
//     @Test
//     public void categoryTasksFormIsDisplayed() {
//       goTo("http://localhost:4567/categories/new");
//       fill("#name").with("Shopping");
//       submit(".btn");
//       click("a", withText("All categories"));
//       click("a", withText("Shopping"));
//       click("a", withText("Add a new task"));
//       assertThat(pageSource()).contains("Add a task to Shopping");
//     }
//
//
//
//
//
//
}