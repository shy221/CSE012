// -------------------------------------------------------------------------
/**
 *  Represents an employee in a company or business.
 *
 *  @author  Partner 1's name (pid)
 *  @author  Partner 2's name (pid)
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public abstract class Employee implements MeetingParticipant
{
    //~ Instance/static fields ................................................

    private String name;        // The employee's name.
    private double payRate;     // The employee's pay rate.
    
    public Employee(String name, double payRate) {
        this.name = name;
        this.payRate = payRate;

    }
    //~ Constructor ...........................................................

    // TODO In Part I, step 4, you will add a constructor here.


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Gets the employee's name.
     * @return the employee's name
     */
    public String getName()
    {
        return name;
    }


    
    // ----------------------------------------------------------
    /**
     * Gets the pay rate.
     * @return the pay rate
     */
    public double getPayRate()
    {
        return payRate;
    }
    
    /**
     * @return double weeklyPay
     */
    public abstract double weeklyPay();
    
    public String meetWith(MeetingParticipant other) {
        return this.getName() + " is meeting with " + other.getName();
    }
}
