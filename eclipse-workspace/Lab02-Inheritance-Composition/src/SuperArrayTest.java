
// -------------------------------------------------------------------------
/**
 *  A test class for super array
 *
 *  @author Shenyi Yu
 *  @version Sep 14, 2016
 */
public class SuperArrayTest extends student.TestCase
{

    private SuperArray suA;
    /**
     * set up
     */
    public void setUp()
    {
        String[] a = { "a", "b", "c", "d" };
        suA = new SuperArray(a);
    }

    // ----------------------------------------------------------
    /**
     * Test {@link SuperArray#addAll(Object[])}.
     */
    public void testAddAll()
    {
        //The original size of suA is 4
        assertEquals(4, suA.getSize());
        String test = "testString";
        suA.add(test);
        //After adding the string test, the size should be 5
        assertEquals(5, suA.getSize());
    }

}
