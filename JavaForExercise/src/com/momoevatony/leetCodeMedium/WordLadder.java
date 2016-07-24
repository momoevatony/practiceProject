package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WordLadder {
	
	public static void main(String args[]){
		//System.out.println(differByOne("leeeeet","deeeeeg"));
		
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
		
		System.out.println(ladderLength(beginWord, endWord, wordList));
		
	}
	
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		HashMap <String, Integer> map = new HashMap <String, Integer>();
		List<String> list = new ArrayList<String>();
		int index=0;
		String curr;
		map.put(beginWord, 1);
		list.add(beginWord);
		
		while(index< list.size()){
			curr = list.get(index);
			if(differByOne(curr,endWord)){return map.get(curr)+1;}
			
			for(String str:wordList){
				if(!map.containsKey(str) && differByOne(curr,str)){
					list.add(str);
					map.put(str, map.get(curr)+1);
				}
			}
			index++;
		}
        return 0;
    }
	
	public static boolean differByOne(String str1, String str2){
		boolean flag = false;
		if(str1.length()!=str2.length()){return false;}
		for(int i=0;i<str1.length();i++){
			if(str1.charAt(i) != str2.charAt(i)){
				if (flag) {return false;}
				flag=true;
			}
		}
		return true;
	}

}
