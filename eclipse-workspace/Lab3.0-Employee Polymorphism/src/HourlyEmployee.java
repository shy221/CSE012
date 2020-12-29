// -------------------------------------------------------------------------
/**
 *  Represents an employee who is paid an hourly wage.
 *
 *  @author  Partner 1's name (pid)
 *  @author  Partner 2's name (pid)
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class HourlyEmployee extends Employee
{
    
    public HourlyEmployee(String name, double payRate) {
        super(name, payRate);
    }
    
    @Override
    public double weeklyPay() {
        //TODO Auto-generated method stub
        return 40*this.getPayRate();
    }
    
    //~ Instance/static fields ................................................


    //~ Constructor ...........................................................


    //~ Methods ...............................................................

}