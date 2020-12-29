
/**
 * @author ericfouh
 * @param <K>
 * @param <V>
 * @version 2018.11.17  	
 */
public class MapNode<K, V>
{
    // Singly linked list node class
    private K             key;    // Value for this node
    private ValueNode<V>  values; // Point to head of list values
    private MapNode<K, V> next;   // Point to next node in list


    /**
     * @param key key 
     * @param value value 
     * @param next next 
     */
    public MapNode(K key, ValueNode<V> value, MapNode<K, V> next)
    {
        this.setKey(key);
        this.setValues(value);
        this.setNext(next);
    }


    /**
     * @return the key
     */
    public K getKey()
    {
        return key;
    }


    /**
     * @param key
     *            the key to set
     */
    public void setKey(K key)
    {
        this.key = key;
    }


    /**
     * @return the values
     */
    public ValueNode<V> getValues()
    {
        return values;
    }


    /**
     * @param values
     *            the values to set
     */
    public void setValues(ValueNode<V> values)
    {
        this.values = values;
    }


    /**
     * @return the next
     */
    public MapNode<K, V> getNext()
    {
        return next;
    }


    /**
     * @param next
     *            the next to set
     */
    public void setNext(MapNode<K, V> next)
    {
        this.next = next;
    }

/**
 * @param o object 
 * @return boolean result
 */
    public boolean equals(Object o)
    {
        if (o instanceof MapNode) {
            return this.key.equals(((MapNode<?, ?>)o).getKey()); }
        return false;
    }
}
