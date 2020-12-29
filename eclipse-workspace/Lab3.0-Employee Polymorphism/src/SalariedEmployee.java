// -------------------------------------------------------------------------
/**
 *  Represents an employee who is paid a yearly salary.
 *
 *  @author  Partner 1's name (pid)
 *  @author  Partner 2's name (pid)
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class SalariedEmployee extends Employee
{
    
    public SalariedEmployee(String name, double payRate) {
        super(name, payRate);
    }
    @Override
    public double weeklyPay() {
        //TODO Auto=generated method stub
        return this.getPayRate();
    }
    //~ Instance/static fields ................................................


    //~ Constructor ...........................................................


    //~ Methods ...............................................................
    public String meetWith(SalariedEmployee otherParticipant) {
        return otherParticipant.getName() + " is joining " + this.getName()
                + " in a conference";
    }
}