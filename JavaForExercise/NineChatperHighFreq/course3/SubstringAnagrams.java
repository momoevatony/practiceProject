package course3;

import java.util.ArrayList;
import java.util.List;

public class SubstringAnagrams {
	
	//accepted 5.23.2017 5951ms
	public List<Integer> findAnagrams(String s, String p) {
        // Write your code here
		List<Integer> list = new ArrayList<Integer>();
		int sLength = s.length();
		int pLength = p.length();
		
		int[] map = new int[26];
		
		for (char ch : p.toCharArray()) {
			map[ch - 'a']++;
		}
		
		int start = 0;
		int end = 0;
		int match = 0;
		
		while (end < sLength) {
			if (map[s.charAt(end) - 'a'] > 0) {
				match++;
			}
			map[s.charAt(end) - 'a']--;
			end++;
			if (match == pLength) {
				list.add(start);
			}
			
			if (end - start == pLength) {
				if (map[s.charAt(start) - 'a'] >= 0) {
					match--;
				}
				map[s.charAt(start) - 'a']++;
				start++;
			}
		}
		
		return list;
    }
}
