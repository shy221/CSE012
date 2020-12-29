package cs2114;


import student.TestCase;
/**
 * @author Shenyi Yu
 * @version 2018/10/26
 */
public class Lab08DequeTest extends TestCase {
    /**
     * create a new deque
     */
    private Lab08Deque<String> deque;
    
    /**
     * set up
     */
    public void setUp() throws Exception {
        super.setUp();
        deque = new Lab08Deque<String>();
    }

    /**
     * test enqueue at front
     */
    public void testEnqueueAtFront() {
        deque.enqueueAtFront("Hello");
        assertEquals("Hello", deque.frontItem());
        deque.enqueueAtFront("World");
        assertEquals("World", deque.frontItem());
    }
    
    /**
     * test dequeue at front
     */
    public void testDequeueAtFront() {
        assertNull(deque.dequeueAtFront());
        deque.enqueueAtFront("017");
        deque.enqueueAtFront("cse");
        assertEquals("cse", deque.dequeueAtFront());
        assertEquals("017", deque.dequeueAtFront());
    }
    
    /**
     * test enqueue at rear
     */
    public void testEnqueueAtRear() {
        deque.enqueueAtRear("Lehigh");
        assertEquals("Lehigh", deque.rearItem());
        deque.enqueueAtRear("Univ");
        assertEquals("Univ", deque.rearItem());
    }
    
    /**
     * test dequeue at rear
     */
    public void testDequeueAtRear() {
        assertNull(deque.dequeueAtRear());
        deque.enqueueAtRear("999");
        deque.enqueueAtRear("tired");
        assertEquals("tired", deque.dequeueAtRear());
        assertEquals("999", deque.dequeueAtRear());
    }
    
    /**
     * test from item
     */
    public void testFromItem() {
        assertNull(deque.frontItem());
        deque.enqueueAtFront("Save me");
        assertEquals("Save me", deque.frontItem());
    }
    
    /**
     * test rear item
     */
    public void testRearItem() {
        assertNull(deque.rearItem());
        deque.enqueueAtRear("Save me");
        assertEquals("Save me", deque.rearItem());
    }
      
    /**
     * test clear
     */
    public void testClear() {
        assertNull(deque.frontItem());
        deque.enqueueAtFront("017");
        assertEquals("017", deque.frontItem());
        deque.clear();
        assertNull(deque.frontItem());
    }
    /**
     * test size
     */
    public void testSize() {
        assertEquals(0, deque.size());
        deque.enqueueAtFront("lol");
        deque.enqueueAtRear("vpn");
        assertEquals(2, deque.size());
        deque.dequeueAtFront();
        
    }
    /**
     * test toString
     */
    public void testToString() {
        assertEquals("[]", deque.toString());
        deque.enqueueAtFront("Walls could talk");
        assertEquals("[Walls could talk]", deque.toString());
        deque.enqueueAtFront("Castle");
        assertEquals("[Castle, Walls could talk]", deque.toString());
    }

}
