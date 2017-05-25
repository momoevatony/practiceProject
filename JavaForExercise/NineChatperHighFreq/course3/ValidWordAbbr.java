package course3;

import java.util.HashMap;
import java.util.HashSet;

public class ValidWordAbbr {
	
	//accepted 5.24.2017 
	HashMap<String, Integer> map;
	HashSet<String> set;
	// @param dictionary a list of word
    public ValidWordAbbr(String[] dictionary) {
        // Write your code here
    	this.map = new HashMap<>();
    	this.set = new HashSet<>();
    	init(dictionary);
    }

    /**
     * @param word a string
     * @return true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // Write your code here
    	String trans = transform(word);
    	if (map.containsKey(trans)) {
    		if (map.get(trans) > 1) {
    	        return false;
    	    }
    		return set.contains(word);
    	}
    	return true;
    }
    
    private void init(String[] dictionary) {
    	for (String str : dictionary) {
    		String trans = transform(str);
    		if (!set.contains(str)) {
    			set.add(str);
    			if (map.containsKey(trans)) {
        			map.put(trans, map.get(trans) + 1);
        		} else {
        			map.put(trans, 1);
        		}
    		}
    	}
    }
    
    private String transform(String orig) {
    	if (orig.length() <= 2) {
    		return orig;
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append(orig.charAt(0));
    	sb.append(orig.length() - 2);
    	sb.append(orig.charAt(orig.length() - 1));
    	
    	return sb.toString();
    }
}
