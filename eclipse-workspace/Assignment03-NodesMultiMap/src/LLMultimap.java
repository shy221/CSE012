/**
 * @author ericfouh
 * @author ysy
 * @param <K>
 * @param <V>
 * @version 2018.11.17  	
 */
public class LLMultimap<K, V> implements Multimap<K, V> {
    /**
     * The head.
     */
    protected MapNode<K, V> head;
    /**
     * The size.
     */
    protected int size;

    /**
     * constructor
     */

    public LLMultimap() {
        head = new MapNode<K, V>(null, null, head);
        size = 0;

    }

    /**
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return The last (added) previous value associated with key
     */
    @Override
    public V put(K key, V value) {
    	if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
    	MapNode<K, V> cp = head;
        while (cp.getKey() != null && !cp.getKey().equals(key)) {
    	    cp = cp.getNext();
        }
        if (cp.getKey() == null) {
    	    ValueNode<V> temp = new ValueNode<V>(value);
    	    MapNode<K, V> newNode = new MapNode<K, V>(key, temp, head);
    	    head = newNode;
    	    size++;
    	    head.setValues(temp);
    	    return null;
	    }
        ValueNode<V> headValue = cp.getValues();
        while (headValue != null) {
    	    if (headValue.getValue().equals(value)) {
    	    	throw new IllegalStateException();
    	    }
    	    headValue = headValue.getNext();
        }
        ValueNode<V> createNode = new ValueNode<V>(value);
        createNode.setNext(cp.getValues());
        cp.setValues(createNode);
        V retval = cp.getValues().getNext().getValue();
        return retval;
       

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param key - the key whose associated value is to be returned
     * @return the list of values mapped to the key 
     * or null if the map contained no
     *         mapping for the key
     */

	@Override
    public ValueNode<V> get(Object key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        MapNode<K, V> cp = head;
        while (cp.getKey() != null) {
        	if (cp.getKey().equals(key)) {
        		return cp.getValues();
        	}
        	cp = cp.getNext();
        }
        throw new IllegalStateException();
    }

    /**
     * @param key      - key with which the specified value is associated
     * @param oldValue - value expected to be associated with the specified key
     * @param newValue - value to be associated with the specified key
     * @return true if the value was replaced
     */
    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        if (key == null || oldValue == null || newValue == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
        	throw new IllegalStateException();
        }
        MapNode<K, V> cp = head;
        while (cp.getKey() != null && !cp.getKey().equals(key)) {
     	    cp = cp.getNext();
        }
        if (cp.getKey() == null) {
        	throw new IllegalStateException();
        }
        ValueNode<V> headValue = cp.getValues();
        while (headValue != null) {
        	if (headValue.getValue().equals(oldValue)) {
        		headValue.setValue(newValue);
        		return true;
        	}
        	headValue = headValue.getNext();
        }
        throw new IllegalStateException();
    }

    /**
     * @param key - key with which the specified value is associated
     * @return the list of values mapped to the key
     */
    @Override
    public ValueNode<V> remove(Object key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
        	throw new IllegalStateException();
        }
        MapNode<K, V> cp = head;
        if (cp.getKey().equals(key)) {
        	ValueNode<V> temp = cp.getValues();
        	head = head.getNext();
        	size--;
        	return temp;
        }
        while (cp.getNext().getKey() != null) {
        	if (cp.getNext().getKey().equals(key)) {
        		ValueNode<V> temp = cp.getNext().getValues();
        		cp.setNext(cp.getNext().getNext());
        		size--;
        		return temp;
        	}
        	cp = cp.getNext();
        }
        throw new IllegalStateException();

    }

    /**
     * @param key   - key with which the specified value is associated
     * @param value - value expected to be associated with the specified key
     * @return true if the value was removed.
     */

	@Override
    public boolean remove(Object key, Object value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
        	throw new IllegalStateException();
        }
        MapNode<K, V> cp = head;
        
        while (cp.getKey() != null) {
        	if (cp.getKey().equals(key)) {
        		ValueNode<V> temp = cp.getValues();
        		if (temp.getValue().equals(value)) {
        			if (temp.getNext() == null) {
        				this.remove(key);
        				return true;
        			}
        			temp = temp.getNext();
        			cp.setValues(temp);
        			return true;
        		}
        		while (temp.getNext() != null) {
        			if (temp.getNext().getValue().equals(value)) {
        				temp.setNext(temp.getNext().getNext());
        				return true;
        			}
        		}
        		return false;
        	}
        	cp = cp.getNext();
        }
        throw new IllegalStateException();
    }

    /**
     * method size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return a string representation of the multimap in the format [{key1:
     *         [value1, value2]}, {key2: [value3]}] an empty map returns "[{}]"
     */
    public String toString() {
        String r = "[{";
        MapNode<K, V> cp = head;
        if (size == 0) {
            r += "}]";
            return r;
        }

        while (cp.getKey() != null) {
            r += cp.getKey() + ": [";
            ValueNode<V> temp = cp.getValues();
            while (temp != null) {
                r += temp.getValue();
                if (temp.getNext() != null) {
                    r = r + ", ";
                } 
                temp = temp.getNext();
            }
            r += "]}";
            cp = cp.getNext();
            if (cp.getNext() != null) {
                r = r + ", {";
            } 
        }
        r += "]";
        return r;
    }

}