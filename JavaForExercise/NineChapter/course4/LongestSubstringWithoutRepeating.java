package course4;

public class LongestSubstringWithoutRepeating {
	
	//Accetped 12.11.2016 2753ms
	public int lengthOfLongestSubstring(String s) {
        // write your code here
		int max = Integer.MIN_VALUE;
		boolean[] map = new boolean[256];
		int slow=0,fast=0;
		while(slow<s.length()){
			while(fast<s.length()){
			    if(map[s.charAt(fast)]){break;}
				map[s.charAt(fast)] = true;
				fast++;
			}
			max = Math.max(max, fast-slow);
			map[s.charAt(slow)] = false;
			slow++;
		}
		return max==Integer.MIN_VALUE?0:max;
    }
}
