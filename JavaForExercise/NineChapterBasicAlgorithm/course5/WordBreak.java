package course5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	//accepted 3.14.2017 4325ms NEEDS REDO
	private int getMax(Set<String> dict) {
		int max = 0;
		for(String word : dict) {
			if(word.length() > max) {max = word.length();}
		}
		return max;
	}
	
	public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if(s == null || s.length() == 0) {return true;}
        int maxLength = getMax(dict);
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        
        for(int currLength = 1; currLength <= s.length(); currLength++) {
        	for(int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= currLength; lastWordLength++) {
        		if(!valid[currLength - lastWordLength]) {
        			continue;
        		}
        		String curr = s.substring(currLength - lastWordLength, currLength);
        		if(dict.contains(curr)) {
        			valid[currLength] = true;
        			break;
        		}
        	}
        }
		
		return valid[s.length()];
    }
}
