package course5;

public class LongestPalindromicSubstring {
	
	//Accepted 12.12.2016 25329ms
	public String longestPalindrome(String s) {
        // Write your code here
        if(s.length()==0){return "";}
		if(s.length()==1){return s;}
		String result = "";
		
		int left =0;
		int right =0;
		
		for(int i=0; i<s.length();i++){
			String curr = Character.toString(s.charAt(i));
			left = i-1;
			right = i+1;
			while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
				curr = Character.toString(s.charAt(left)) + curr + Character.toString(s.charAt(right));
				left--;
				right++;
			}
			result = result.length() > curr.length()? result:curr;
			
			if(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)){
			    curr = Character.toString(s.charAt(i))+ Character.toString(s.charAt(i+1));
				left = i-1;
				right = i+2;
				while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
					curr = Character.toString(s.charAt(left)) + curr + Character.toString(s.charAt(right));
					left--;
					right++;
				}
			    result = result.length() > curr.length()? result:curr;
			}
			
		}
		
		return result;
    }
}
