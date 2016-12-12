package course4;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinct {
	
	//Accetped 12.11.2016 6030ms
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(k==0){return 0;}
		int max = Integer.MIN_VALUE;
		HashMap<Character, Integer>map = new HashMap<Character, Integer>();
		int slow=0,fast=0,count=0;
		while(slow<s.length()){
			while(fast<s.length()){
				char ch = s.charAt(fast);
				if(map.containsKey(ch)){
					map.put(ch, map.get(ch)+1);
				}else{
					if(map.size()==k){break;}
					map.put(ch, 1);
				}
				fast++;
			}
			max = Math.max(max, fast-slow);
			char ch = s.charAt(slow);
			if(map.get(ch)>1){
				map.put(ch, map.get(ch)-1);
			}else{
				map.remove(ch);
			}
			slow++;
		}
		
		return max==Integer.MIN_VALUE?0:max;
    }
}
