import student.TestCase;
/**
 * Tests Class for methods of the BinaryTree class
 * 
 * @author Shenyi Yu
 * @version 2018.11.25
 */
public class BinarySearchTreeTest extends TestCase {
    private BinarySearchTree<String> a;
    // private BinarySearchTree<String> b2;


    /**
     * set up method/
     */
    public void setUp() {
        //b2 = new BinarySearchTree<String>();
        a = new BinarySearchTree<String>();
    }

    /**
     * test case for insert
     */
    public void testInsert() {
        a.insert("L");
        a.insert("D");
        a.insert("T");
        Exception thrown = null;
        try {
            a.insert("L");
        }
        catch (Exception exception) {
            thrown = exception;

        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof DuplicateItemException);     
    }

    /**
     * test case for remove
     */
    public void testRemove() {
        a.insert("L");
        a.insert("D");
        a.insert("T");
        a.insert("F");
        a.insert("E");
        a.insert("Z");

        a.remove("F");
        a.remove("E");
        a.remove("D");

        Exception thrown = null;
        try {
            a.remove("Q");
        }
        catch (Exception exception) {
            thrown = exception;

        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof ItemNotFoundException);

    }


    /**
     * test case for findMin
     */
    public void testFindMin() {
        assertNull(a.findMin());
        a.insert("L");
        a.insert("D");
        a.insert("T");
        assertEquals("D", a.findMin());

    }


    /**
     * test case for FindMax
     */
    public void testFindMax() {
        assertNull(a.findMax());
        a.insert("L");
        a.insert("D");
        a.insert("T");
        assertEquals("T", a.findMax());

    }


    /**
     * test case for find
     */
    public void testFind() {
        assertNull(a.find("1"));
        a.insert("L");
        a.insert("D");
        a.insert("T");

        assertEquals("L", a.find("L"));
        assertEquals(null, a.find("Q"));

    }


    /**
     * test case for make empty
     */
    public void testMakeEmpty() {
        a.insert("L");
        a.insert("D");
        a.insert("T");
        assertFalse(a.isEmpty());
        a.makeEmpty();
        assertTrue(a.isEmpty());

    }    

    /**
     * test case for is empty
     */
    public void testIsEmpty() {
        assertTrue(a.isEmpty());
        a.insert("L");
        a.insert("D");
        a.insert("T");       
        assertFalse(a.isEmpty());

    }


}
