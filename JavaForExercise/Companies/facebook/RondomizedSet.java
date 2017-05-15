package facebook;

import java.util.ArrayList;
import java.util.HashMap;

public class RondomizedSet {
	
	//accepted 5.14.2017 3095ms
	private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;
    
    public void RandomizedSet() {
        // do initialize if necessary
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    
    // Inserts a value to the set
    // Returns true if the set did not already contain the specified element or false
    public boolean insert(int val) {
        // Write your code here
        if (map.containsKey(val)) {
            return false;
        }
        
        list.add(val);
        map.put(val, list.size() - 1);
        
        return true;
    }
    
    // Removes a value from the set
    // Return true if the set contained the specified element or false
    public boolean remove(int val) {
        // Write your code here
        if (!map.containsKey(val)) {
            return false;
        }
        
        int index = map.get(val);
        int lastVal = list.get(list.size() - 1);
        list.set(index, lastVal);
        map.put(lastVal, index);
        
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    // Get a random element from the set
    public int getRandom() {
        // Write your code here
        return list.get((int)Math.floor(Math.random() * list.size()));
    }
}
