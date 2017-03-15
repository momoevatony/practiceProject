package course5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
	
	//accepted 3.14.2017 4705ms
	private int findMax(Set<String> wordDict) {
		int max = 0;
		for(String word : wordDict) {
			if(word.length() > max) {max = word.length();}
		}
		return max;
	}
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
        // Write your code here
		List<String> list = new ArrayList<String>();
		if(s == null || s.length() == 0) {return list;}
		
		int maxLength = findMax(wordDict);
		boolean[] valid = new boolean[s.length() + 1];
		valid[0] = true;
		
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 1; j <= maxLength && j <= i; j++) {
				if(!valid[i - j]) {
					continue;
				}
				String curr = s.substring(i - j, i);
				if(wordDict.contains(curr)) {
					valid[i] = true;
					break;
				}
			}
		}
		
		if(!valid[s.length()]) {return list;}
		
		DFS(s, wordDict, list, "", valid, 1);
		
		return list;
    }
	
	private void DFS(String s, Set<String> wordDict, List<String> list, String curr, boolean[] valid, int start) {
		if(start > s.length()) {
			list.add(new String(curr.substring(1)));
			return;
		}
		
		for(int end = start; end <= s.length(); end++) {
			if(!valid[end]) {continue;}
			String newPart = s.substring(start-1, end);
			if(!wordDict.contains(newPart)) {continue;}
			curr = curr +" "+ newPart;
			DFS(s, wordDict, list, curr, valid, end+1);
			curr = curr.substring(0, curr.length() - newPart.length() - 1);
		}
	}
}
