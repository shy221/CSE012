/**
 * this class is used to create a subarray class
 * @author Shenyi Yu
 * @version Sep,14,2018 
 */
public class SubArray extends SuperArray {
    private int addCount;
    // ----------------------------------------------------------
    /**
     * Create a new SubArray object. 
     */
    public SubArray()
    {
        super();
        addCount = 0;
        // your code here
    }
    // ----------------------------------------------------------
    /**
     * @return the add count 
     */
    public int getAddCount()
    {
        return addCount;
    }
    
    /**
     * @param anEntry an entry
     */
    public void add(Object anEntry) {
        addCount++;
        super.add(anEntry);
    }
    /**
     * @param c c
     */
    public void addAll(Object[] c) {
        addCount += c.length;
        super.addAll(c);
    }
}
