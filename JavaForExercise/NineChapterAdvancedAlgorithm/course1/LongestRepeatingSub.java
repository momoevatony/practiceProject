package course1;

import java.util.HashMap;

public class LongestRepeatingSub {
	public int longestRepeatingSubsequence(String str) {
        // Write your code here
		int result = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < str.length(); i++) {
			if(map.containsKey(str.charAt(i))){
				result++;
			}else {
				map.put(str.charAt(i), 1);
			}
		}
		
        return result;
    }
}
