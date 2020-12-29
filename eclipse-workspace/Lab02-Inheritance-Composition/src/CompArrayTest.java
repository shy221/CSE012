/**
 *  A test class for comp array
 *
 *  @author Shenyi Yu
 *  @version Sep 14, 2016
 */
public class CompArrayTest extends student.TestCase {
    private CompArray s; 
    /**
     * set up
     */
    public void setUp() {
        s = new CompArray();  // inside setUp()    
    }
    /**
     * test GetAddCount
     */
    public void testGetAddCount() {
        assertEquals(0, s.getAddCount());
    }
    /**
     * test GetAdd
     */
    public void testGetAdd() {
        s.add("a");
        assertEquals(1, s.getAddCount());
    }
    /**
     * test GetAddAll
     */
    public void testGetAddAll() {
        String [] a = {"a", "b", "c", "d"};
        s.addAll(a);
        assertEquals(4, s.getAddCount());
    }

}
