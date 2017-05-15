package facebook;

import java.util.ArrayList;

public class LetterComboOfPhoneNum {
	
	//Accepted 5.13.2017 9835ms
	public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> list = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return list;
        }
        
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        dfs(digits, 0, list, map, "");
        
        return list;
    }
    
    private void dfs(String digits, int index, ArrayList<String> list, String[] map, String curr) {
        //System.out.println("index: "+index+" curr: "+curr);
        if (index >= digits.length()) {
            list.add(new String(curr));
            return;
        }
        
        for (char ch : map[(int)(digits.charAt(index) - '0')].toCharArray()) {
            curr = curr + ch;
            dfs(digits, index + 1, list, map, curr);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}
