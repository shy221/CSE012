/**
 * A "node" represents a single element in a sequence. Think of it like a link
 * in a chain -- the node contains an element of data and reference to the
 * previous and next elements in the sequence.
 *
 * This node is "doubly linked" -- it has references to the next node in the
 * chain and the previous node in the chain. You must implement the join and
 * split methods to manage both connections simultaneously, ensuring that the
 * consistency of links in the chain is preserved at all times.
 * @author  Shenyi Yu
 * @version 2018.12.06
 */
public class Node  {
 
 
    private int word;
    private int prefix;
    private Term t;
    private Node[] references;
   


    /**
     * create node object
     */
    public Node() {
        setWords(0);
        setPrefixes(0);
        references = new Node[26];
        t = new Term("", 0);


    }
    /**
     * Creates a new Node with the specified data.
     *
     * @param word word
     * @param weight weight
     */
    public Node(String word, long weight) {
        this();
        t = new Term(word, weight);
    }


    /**
     * Sets the word in the node.
     *
     * @param w w 
     */
    public void setTerm(Term w) {
        t = w;
    }


    /**
     * Gets the node that follows this one in the sequence.
     *
     * @return the node that follows this one in the sequence
     */
    public Term getTerm() {
        return t;
    }

    /**
     * make child 
     * @param i i 
     */
    public void setReferences(int i) {
        if (references[i - 97] == null) {
            references[i - 97] = new Node();
        }
    }
    /**
     * get child
     * @return node node
     * @param i i 
     */
    public Node getReferences(int i) {
        return references[i - 97];

    }

    /**
     * get word
     * @return word word 
     */
    public int getWords() {
        return word;
    }
    /**
     * Sets word
     *
     * @param d d 
     */
    public void setWords(int d) {
        this.word = d;
    }

    /**
     * get prefix
     * @return prefix prefix
     */
    public int getPrefixes() {
        return prefix;
    }

    /**
     * Sets prefix
     *
     * @param p p
     */
    public void setPrefixes(int p) {
        this.prefix = p;
    }



}
