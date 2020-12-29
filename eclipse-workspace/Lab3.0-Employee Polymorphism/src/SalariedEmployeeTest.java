import student.TestCase;

//-------------------------------------------------------------------------
/**
 *  Test cases for the SalariedEmployee class.
 *
 *  @author  Partner 1's name (pid)
 *  @author  Partner 2's name (pid)
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class SalariedEmployeeTest extends TestCase
{
    private SalariedEmployee empl;
    //~ Instance/static fields ...............................................

    // TODO You may want to declare a SalariedEmployee variable here that you
    // will initialize in your setUp method.


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        empl = new SalariedEmployee("romeo", 25.0);
    }
    
    public void testgetName() {
        assertEquals("romeo", empl.getName());
    }
    
    public void testgetPayRate() {
        assertEquals(25.0, empl.getPayRate(), 0.1);
    }
    
    public void testWeeklyPay() {
        assertEquals(25.0, empl.weeklyPay(), 0.1);
    }

    public void testMeetWith() {
       SalariedEmployee emp2 = new SalariedEmployee("chris", 10.0);
       assertEquals("chris is joining romeo in a conference", empl.meetWith(emp2));
    }    


    // TODO Add your test case methods here.
}
