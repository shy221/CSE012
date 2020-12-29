/**
 * 
 * @author Shenyi Yu
 * @version 2018.11.16
 */
public class MapNodeTest extends student.TestCase {
    
    private MapNode<String, Double> mapNode;
    private MapNode<String, Double> mapNode1;
    //private MapNode<String, Double> mapNode2;
    private MapNode<String, Double> mapNode3;
    private ValueNode<Double> value;
    private ValueNode<Double> value2;
    
    /**
     * constructor
     */
    public MapNodeTest() {
        //empty constructor
    }
    
    /**
     * creates a new mapNode
     */
    public void setUp() { 
        mapNode = new MapNode<String, Double>("key", value, null);
        mapNode1 = new MapNode<String, Double>("key1", value2, null);
       // mapNode2 = new MapNode<String, Double>("key2", value, null);
        mapNode3 = new MapNode<String, Double>("key", value, null);
    }
    
    /**
     * test for getkey method 
     */
    public void testGetKey() {
        assertEquals("key", mapNode.getKey());
    }
    
    /**
     * test for setKey method
     */
    public void testSetKey() {
        mapNode.setKey("key6");
        assertEquals("key6", mapNode.getKey());
    }
    
    /**
     * test for getvalues
     */
    public void testGetValues() {
        assertEquals(value, mapNode.getValues());
    }
    
    /**
     * test for setvalues
     */
    public void testSetValues() {
      
        mapNode.setValues(mapNode1.getValues());
        assertEquals(value2, mapNode.getValues());
    }
    
    /**
     * test for getnext
     */
    public void testGetNext() {
        assertNull(mapNode.getNext());
        mapNode.setNext(mapNode1);
        assertEquals(mapNode1, mapNode.getNext());
    }
    
    /**
     * test for set next
     */
    public void testSetNext() {
        mapNode.setNext(mapNode1);
        assertEquals(mapNode1, mapNode.getNext());
    }
    
    /**
     * test for equals
     */
    public void testEquals() {
        assertTrue(mapNode.equals(mapNode3));
        assertFalse(mapNode.equals(mapNode1));
        Object o = new Object();
        assertFalse(mapNode.equals(o));
    }
}
