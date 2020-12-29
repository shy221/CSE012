import student.*;
// -------------------------------------------------------------------------
/**
 *Test Sub array
 *
 * @author Shenyi Yu
 * @version 2018.09.14
 */
public class SubArrayTest extends TestCase {
    /**
     * new object sub array
     * @param sa sa 
     */
    private SubArray sa; 
    /**
     * set up
     */
    public void setUp() {
        sa = new SubArray();  // inside setUp()    
    }
    /**
     * test GetAddCount
     */
    public void testGetAddCount() {
        assertEquals(0, sa.getAddCount());
    }
    /**
     * test GetAdd
     */
    public void testGetAdd() {
        sa.add("a");
        assertEquals(1, sa.getAddCount());
    }
    /**
     * test GetAddAll
     */
    public void testGetAddAll() {
        String [] a = {"a", "b", "c", "d"};
        sa.addAll(a);
        assertEquals(8, sa.getAddCount());
    }

}
