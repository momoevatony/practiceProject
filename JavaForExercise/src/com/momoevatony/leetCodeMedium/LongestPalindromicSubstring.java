package com.momoevatony.leetCodeMedium;

public class LongestPalindromicSubstring {
	
	private static int start=0, maxLength=0;
	
	public static void main (String args[]){
		//twoSidesPalindrome(2,2,"abcba");
		System.out.println(longestPalindrome("ababababa"));
	}
	
	//Accepted 7.26.2016
	public static String longestPalindrome(String s) {
		for(int i=0; i<s.length()-maxLength/2+1;i++){
			twoSidesPalindrome(i,i,s);
			if(i<s.length()-1&&s.charAt(i) == s.charAt(i+1)){
				twoSidesPalindrome(i,i+1,s);
			}
		}
        return s.substring(start,start+maxLength);
    }
	
	public static void twoSidesPalindrome (int i, int j, String s){
		System.out.println(i+"th char: "+s.charAt(i));
		while(i>=0 && j<=s.length()-1 && s.charAt(i)==s.charAt(j)){
			System.out.println("Comparing "+s.charAt(i)+" and "+s.charAt(j));
			i--;j++;
		}
		if((j-i-1)>maxLength){
			maxLength = j-i-1;
			start = ++i;
			System.out.println("maxLeng updated to: "+maxLength+" and start is: "+start);
		}
	}

}
