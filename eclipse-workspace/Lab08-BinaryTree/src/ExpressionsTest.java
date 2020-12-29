import student.TestCase;
/**
 * Tests Class for methods of the Expressions class
 * @author Shenyi Yu
 * @version 2018.11.25
 */
public class ExpressionsTest extends TestCase {
    /**
     * set up method
     */
    public void setUp() {
        //nothing needed
    }
    
    /**
     * tests Expressions main method
     */
    public void testExpressions() {
        Expressions e = new Expressions();
        assertNotNull(e);
        Expressions.main(null);
        assertTrue(systemOut().getHistory().contains(
                "(* (- (a) (b)) (/ (+ (c) (d)) (e)))"));
        assertTrue(systemOut().getHistory().contains(
                "(((a) - (b)) * (((c) + (d)) / (e)))"));
        assertTrue(systemOut().getHistory().contains(
                "(((a) (b) -) (((c) (d) +) (e) /) *)"));
    }	

}
