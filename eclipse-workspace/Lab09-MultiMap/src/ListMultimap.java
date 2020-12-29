import java.util.ArrayList;
import java.util.List;

/**
 * @author Shenyi Yu
 * @version 2018.10.22
 * @param <K>
 *            - the type of keys maintained by this map
 * @param <V>
 *            - the type of mapped values
 */
public class ListMultimap<K, V> implements Multimap<K, V> {
    /**
     * ArrayList a
     */
    private ArrayList<Entry<K, V>> a;
    
    /**
     * constructor
     */
    public ListMultimap() {
        a = new ArrayList<Entry<K, V>>();
    }
    
    /**
     * Associates the specified value with the specified key in this map. If the
     * multimap previously contained a mapping for the key, the new value is
     * appended to the list of old values.
     * @param key key 
     * @param value value
     * @return The last (added) previous value associated with key, or null if
     *         there was no mapping for key
     */

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException("This key or value is null. ");
        }
        Entry<K, V> q = new Entry<K, V>(key, value);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getKey().equals(key)) {
                if (a.get(i).getValues().contains(value)) {
                    throw new IllegalStateException();
                }
                a.get(i).getValues().add(value);
                return a.get(i).getValues()
                        .get(a.get(i).getValues().size() - 2);
            }
        }
        a.add(q);
        return null;
    }
    
    /**
     * @return Returns true if this map contains no key-value mappings.
     */
    @Override 
    public boolean isEmpty() {
        return a.size() == 0;
    }
    
    /**
     * Returns a list of values to which the specified key is mapped, or null if
     * this map contains no mapping for the key. 
     * @param key  key 
     * @return the list of values mapped to the key or null if the map contained
     *         no mapping for the key
     */
    @Override
    public List<V> get(Object key) {
        
        if (key == null) {
            throw new NullPointerException("This key is null.");
        }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getKey() == key) {
                return a.get(i).getValues();
            }
        }
        throw new IllegalStateException();  
        
    }
    
    /**
     * Replaces the entry for the specified key only if currently mapped to the
     * specified value.
     * @param key key
     * @param oldValue value 
     * @param newValue value 
     * @return true if the value was replaced
     */
    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        
        if (key == null || oldValue == null || newValue == null) {
            throw new NullPointerException("This key,"
                    + " old value or new value is null.");
        }
        
        if (oldValue.equals(newValue)) {
            throw new IllegalStateException();
        }
        
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getKey().equals(key)) {
                for (int j = 0; j < a.get(i).getValues().size(); j++) {
                    if (a.get(i).getValues().get(j).equals(oldValue)) {
                        a.get(i).getValues().set(j, newValue);
                        return true;
                    }
                }
            }
        }
            
        throw new IllegalStateException();
    }


    /**
     * Removes the mapping for a key from this map if it is present. 
     * @param key key
     * @return the list of values mapped to the key or null if the map contained
     *         no mapping for the key
     */
    @Override
    public List<V> remove(Object key) {
        if (key == null) {
            throw new NullPointerException("This key is null.");
        }

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getKey().equals(key)) {
                List<V> b = new ArrayList<V>();
                b = a.get(i).getValues();
                a.remove(a.get(i));
                return b;
                
            }
        }
        throw new IllegalStateException();
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. 
     * @param key key 
     * @param value value 
     * @return true if the value was removed. 
     */
    @Override 
    public boolean remove(Object key, Object value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        int check = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getKey().equals(key)) {
                check++ ;
                for (int j = 0; j < a.get(i).getValues().size(); j++) {
                    if (a.get(i).getValues().get(j).equals(value)) {
                        if (a.get(i).getValues().size() == 1) {
                            a.remove(i);
                            return true;
                        }
                        a.get(i).getValues().remove(j);
                        return true;
                    }
                }
            }
        }
        if (check != 0) {
            return false;
        }
        throw new IllegalStateException();
    }


    @Override
    public int size() {
        return a.size();
    }

  

}