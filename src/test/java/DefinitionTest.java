import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  @After
  public void tearDown() {
    Definition.clear();
    Word.clear();
  }

  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition testDefinition = new Definition("The place where one lives permanently");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void getDefinition_InstantiatesWithDefinition_Home() {
    Definition testDefinition = new Definition("The place where one lives permanently");
    assertEquals("The place where one lives permanently", testDefinition.getDefinition());
  }
  @Test
  public void allDefinitions_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("The place where one lives permanently");
    Definition secondDefinition = new Definition("An institution for educating children.");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }
    @Test
    public void clear_emptiesAllDefinitionsFromList_0() {
      Definition testDefinition = new Definition("The place where one lives permanently");
      Definition.clear();
      assertEquals(Definition.all().size(), 0);
  }
    @Test
    public void getId_definitionsInstantiateWithAnId_1() {
    Definition testDefinition = new Definition("The place where one lives permanently");
    assertEquals(1, testDefinition.getId());
  }

}
