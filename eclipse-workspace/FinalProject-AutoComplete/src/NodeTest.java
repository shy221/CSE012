import student.TestCase;
/**
 * test for Node class 
 * @author Shenyi Yu
 * @version 2018.12.06
 */
public class NodeTest extends TestCase {

    private Node node;
    //private ArrayList<Node> l;

    /**
     * create a new Test object
     */
    public NodeTest() {
        node = new Node("hi", 100);
        assertEquals("hi", node.getTerm().getTerm());
        assertEquals((long)100, node.getTerm().getWeight());


    }

    /**
     * set up 
     */
    public void setUp() {
        node = new Node();

    }


    /**
     * test set term
     */
    public void testSetTerm() {
        Term word = new Term("ace", (long) 1.0);
        node.setTerm(word);
        assertEquals(node.getTerm(), word);

    }
    /**
     * test get term
     */
    public void testGetTerm() {
        Term word = new Term("ace", (long) 1.0);
        node.setTerm(word);
        assertEquals(node.getTerm(), word);

    }
    /**
     * test set word
     */
    public void testSetWord() {
        node.setWords(3);
        assertEquals(node.getWords(), 3);

    }
    /**
     * test get word
     */
    public void testGetWord() {
        node.setWords(3);
        assertEquals(node.getWords(), 3);

    }
    /**
     * test set prefix
     */
    public void testSetPrefix() {
        node.setPrefixes(0);
        assertEquals(node.getPrefixes(), 0);

    }
    /**
     * test get prefix
     */
    public void testGetPrefix() {
        node.setPrefixes(0);
        assertEquals(node.getPrefixes(), 0);

    }

    /**
     * test get child
     */
    public void testGetChild() {
        node.setReferences(97);
        assertNotNull(node.getReferences(97));


    }
    /**
     * test make child
     */
    public void testMakeChild() {
        node.setReferences(97);
        assertNotNull(node.getReferences(97));
        node.setReferences(97);
        assertNotNull(node.getReferences(97));

    }

}
