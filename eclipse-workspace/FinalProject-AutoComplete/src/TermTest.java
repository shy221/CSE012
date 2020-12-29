import junit.framework.TestCase;
/**
 * test for Term class 
 * @author Shenyi Yu
 * @version 2018.12.06
 */
public class TermTest extends TestCase {
    /**
     * @param t1 t1
     * @param t2 t2
     * @param t3 t3
     */
    private Term t1;
    private Term t2;
    private Term t3;
    /**
     * create a new TermTest object
     */
    public TermTest() {
        //empty constructor
    }

    /**
     * set up
     */
    public void setUp() {

        t1 = new Term("ace", (long) 1.0);
        t2 = new Term("advance", (long) 2.0);
        t3 = new Term("advancef", (long) 2.0);


    }

    /**
     * test get and set query
     * test get and set weight
     */
    public void testTerm() {

        assertEquals("ace", t1.getTerm());
        assertEquals((long) 1.0, t1.getWeight());
        t1.setTerm("ah");
        assertEquals("ah", t1.getTerm());
        t1.setWeight((long) 1.2);
        assertEquals(t1.getWeight(), (long) (1.2));
        @SuppressWarnings("unused")
        Exception thrown = null;
        try
        {
            new Term(null, (long) (0.0));
        }
        catch (Exception exception) {
            thrown = exception;
        }
        Exception thrown1 = null;
        try
        {
            new Term("a", (long) (-3.0));
        }
        catch (Exception exception) {
            thrown1 = exception;
        }
        assertNotNull(thrown1);
        assertTrue(thrown1 instanceof IllegalArgumentException);

    }
    /**
     * test by reverse weight order
     */
    public void testByReverseWeightOrder() {
        assertEquals(1, Term.byReverseWeightOrder().compare(t1, t2));
        assertEquals(-1, Term.byReverseWeightOrder().compare(t2, t1));
        t1.setWeight(0);
        t2.setWeight(0);
        assertEquals(0, Term.byReverseWeightOrder().compare(t1, t2));


    }

    /**
     * test by reverse weight order
     */
    public void testByPrefixOrder() {
        Exception thrown = null;
        try
        {
            Term.byPrefixOrder(-1);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof IllegalArgumentException);

        assertEquals(-1, Term.byPrefixOrder(2).compare(t1, t2));
        assertEquals(-1, Term.byPrefixOrder(3).compare(t1, t2));
        assertEquals(-1, Term.byPrefixOrder(7).compare(t1, t2));
        t1.setTerm("qwe");
        assertEquals(16, Term.byPrefixOrder(2).compare(t1, t2));
        assertEquals(16, Term.byPrefixOrder(3).compare(t1, t2));
        assertEquals(16, Term.byPrefixOrder(7).compare(t1, t2));
        assertEquals(-16, Term.byPrefixOrder(7).compare(t2, t1));
        assertEquals(0, Term.byPrefixOrder(7).compare(t2, t3));

    }

    /**
     * test compareTo
     */
    public void testCompareTo() {
        t1.compareTo(t2);
        assertEquals(-1, t1.compareTo(t2));
    }

    /**
     * test toString
     */
    public void testToString() {
        assertEquals(t1.toString(), "1" + "\t" + "ace");


    }




}
