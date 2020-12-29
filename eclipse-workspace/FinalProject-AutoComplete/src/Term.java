import java.util.Comparator;
/**
 * @author  Shenyi Yu
 * @version 2018.12.06
 */
public class Term implements Comparable<Term> {
    private String term;
    private long weight = 0;

    /**
     * constructor
     * @param term term 
     * @param weight weight 
     */
    public Term(String term, long weight) {
        if (term == null || weight < 0) {
            throw new IllegalArgumentException();
        }
        this.term = term;
        this.weight = weight;

    }
    /**
     * Sets the word in the node.
     *
     * @param word the word
     */
    public void setTerm(String word) {
        term = word;
    }

    /**
     * Gets the query
     * @return the node that follows this one in the sequence
     */
    public String getTerm() {
        return term;
    }

    /**
     * Sets the word in the node.
     *
     * @param w w 
     */
    public void setWeight(long w) {
        weight = w;
    }

    /**
     * Gets the weight
     *
     * @return the node that follows this one in the sequence
     */
    public long getWeight() {
        return weight;
    }
    // Compares the two terms in descending order by weight.
    /**

     * Comparator for  objects.

     * @return comparator

     */
    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            public int compare(Term t1, Term t2) {
                if (t1.weight > t2.weight) {
                    return -1;
                }
                else if (t1.weight == t2.weight) {
                    return 0;
                }
                return 1;
            }
        };
    }



    // Compares the two terms in lexicographic order 
    //but using only the first r characters of each query.
    /**

     * Comparator for s objects.
     * @param r r 

     * @return comparator 

     */
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) {
            throw new IllegalArgumentException();
        }

        return new Comparator<Term>() {
            public int compare(Term t1, Term t2) {
                String s1 = t1.getTerm();
                String s2 = t2.getTerm();
                int minlength = s1.length() < s2.length() 
                        ? s1.length() : s2.length();
                if (minlength >= r) {
                    return s1.substring(0, r).compareTo(s2.substring(0, r));
                }
                else if ((s1.substring(0, minlength)).
                        compareTo(s2.substring(0, minlength)) == 0) {
                    if (s1.length() == minlength) {
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
                else {
                    return s1.substring(0, minlength).
                            compareTo(s2.substring(0, minlength));
                }
            }
        };
    }

    //Compares the two terms in lexicographic order by query.
    /**
     * compare
     * @param that that
     * @return int int 
     * 
     */
    public int compareTo(Term that) {
        return this.term.compareTo(that.term);
    }


    /**
     * @return String string
     */
    public String toString() {
        return this.weight + "\t" + this.term;
    }



}
