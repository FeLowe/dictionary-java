import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordTest {

  @Test
  public void oneWord_instantiatesCorrectly_true() {
    Word testWord = new Word("Home");
    assertEquals(true, testWord instanceof Word);
  }
  @Test
  public void oneWord_instantiatesWithAWord_String() {
    Word testWord = new Word("Home");
    assertEquals("Home", testWord.getWord());
  }
  @Test
  public void multiplyWords_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("Home");
    Word secondWord = new Word("Friendship");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }
  @Test
  public void clear_emptiesAllWordsFromArrayList_0() {
    Word testWord = new Word("Home");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }
  @Test
  public void getId_wordsInstantiateWithAnID_1() {
    Word.clear();
    Word testWord = new Word("Home");
    assertEquals(1, testWord.getId());
  }
  @Test
  public void find_returnsWordsWithSameId_second_Word() {
    Word firstWord = new Word("Home");
    Word secondWord = new Word("Friendship");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }
  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(999) == null);
  }

}
