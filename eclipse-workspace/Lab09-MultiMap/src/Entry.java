import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Fouh(authored class skeleton)
 * @author Shenyi Yu
 * @version 2018.10.17
 * @param <K> - type of the key
 * @param <V> - type of the values associated to key
 */
public class Entry<K, V>
{
    private K       key;
    private List<V> values;

    /**
     * @param key key
     */
    public Entry(K key)
    {
        this.setKey(key);
        values = new ArrayList<V>();
    }
    
    
    /**
     * creates a new entry. 
     * add value to the list of values
     * @param key key
     * @param value value
     */
    public Entry(K key, V value)
    {
        this.setKey(key);
        values = new ArrayList<V>();
        values.add(value);
    }



    /**
     * @return the key
     */
    public K getKey()
    {
        return key;
    }



    /**
     * @param key the key to set
     */
    public void setKey(K key)
    {
        this.key = key;
    }
    
    /**
     * values getter
     * @return values
     */
    public List<V> getValues() {
        return values;
    }
    
    /**
     * Determines if the value equals the specified key .
     *
     * @param o object
     * @return true if they equal
     */
    
    public boolean equals(Object o) {
        return (o.equals(key));
    }
    
    

}
