/**
 * Tests for the {@link ListMultimap} class.
 * @author Shenyi Yu
 * @version 2018.10.22
 * @param <K>
 *            - the type of keys maintained by this map
 * @param <V>
 *            - the type of mapped values
 */

public class ListMultimapTest<V, K> extends student.TestCase {
   
    private ListMultimap<String, String> q;
    /**
     * creates a new map
     */
    public void setUp() {
        q = new ListMultimap<String, String>();
 
    }
    /**
     * no argument constructor 
     */
    public ListMultimapTest() {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    
    /**
     * test case for put 
     */
    public void testPut() {
        
        assertNull(q.put("a", "4"));
        assertEquals("4", q.put("a", "2"));
        
        Exception thrown = null;
        try {
            q.put(null, " ");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NullPointerException);
        
        
        Exception thrown1 = null;
        try {
            q.put("key", null);
        }
        catch (Exception exception) {
            thrown1 = exception;
        }
        assertNotNull(thrown1);
        assertTrue(thrown1 instanceof NullPointerException);

        
        Exception thrown2 = null;
        try {
            q.put("a", "1");
            q.put("a", "1");
        }
        catch (Exception exception) {
            thrown2 = exception;
        }
        assertNotNull(thrown2);
        assertTrue(thrown2 instanceof IllegalStateException);
        
      
    }
    /**
     * test case for get
     */
    public void testGet() {
        q.put("4", "8");
        assertEquals("8", q.get("4").get(0));
        
        Exception thrown = null;
        try {
            q.get(null);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NullPointerException);
        
        Exception thrown1 = null;
        try {
            q.get("0");
        }
        catch (Exception exception) {
            thrown1 = exception;
        }
        assertNotNull(thrown1);
        assertTrue(thrown1 instanceof IllegalStateException);
    }
    
    /**
     * test case for first remove 
     */
    public void testRemove() {
        
        Exception thrown = null;
        try {
           
            q.remove(null);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NullPointerException);
        
        Exception thrown1 = null;
        try {
           
            q.remove("1");
        }
        catch (Exception exception) {
            thrown1 = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown1 instanceof IllegalStateException);
        
       
        q.put("a", "2");
        q.remove("a");
        assertEquals(0, q.size());
    }
    
    /**
     * test case for isEmpty 
     */
    public void testIsEmpty() {
        assertTrue(q.isEmpty());
        q.put("a", "1");
        assertFalse(q.isEmpty());
    }
    
    /**
     * test case for replace
     */
    public void testReplace() {
        
        Exception thrown = null;
        try {
           
            q.replace("a", null, "1");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NullPointerException);
        
        
        Exception thrown1 = null;
        try {
           
            q.replace(null, "a", "1");
        }
        catch (Exception exception) {
            thrown1 = exception;
        }
        assertNotNull(thrown1);
        assertTrue(thrown1 instanceof NullPointerException);
        
        Exception thrown2 = null;
        try {
           
            q.replace("a", "1", null);
        }
        catch (Exception exception) {
            thrown2 = exception;
        }
        assertNotNull(thrown2);
        assertTrue(thrown2 instanceof NullPointerException);
        
        Exception thrown3 = null;
        try {
           
            q.replace("s", "a", null);
        }
        catch (Exception exception) {
            thrown3 = exception;
        }
        assertNotNull(thrown3);
        assertTrue(thrown3 instanceof NullPointerException);
        
        
        Exception thrown4 = null;
        try {
           
            q.replace("1", "a", "a");
        }
        catch (Exception exception) {
            thrown4 = exception;
        }
        assertNotNull(thrown4);
        assertTrue(thrown4 instanceof IllegalStateException);
        
        Exception thrown5 = null;
        try {
            q.put("1", "a");
            q.replace("1", "b", "a");
        }
        catch (Exception exception) {
            thrown5 = exception;
        }
        assertNotNull(thrown5);
        assertTrue(thrown5 instanceof IllegalStateException);
        
        
        
        Exception thrown6 = null;
        try {
            
            q.replace("1", "x", "a");
        }
        catch (Exception exception) {
            thrown6 = exception;
        }
        assertNotNull(thrown6);
        assertTrue(thrown6 instanceof IllegalStateException);
        
        
        q.put("a", "2");
        
        assertTrue(q.replace("a", "2", "0"));
    }
    
    /**
     * test case for second remove 
     */
    public void testRemove2() {
        q.put("a", "1");
        q.put("a", "2");
        assertTrue(q.remove("a", "1"));
        
        assertEquals(1, q.size());
        
        
        Exception thrown = null;
        try {
           
            q.remove("a", null);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NullPointerException);
        
        
        Exception thrown1 = null;
        try {
           
            q.remove(null, "a");
        }
        catch (Exception exception) {
            thrown1 = exception;
        }
        assertNotNull(thrown1);
        assertTrue(thrown1 instanceof NullPointerException);
        
        Exception thrown2 = null;
        try {
           
            q.remove("c", "a");
        }
        catch (Exception exception) {
            thrown2 = exception;
        }
        assertNotNull(thrown2);
        assertTrue(thrown2 instanceof IllegalStateException);
        
        
        
    }
    
    /**
     * test case for size
     */
    public void testSize() {
        assertEquals(0, q.size());
        q.put("a", "c");
        assertEquals(1, q.size());
    }



    
    
    

}
