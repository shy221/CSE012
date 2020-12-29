/**
 * 
 * @author Shenyi Yu
 * @version 2018.11.18
 */
public class ValueNodeTest extends student.TestCase {

    private ValueNode<Double> theValue;
    private ValueNode<Double> theValue1;
    //private ValueNode<Double> theValue2;
    /**
     * constructor
     */
    public ValueNodeTest() {
        //empty
    }
    
    /**
     * create new value nodes
     */
    public void setUp() {
        theValue = new ValueNode<Double>(1.0);
        theValue1 = new ValueNode<Double>(2.2);
        //theValue2 = new ValueNode<Double>(3.3);
    }
    
    /**
     * test for getnext
     */
    public void testGetNext() {
        ValueNode<Double> a = new ValueNode<Double>(2.0);
        ValueNode<Double> b = new ValueNode<Double>(a);
        assertNull(theValue.getNext());
        a.setNext(b);
        assertEquals(a, b.getNext());
    }
    
    /**
     * test for setNext
     */
    public void testSetNext() {
        theValue.setNext(theValue1);
        assertEquals(theValue1, theValue.getNext());
    }
    
    /**
     * test for getValue
     */
    public void testGetValue() {
        assertEquals(1.0, theValue.getValue(), 0.1);
    }
    
    /**
     * test for setValue
     */
    public void testSetValue() {
        theValue.setValue(2.1);
        assertEquals(2.1, theValue.getValue(), 0.1);
    }
    
}