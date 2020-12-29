// -------------------------------------------------------------------------
/**
 * Represents the comarray of student . 
 *
 * @author Shenyi Yu
 * @version  2018.09.14
 */
public class CompArray {
    private SuperArray s;
    private int addCount;
    /**
     *create a comp array object
     */
    public CompArray() {
        SuperArray sa = new SuperArray();
        this.s = sa;                    
        this.addCount = 0;
    }
    /**
     * create a comp array object
     * @param s s 
     */
    public CompArray(SuperArray s)
    {
        this.s = s;
    }
    /**
     * Insert an object into a SuperArray object.
     * @param o o
     */
    public void add(Object o)
    {
        addCount++;
        s.add(o);
    }   
    /**
     * Insert an object into a SuperArray object.
     * @param c c
     */
    public void addAll(Object[] c)
    {
        addCount += c.length;
        s.addAll(c);
        
    }

    /**
     * getter of count.
     * @return the total amount added
     */
    public int getAddCount()
    {
        return this.addCount;
    } 
}