import java.util.Comparator;
/**
 * represents the contact information for a particular person. 
 * only store a first firstname, last firstname, and phone number. 
 * Store all three fields as strings.
 * 
 * @author Shenyi Yu
 * @version 2018.11.25
 */
public class Contact implements Comparable<Contact> {
    private String firstname;
    private String lastname;
    private String number;


    /**
     * create a student object
     * @param firstname firstname 
     * @param lastname lastname 
     * @param number number
     */  
    public Contact(String firstname, String lastname, String number) {      
        this.firstname = firstname;
        this.lastname = lastname;
        this.number = number;
    }

    /**
     * @param fn fn
     */    
    public void setFirstName(String fn) {
        this.firstname = fn;
    }
    /**
     * @param ln ln 
     */
    public void setLastName(String ln) {
        this.lastname = ln;
    }
    /**
     * @param no no
     */
    public void setNumber(String no) {
        this.number = no;
    }
    /**
     * @return firstname 
     */
    public String getFirstName() {
        return this.firstname;
    }
    /**
     * @return lastname 
     */
    public String getLastName() {
        return this.lastname;
    }
    /**
     * @return number 
     */
    public String getNumber() {
        return this.number;
    }
    @Override
    public int compareTo(Contact o) {
        int compare = this.lastname.compareTo(o.lastname);
        int comparefirst = this.firstname.compareTo(o.firstname);
        int comparenum = this.number.compareTo(o.number);

        if (compare != 0) {
            return -1;
        }
        else {
            if (comparefirst != 0) {
                return -10;
            }

            else {
                if (comparenum != 0) {
                    return -100;  
                }
                else {

                    return 999;
                }

            }

        }

    }

    // ----------------------------------------------------------

    /**

     * Comparator for students objects.

     * @return comparator

     */

    public static Comparator<Contact> studentOrder() {

        return new Comparator<Contact>() {

            @Override

            public int compare(Contact o1, Contact o2) {   
                return o1.compareTo(o2);

            }

        };

    }










}
