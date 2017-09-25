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
        //Find a place that isn't occupied
        int i = 0;
        while (i < keys.length && i < values.length && i < occupied.length) {
            if (!occupied[i]) {
                break;
            }
        }
        if (items < keys.length && items < values.length) {
            keys[i] = key;
            values[i] = value;
            occupied[i] = true;
            items++;
            return true;
        }
        return false;
    }
    
    public Object get(String key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
    
    public boolean delete(String key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                keys[i] = "";
                values[i] = null;
                occupied[i] = false;
                return true;
            }
        }
        return false;
    }
    
    public float load() {
        return ((float)(items))/keys.length;
    }
}
