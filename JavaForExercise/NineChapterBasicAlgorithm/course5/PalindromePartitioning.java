package course5;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	
	//accepted 3400ms
	public List<List<String>> partition(String s) {
        // write your code here
		List<List<String>> list = new ArrayList<>();
		List<String> innerList = new ArrayList<>();
		if(s == null || s.length() == 0) {
			list.add(innerList);
			return list;
		}

		DFS(list, innerList, s, 0);
		
		return list;
    }
	
	private void DFS(List<List<String>> list, List<String> innerList, String s, int startIndex) {
		if(startIndex == s.length()) {
			list.add(new ArrayList<String>(innerList));
			return;
		}
		
		for(int i = startIndex+1; i <= s.length(); i++) {
			String curr = s.substring(startIndex, i);
			if(!isPalindrome(curr)) {
				continue;
			}
			
			innerList.add(curr);
			DFS(list, innerList, s, i);
			innerList.remove(innerList.size()-1);
		}
	}
	
	private boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length()-1;
		
		while (start+1 < end) {
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
}
