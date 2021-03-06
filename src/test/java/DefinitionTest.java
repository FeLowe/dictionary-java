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
    public void getId_definitionInstantiateWithAnId_1() {
    Definition testDefinition = new Definition("The place where one lives permanently");
    assertEquals(1, testDefinition.getId());
  }
    @Test
    public void find_returnsDefinitionWithSameId_secondDefinition() {
      Definition firstDefinition = new Definition("The place where one lives permanently");
      Definition secondDefinition = new Definition("An institution for educating children.");
      assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
    }
    @Test
    public void find_returnsNullWhenNoDefinitionFound_null() {
      assertTrue(Definition.find(999) == null);
    }

}
