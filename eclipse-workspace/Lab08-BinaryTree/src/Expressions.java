/**
 * expression tree class and print tree
 * @author Shenyi Yu
 * @version 2018.11.26
 */
public class Expressions {
    /**
     * @param args for main
     */
    public static void main(String[] args) {
        // Test your ExpressionTree class here
        BinaryTree<String> rv1L = new BinaryTree<String>("c");
        BinaryTree<String> rv1R = new BinaryTree<String>("d");
        BinaryTree<String> right2 = new BinaryTree<String>("+", rv1L, rv1R);
        BinaryTree<String> rvR = new BinaryTree<String>("e");
        BinaryTree<String> right1 = new BinaryTree<String>("/", right2, rvR);
        BinaryTree<String> lvL = new BinaryTree<String>("a");
        BinaryTree<String> lvR = new BinaryTree<String>("b");
        BinaryTree<String> left1 = new BinaryTree<String>("-", lvL, lvR);
        BinaryTree<String> tree = new BinaryTree<String>("*", left1, right1);
        System.out.println(tree.toPreOrderString());
        System.out.println(tree.toInOrderString());
        System.out.println(tree.toPostOrderString());
    }
}
