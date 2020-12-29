import java.util.List;

import junit.framework.TestCase;
/**
 * test for AutoComplete class 
 * @author Shenyi Yu
 * @version 2018.12.06
 */
public class AutoCompleteTest extends TestCase {
    //private Node node;
    private Autocomplete a;
    //private Autocomplete b;


    /**
     * create a new TermTest object
     */
    public AutoCompleteTest() {
        //empty constructor
    }

    /**
     * set up
     */
    public void setUp() {
        //node = new Node();
        a = new Autocomplete();
        //b = new Autocomplete();

    }

    /**
     * test add word
     */
    public void testAddWord() {
        a.addWord("aaa", 100);
        a.addWord("aar", 100);
        a.addWord("*aaa", 100);
        a.addWord("{aaaa", 100);
        a.addWord("3", 100);
        a.addWord("天", 100);
        assertNotNull(a.getSubTrie("aaa"));
        

    }

    /**
     * test get sub
     */
    public void testGetSubTrie() {
        a.addWord("apple", 100);
        a.addWord("aar", 100);
        assertEquals("apple", a.getSubTrie("apple").getTerm().getTerm());
        assertNull(a.getSubTrie("*aaa"));
        assertNull(a.getSubTrie("{aaaa"));
        assertNull(a.getSubTrie("3"));
        assertNull(a.getSubTrie("天"));
        assertNull(a.getSubTrie(null));





    }

    /**
     * test count prefixes
     */
    public void testCountPrefixes() {
        assertEquals(0, a.countPrefixes("ab"));
        a.addWord("able", 100);
        assertEquals(1, a.countPrefixes("ab"));
        a.addWord("abandon", 100);
        a.addWord("abuse", 100);
        assertEquals(3, a.countPrefixes("ab")); 
    }

    /**
     * test get suggestions
     */
    public void testGetSuggestions() {
        assertNull(a.getSuggestions("aaa"));
        assertNull(a.getSuggestions("*aaa"));
        assertNull(a.getSuggestions("{aaaa"));
        assertNull(a.getSuggestions("3"));
        assertNull(a.getSuggestions("天"));
        assertNull(a.getSuggestions(null));
        a.addWord("zz", 100);
        @SuppressWarnings("unused")
        List<Term> j = a.getSuggestions("z"); 
        a.addWord("able", 100);
        a.addWord("abandon", 100);
        a.addWord("abuse", 100);
        a.addWord("zz", 100);        
        assertEquals(3, a.getSuggestions("ab").size()); 
        @SuppressWarnings("unused")
        List<Term> i = a.getSuggestions("a"); 
        assertEquals("zz", j.get(0).getTerm());



    }

}
