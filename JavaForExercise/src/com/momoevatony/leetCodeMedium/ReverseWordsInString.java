package com.momoevatony.leetCodeMedium;

public class ReverseWordsInString {
	public static void main (String args[]){
		String test= "a b c d e     ";
		int i = test.length()-1;
		while(i>0 && test.charAt(i)==' '){i--;}
		test = test.substring(0,i+1);
		System.out.println(test);
		System.out.println(test.substring(test.lastIndexOf(' ')+1,test.length()));
		System.out.println(test.substring(0,test.lastIndexOf(' ')));
	}
	
	 public String reverseWords(String s) {
		 String[] words = s.split(" ");
		 StringBuilder sb = new StringBuilder();
		 for(int i=0; i<=words.length-1; i++){
			 if(!words[i].isEmpty()){
				 sb.insert(0, words[i]);
				 if(i<words.length-1){sb.insert(0," ");}
			 }
		 }
		 
		 return sb.toString();
    }
}
