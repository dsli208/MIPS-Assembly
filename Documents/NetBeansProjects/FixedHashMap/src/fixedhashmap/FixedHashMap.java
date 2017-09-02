/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixedhashmap;

/**
 *
 * @author dsli
 */
public class FixedHashMap {

    private String[] keys;
    private Object[] values;
    private boolean[] occupied;
    private int items;
    
    public FixedHashMap(int size) {
        keys = new String[size];
        values = new Object[size];
        occupied = new boolean[size];
        items = 0;
    }
    
    public boolean set(String key, Object value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        if (items < keys.length && items < values.length) {
            keys[items] = key;
            values[items] = value;
            occupied[items] = true;
            items++;
            return true;
        }
        return false;
    }
    
    public Object get(String key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
    
    public float load() {
        return ((float)(items))/keys.length;
    }
}
