import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link Node} class.
 *
 * @author  Shenyi Yu
 * @version 2018.10.28
 */
public class NodeTest
    extends TestCase
{
    //~ Fields ................................................................


    private Node<String> node1;
    private Node<String> node2;
    private Node<String> node3;
    private Node<String> node4;
    private Node<String> node5;
    private Node<String> node6;
    private Node<String> node7;
    private Node<String> node8;


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Create some new nodes for each test method.
     */
    public void setUp()
    {
        node1 = new Node<String>("node1");
        node2 = new Node<String>("node2");
        node3 = new Node<String>("node3");
        node4 = new Node<String>(null);
        node5 = new Node<String>("node5");
        node6 = new Node<String>("node6");
        node7 = new Node<String>("node7");
        node8 = new Node<String>("node8");
    }
    
    /**
     * test case for setters 
     */
    public void testSetData() {
        node1.setData("Philadelphia");
        assertEquals("Philadelphia", node1.data());
    }
    
    /**
     * test case for getters 
     */
    public void testGetData() {
        assertEquals("node2", node2.data());
    }
    
    /**
     * test case for Next
     */
    public void testNext() {
        node3 = node2.next(); 
        assertEquals(node3, node2.next());
    }
    
    /**
     * Test method for Previous
     */
    public void testPrevious() {
        node2 = node3.previous();
        assertEquals(node2, node3.previous());
    }

    /**
     * Test method for Join
     */
    public void testJoin() {
        node5.join(node6);
        node7.join(node8);
        Exception thrown = null;
        try
        {
            node5.join(node1);
            node2.join(node6);
            node5.join(node7);
            node6.join(node8);
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalStateException);
        //assertEquals(/* expected message */, thrown.getMessage());
        
        
        assertEquals(node3, node3.join(null));
        assertEquals(node3, node3.join(node4));
        assertEquals(node2, node2.join(node3));
    }
    
    /**
     * Test method for Split
     */
    public void testSplit() {
        node1.join(node2);
        node1.split();
        assertEquals(null, node1.next());
        assertEquals(null, node2.previous());
        //node3.join(node4);
        //assertEquals(null, node3.next());
    }

    
}
