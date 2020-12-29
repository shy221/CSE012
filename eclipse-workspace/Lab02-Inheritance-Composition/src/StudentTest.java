import student.*;
import java.util.Arrays;
/**
 * test for student class 
 * @author Shenyi Yu
 * @version Sep,17,2018 
 */
public class StudentTest extends TestCase {
    /**
     * @param st
     */
    private Student []st;    
    /**
     * create a new StudentTest object
     */
    public StudentTest() {
        //empty constructor
    }
    /**
     * set up
     */
    public void setUp() {
        st = new Student[6];
        st[0] = new Student("John", 1001, 1.0);
        st[1] = new Student("Kylie", 1002, 1.9);
        st[2] = new Student("Lima", 1003, 3.3); 
        st[3] = new Student("Mike", 1003, 4.0); 
        st[4] = new Student("Mike", 1005, 4.0);
        st[5] = new Student("Mike", 1005, 4.0);
        Arrays.sort(st, Student.studentOrder());
        
    }
    /**
     * test get and set name 
     */
    public void testGetSetName() {
        st[0].setName("new");
        assertEquals("new", st[0].getName());
    }
    
    /**
     * test get and set Id 
     */
    public void testGetSetId() {
        st[0].setId(1000);
        assertEquals(1000, st[0].getId());
    }
    
    /**
     * test get and set gpa 
     */
    public void testGetSetGpa() {
        st[0].setGpa(0.1);
        assertEquals(0.1, st[0].getGpa(), 0.01);
    }
    
    /**
     * test if in deans list
     */
    public void testIsInDeansList() {
        assertEquals(true, st[3].isInDeansList());
        assertEquals(false, st[2].isInDeansList());
        Exception e = new NotInDeansListException();
        assertTrue(e instanceof NotInDeansListException);
        @SuppressWarnings("unused")
        Exception thrown = null;
        try
        {
            st[1].isInDeansList();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NotInDeansListException);
    }
    
    /**
     * test if in academic probation
     */
    public void testIsInAcademicProbation() {
        assertEquals(true, st[0].isInAcademicProbation());
        assertEquals(false, st[2].isInAcademicProbation());
        Exception e = new NotInAcademicProbationException();
        assertTrue(e instanceof NotInAcademicProbationException );        
        Exception thrown = null;
        try
        {
            st[4].isInAcademicProbation();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NotInAcademicProbationException);
    }
    
    /**
     * test compareTo
     */
    public void testCompareTo() {
        st[3].compareTo(st[4]);
        assertEquals(-2, st[3].getId() - st[4].getId());        
    }
}
