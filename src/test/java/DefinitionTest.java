import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  // @After
  // public void tearDown() {
  //   Definition.clear();
  //   Word.clear();
  // }

  @Test
 public void definition_instantiatesCorrectly_true() {
   Definition testDefinition = new Definition("The place where one lives permanently");
   assertEquals(true, testDefinition instanceof Definition);
 }

}
