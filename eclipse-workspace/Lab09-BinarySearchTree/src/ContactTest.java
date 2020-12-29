import student.TestCase;
/**
 * Tests Class for methods of the contact class
 * 
 * @author Shenyi Yu
 * @version 2018.11.25
 */
public class ContactTest extends TestCase {
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;


    /**
     * set up method/
     */
    public void setUp() {
        contact1 = new Contact("Shenyi", "Yu", "12345");
        contact2 = new Contact("Shenyi", "Hao", "12345");
        contact3 = new Contact("Shengde", "Yu", "12345");
        


    }

    /**
     * test get and set lastname
     */
    public void testGetSetLastName() {
        contact1.setLastName("YYY");
        assertEquals("YYY", contact1.getLastName());

    }


    /**
     * test get and set firstname
     */
    public void testGetSetFirstName() {
        contact2.setFirstName("SSS");
        assertEquals("SSS", contact2.getFirstName());


    }

    /**
     * test get and set number
     */
    public void testGetSetNumber() {
        contact3.setNumber("11111");
        assertEquals("11111", contact3.getNumber());

    }

    /**
     * test compareTo
     */
    public void testCompareTo() {
        contact1.compareTo(contact2);
        assertEquals(-1, contact1.compareTo(contact2));

    }
}
