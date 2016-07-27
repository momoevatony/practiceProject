package com.momoevatony.leetCodeMedium;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {
	
	public static void main (String args[]){
		List<List<String>> list = partition("a");
		for(List<String> innerList:list){
			System.out.println(Arrays.toString(innerList.toArray()));
		}
	}
	
	
	//Accepted 7.26.2016
    public static List<List<String>> partition(String s) {
    	List<List<String>> list = new ArrayList<List<String>>();
    	partitionDFS(s, 0, s.length(), new ArrayList<String>(), list);
    	return list;
    }
    
    private static void partitionDFS(String s, int start, int end, List<String> innerList, List<List<String>> list){
    	if(s.length()<=1){list.add(new ArrayList<String>(Arrays.asList(s)));return;}
    	
    	if(start>=end){list.add(new ArrayList<>(innerList));return;}
    	
    	for(int i=start; i<end;i++){
    		if(isPalindrome(s.substring(start,i+1))){
    			innerList.add(s.substring(start,i+1));
    			partitionDFS(s, i+1, end, innerList, list);
    			innerList.remove(innerList.size()-1);
    		}
    	}
    	
    }
    
    private static boolean isPalindrome(String s){
    	if(s.length()<=1){return true;}
    	
    	for(int i=0; i<s.length()/2; i++){
    		if(s.charAt(i) != s.charAt(s.length()-i-1)){return false;}
    	}
    	
    	return true;
    }
}
