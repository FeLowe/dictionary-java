import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class WordTest {
  @After
  public void tearDown() {
    Task.clear();
  }
  @Test
  public void Word_instantiatesCorrectly_true() {
    Word testWord = new Word("Home");
    assertEquals(true, testWord instanceof Word);
  }

//   @Test
//   public void Word_instantiatesWithWord_String() {
//       Word testWord = new Word("Home");
//     assertEquals("Home", testWord.getWord());
//   }
//
//   @Test
//   public void allWords_returnsAllInstancesOfWord_true() {
//     Word firstWord = new Word("Home");
//     Word secondWord = new Word("School");
//     assertTrue(Word.all().contains(firstWord));
//     assertTrue(Word.all().contains(secondWord));
//   }
//
//   @Test
//   public void clear_emptiesAllWordsFromArrayList_0() {
//     Word testWord = new Word("Home");
//     Word.clear();
//     assertEquals(Word.all().size(), 0);
//   }
//
// }
