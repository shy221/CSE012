import java.util.Comparator;
/**
 * this class is used to create a student class
 * @author Shenyi Yu
 * @version Sep,14,2018 
 */
public class Student implements Comparable<Student> {
    private String name;
    private int id;
    private double gpa;
    /**
     * create a student object
     * @param name name 
     * @param id id 
     * @param gpa gpa 
     */  
    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }
    /**
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @param gpa gpa
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    /**
     * @return name 
     */
    public String getName() {
        return this.name;
    }
    /**
     * @return id
     */
    public int getId() {
        return this.id;
    }
    /**
     * @return gpa
     */
    public double getGpa() {
        return this.gpa;
    }
    
    @Override
    public int compareTo(Student o) {
        if (this.gpa > o.gpa) {
            return 1;
        }
        else if (this.gpa < o.gpa) {
            return -1;
        }
        else {
            if (this.id > o.id) {
                return 10;
            }
            else if (this.id < o.id) {
                return -10;
            }
            else {
                if (name.equals(o.name)) {
                    return 0;
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


    public static Comparator<Student> studentOrder() {

        return new Comparator<Student>() {

            @Override

            public int compare(Student o1, Student o2) {

                return o1.compareTo(o2);

            }

        };

    }

    /**

     * compare gpa if it verifies in dean list.

     * @return boolean values

     */
    public boolean isInDeansList() {
        
        if (gpa >= 3.5) {
            return true;
        }
        if (gpa > 2.0 && gpa < 3.5) {
            return false;
        }
        else {
            throw new NotInDeansListException("message");
        }
    
    }
    /**

     * compare gpa if it verifies in academic probation .

     * @return boolean values

     */
    public boolean isInAcademicProbation() {
        
        if (gpa <= 2.0) {
            return true;
        }
        if (gpa > 2.0 && gpa < 3.5) {
            return false;
        }
        else {
            throw new NotInAcademicProbationException("message");
        }
    
    }
    
}
