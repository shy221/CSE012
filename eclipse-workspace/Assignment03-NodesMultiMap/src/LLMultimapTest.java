

/**
 * @author Shenyi Yu
 * @version 2018.11.17
 * @param <K> - type of the key
 * @param <V> - type of the values associated to key
 */
public class LLMultimapTest<V, K> extends student.TestCase {

	private LLMultimap<String, Double> map1;
	private LLMultimap<String, Integer> map2;
	/**
	 * set up
	 */
	public void setUp() {
		map1 = new LLMultimap<String, Double>() ;
		map2 = new LLMultimap<String, Integer>();
		
	}
	/**
	 * no argument constructor
	 */

	public LLMultimapTest() {
		// The constructor is usually empty in unit tests, since it run
		// once for the whole class, not once for each test method.
		// Per-test initialization should be placed in setUp() instead	  	
	}


	/**	  	
	 * test case for put 
	 */	  	
	public void testPut() {
		Exception thrown = null;
		try {
			map1.put(null, null);
			
		}
		catch (Exception e) {
			thrown = e;
		}
		assertNotNull(thrown);
		assertTrue(thrown instanceof IllegalArgumentException);
		assertNull(map2.put("hello", 30));
		assertEquals(30, (int)map2.put("hello", 10));
		try {
			map2.put("hello", 10);
		}
		catch (Exception e) {
			thrown = e;
		}
		assertNotNull(thrown);
		assertTrue(thrown instanceof IllegalStateException);
	}
	
	
	/**	  	
	 * test case for get 
	 */	  	
	public void testGet() {
		Exception thrown = null;
		try {
			map2.get(null);
		}
		catch (Exception e) {
			thrown = e;
		}
		assertNotNull(thrown);
		assertTrue(thrown instanceof IllegalArgumentException);

		try {
			map2.get("hello");
		}
		catch (Exception e) {
			thrown = e;
		}
		assertNotNull(thrown);
		assertTrue(thrown instanceof IllegalStateException);
		
		map2.put("hello", 10);
		map2.put("hello", 20);
		map2.put("hello", 30);
		assertEquals(30, (int)map2.get("hello").getValue());
		
	}
	/**	  	
	 * test case for hello remove 
	 */	  	
	public void testRemove() {
		Exception thrown = null;
		try {
			map2.remove(null);
		}
		catch (Exception e) {
			thrown = e;
		}
		assertNotNull(thrown);
		assertTrue(thrown instanceof IllegalArgumentException);

		map2 = new LLMultimap<String, Integer>();
		thrown = null;
		try {
			map2.remove("hello");
		}
		catch (Exception e) {
			thrown = e;
		}
		assertNotNull(thrown);
		assertTrue(thrown instanceof IllegalStateException);
		
		map2.put("hello", 10);
		map2.put("hello", 20);
		map2.put("hello", 30);
		assertEquals(30, (int)map2.get("hello").getValue());
	}
	/**	  	
	 * test case for isEmpty 
	 */	  	
	public void testIsEmpty() {
		assertTrue(map1.isEmpty());
		map1.put("hello", 10.3);
		assertFalse(map1.isEmpty());
	}
	/**	  	
	 * test case for replace 
	 */	  	
	public void testReplace() {
		Exception thrown = null;
		try {
			map2.replace(null, null, null);
		}
		catch (Exception e) {
			thrown = e;
		}
		assertNotNull(thrown);
		assertTrue(thrown instanceof IllegalArgumentException);

		try {
			map2.replace("hello", 4, 5);
		}
		catch (Exception e) {
			thrown = e;
		}
		assertNotNull(thrown);
		assertTrue(thrown instanceof IllegalStateException);
		
		map2.put("hello", 1);
		map2.put("hello", 2);
		map2.put("hello", 3);
		
		try {
			map2.replace("hello", 4, 5);
		}
		catch (Exception e) {
			thrown = e;
		}
		assertNotNull(thrown);
		assertTrue(thrown instanceof IllegalStateException);
		assertTrue(map2.replace("hello", 3, 5));
		
	}
	/**	  	
	 * test case for bye remove 
	 */	  	
	public void testRemove2() {
		Exception thrown = null;
		try {
			map2.remove(null, null);
		}
		catch (Exception e) {
			thrown = e;
		}
		assertNotNull(thrown);
		assertTrue(thrown instanceof IllegalArgumentException);
		
		try {
			map2.remove("hello", 1);
		}
		catch (Exception e) {
			thrown = e;
		}
		assertNotNull(thrown);
		assertTrue(thrown instanceof IllegalStateException);
		map2.put("hello", 10);
		map2.put("hello", 20);
		map2.put("hello", 30);
		assertTrue(map2.remove("hello", 20));
	}
	/**	  	
	 * test case for size
	 */	  	
	public void testSize() {
		assertEquals(0, map2.size());
		map2.put("hello", 10);
		map2.put("bye", 20);		
		assertEquals(2, map2.size());
		
	}
	/**	  	
	 * test case for toString
	 */	  	
	public void testToString() {
		assertEquals("[{}]", map2.toString());
		map2.put("hello", 10);
		assertEquals("[{hello: [10]}]", map2.toString());
		map2.put("hello", 20);
		map2.put("hello", 30);
		map2.put("bye", 10);
		map2.put("bye", 20);
		map2.put("bye", 30);
		assertEquals("[{bye: [30, 20, 10]}, "
				+ "{hello: [30, 20, 10]}]", map2.toString());
	}
	
	
	
	
}
