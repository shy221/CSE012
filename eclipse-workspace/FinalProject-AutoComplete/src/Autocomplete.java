import java.util.ArrayList;
import java.util.List;

/**
 * @author Shenyi Yu
 * @version 2018.12.06
 * @param root
 */
public class Autocomplete {

    private Node root;
    /**
     * create object
     * 
     */
    public Autocomplete() {
        this.root = new Node();
    }

    // Adds a new word and its associated weight to the Trie - provide Big-O.   
    // worst case:O(n)
    /**
     * @param word   word
     * @param weight weight 
     * worst case:O(n)
     */
    public void addWord(String word, int weight) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 'a' || word.charAt(i) > 'z' ) {
                return;
            }
        }
        addWordHelper(word, 0, weight, root);
    }

    /**
     * @param word   word
     * @param index  index
     * @param weight weight
     * @param node   node worst case:O(nlogn)
     */
    public void addWordHelper(String word, int index, int weight, Node node) {
        
        
        if (index == word.length()) {
            node.setTerm(new Term(word, weight));
            node.setWords(node.getWords() + 1);
            node.setPrefixes(node.getPrefixes() + 1);
            return;
        }
        char nextLetter = word.charAt(index);
        int x = (int) nextLetter - 97;
        node.setPrefixes(node.getPrefixes() + 1);

        if (node.getReferences(x + 97) == null) {
            node.setReferences(x + 97);
        }
        addWordHelper(word, index + 1, weight, node.getReferences(x + 97));
    }

    // Returns the root
    // of the subTrie corresponding to the last character
    // of the prefix - provide Big-O.
    //worst case O(n)
    /**
     * @param prefix prefix
     * @return Node node 
     */
    public Node getSubTrie(String prefix) {
        
        if (prefix == null) {
            return null;
        }

        prefix = prefix.toLowerCase();
        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) < 97 || prefix.charAt(i) > 122 ) {
                return null;
            }
        }
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            String sub = prefix.substring(i, i + 1);
            char subC = sub.charAt(0);

            if (cur.getReferences(subC) == null) {
                return null;
            } 
            else {
                cur = cur.getReferences(subC);
            }
        }
        return cur;
    }

    // The method returns the number of words that start with prefix.
    // worst case O(n)
    /**
     * @param prefix prefix
     * @return count count
     */
    public int countPrefixes(String prefix) {
        prefix = prefix.toLowerCase();
        Node count = getSubTrie(prefix);
        if (count == null) {
            return 0;
        }
        return count.getPrefixes();

    }

    // The method returns a List containing all the Terms objects with query
    // starting with prefix - provide Big-O.
    //worst case O(26^n)
    /**
     * @param prefix prefix
     * @return s s 
     */
    public List<Term> getSuggestions(String prefix) {
        if (prefix == null) {
            return null;
        }
        prefix = prefix.toLowerCase();
        List<Term> s = new ArrayList<Term>();

        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) < 97 || 
                    prefix.charAt(i) > 122 || 
                    getSubTrie(prefix) == null) {
                return null;
            }
        }
        return getSuggestionsHelper(getSubTrie(prefix), s);

    }
    /**
     * @param rt rt
     * @param list list
     * @return Node node 
     */

    public List<Term> getSuggestionsHelper(Node rt, List<Term> list) {

        /*if (root.getWord() > 0) {
                list.add(root.getTerm());
            }*/

        for (int i = 122; i >= 97; i--) {
            if (rt.getReferences(i) != null) {

                if (!rt.getReferences(i).getTerm().getTerm().equals("")) {

                    Node child = rt.getReferences(i);
                    list.add(child.getTerm());

                    //getSuggestionsHelper(child, list);
                }
                getSuggestionsHelper(rt.getReferences(i), list);
            }

        }

        return list;
    }

}
