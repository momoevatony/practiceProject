package course1;

import java.util.HashMap;
import java.util.Map;

public class StringsHomomorphism {
	
	//accepted 5.7.2017 
	public boolean isIsomorphic(String s, String t) {
        // Write your code here
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
            
            if (map2.containsKey(t.charAt(i))) {
                if (map2.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                map2.put(t.charAt(i), s.charAt(i));
            }
        }
        
        return true;
    }
}
