import student.TestCase;
/**
 * This class represents a testcase for entry
 *
 * @author Shenyi Yu
 * @version 2018.10.22
 */
public class EntryTest extends TestCase {

    private Entry<String, Double> map;
    private Entry<String, Double> map2;
    private Entry<String, Double> map3;
    /**
     * constructor
     */
    public EntryTest() {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }
    
    /**
     * Creates new maps as the test
     * fixture for each test method.
     */
    
    public void setUp() {
        map = new Entry<String, Double>("Allentown", 3.03);
        map2 = new Entry<String, Double>("Allentown", 4.04);
        map3 = new Entry<String, Double>("Philadelphia", 3.03);
    }
    /**
     * test case for setters 
     */
    public void testSetKey() {
        map.setKey("Philadelphia");
        assertEquals("Philadelphia", map.getKey());
    }
    
    /**
     * test case for getters 
     */
    public void testGetKey() {
        assertEquals("Allentown", map.getKey());
    }
    
    /**
     * test case for getValues
     */
    public void testGetValues() {
        assertEquals(3.03, map.getValues().get(0), 0.01);
    }
    
    /**
     * Test method for equals
     */
    public void testEquals() {
        assertTrue(map.equals(map2));
        assertFalse(map.equals(map3));
    }
}
