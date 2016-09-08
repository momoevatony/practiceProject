package com.momoevatony.leetCodeEasy;

public class StrStr {
	public static void main (String args[]){
		
	}
	
	//accepted 9.7.2016
	static int strStr (String haystack, String needle){
		if (needle.length()>haystack.length()){return -1;}
        if (needle.length()==0){return 0;}
		
		for(int i=0; i<=haystack.length()-needle.length();i++){
			if(haystack.substring(i,needle.length()+i).equals(needle)){return i;}
		}
		
		return -1;
	}

}
