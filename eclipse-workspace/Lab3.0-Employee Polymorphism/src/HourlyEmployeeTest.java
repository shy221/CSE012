import student.TestCase;

//-------------------------------------------------------------------------
/**
 *  Test cases for the HourlyEmployee class.
 *
 *  @author  Partner 1's name (pid)
 *  @author  Partner 2's name (pid)
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class HourlyEmployeeTest extends TestCase
{
    private HourlyEmployee empl;
    //~ Instance/static fields ...............................................

    // TODO You may want to declare a HourlyEmployee variable here that you
    // will initialize in your setUp method.


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        empl = new HourlyEmployee("romeo", 25.0);
    }
    
    public void testgetName() {
        assertEquals("romeo", empl.getName());
    }
    
    public void testgetPayRate() {
        assertEquals(25.0, empl.getPayRate(), 0.1);
    }
    
    public void testWeeklyPay() {
        assertEquals(1000.0, empl.weeklyPay(), 0.1);
    }

    public void testMeetWith() {
       HourlyEmployee emp2 = new HourlyEmployee("chris", 10.0);
       assertEquals("romeo is meeting with chris", empl.meetWith(emp2));
    }   
    // TODO Add your test case methods here.
}
