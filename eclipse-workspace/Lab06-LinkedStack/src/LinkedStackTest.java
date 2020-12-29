import java.util.EmptyStackException;

import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link LinkedStack} class.
 *
 * @author  Shenyi Yu
 * @version 2018.10.26
 */
public class LinkedStackTest
    extends TestCase
{
    //~ Fields ................................................................

    private LinkedStack<String> stack;


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new LinkedStack<String>();
    }


    /**
     * test case for push
     */
    public void testPush() {
        String s = "012";
        stack.push(s);
        assertEquals("012", stack.peek());
        
    }
    
    /**
     * test case for pop
     */
    public void testPop() {
        Exception thrown = null;
        try {
            String a = "012";
            String b = "017";
            stack.push(a);
            stack.push(b);
            stack.pop();
            assertEquals("012", stack.peek());
            stack.pop();
            stack.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }
    
    /**
     * test case for peek
     */
    public void testPeek() {
        String s = "012";
        stack.push(s);
        stack.peek();
        assertEquals("012", stack.peek());
        
        Exception thrown = null;
        try {
            stack.pop();
            stack.peek();    
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
        
    }
    


    /**
     * test case for isEmpty
     */
    public void testIsEmpty() {
        assertEquals(true, stack.isEmpty());
        String s = "012";
        stack.push(s);
        assertEquals(false, stack.isEmpty());
        
    }
    
    
    
}
