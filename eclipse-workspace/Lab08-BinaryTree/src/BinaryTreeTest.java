import student.TestCase;

/**
 * Tests Class for methods of the BinaryTree class
 * 
 * @author Shenyi Yu
 * @version 2018.11.25
 */
public class BinaryTreeTest extends TestCase {

    private BinaryTree<String> b1;
	private BinaryTree<String> b2;
	private BinaryTree<String> b3;
	private BinaryTree<String> b4;

	/**
	 * set up method/
	 */
	public void setUp() {
		b4 = new BinaryTree<String>("4");
		b3 = new BinaryTree<String>("3", b4, null);
		b2 = new BinaryTree<String>("32");
		b1 = new BinaryTree<String>("11", b2, b3);
	}

	/**
	 * test set
	 */
	public void testSetElement() {
		b1.setElement("32");
		assertEquals(b1.getElement(), b2.getElement());
	}

	/**
	 * test size
	 */
	public void testSize() {
		assertEquals(4, b1.size());
		assertEquals(1, b2.size());
		assertEquals(2, b3.size());
		BinaryTree<String> b5 = new BinaryTree<String>("5");
		b2.setRight(b5);
		assertEquals(5, b1.size());
		assertEquals(2, b2.size());
		assertEquals(2, b3.size());
	}

	/**
	 * test height
	 */
	public void testHeight() {
		assertEquals(3, b1.height());
		assertEquals(1, b4.height());
		assertEquals(1, b2.height());
		assertEquals(2, b3.height());
		BinaryTree<String> b5 = new BinaryTree<String>("5");
		b4.setLeft(b5);
		assertEquals(4, b1.height());
		assertEquals(1, b2.height());
		assertEquals(2, b4.height());
		assertEquals(3, b3.height());
	}

	/**
	 * test clone
	 */
	public void testClone() {
		BinaryTree<String> copy = b1.clone();
		assertEquals(b1.getElement(), copy.getElement());
		assertEquals(b2.getElement(), copy.getLeft().getElement());
		assertEquals(b3.getElement(), copy.getRight().getElement());
		assertEquals(b4.getElement(), copy.getRight().getLeft().getElement());
	}

	/**
	 * test preorder
	 */
	public void testToPrePrderString() {
		assertEquals("(11 (32) (3 (4)))", b1.toPreOrderString());
		assertEquals("(3 (4))", b3.toPreOrderString());
	}

	/**
	 * test inorder
	 */
	public void testToInPrderString() {
		assertEquals("((32) 11 ((4) 3))", b1.toInOrderString());
		assertEquals("((4) 3)", b3.toInOrderString());
	}

	/**
	 * test postorder
	 */
	public void testToPostPrderString() {
		assertEquals("((32) ((4) 3) 11)", b1.toPostOrderString());
		assertEquals("((4) 3)", b3.toPostOrderString());
	}
}
