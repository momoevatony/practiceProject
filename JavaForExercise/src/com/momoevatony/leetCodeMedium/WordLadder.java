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
		//System.out.println(differByOne("a","a"));
		/*
		List<Integer> array = new ArrayList<Integer>(Arrays.asList(1,2,3,4,4,5,6,7));
		int length = array.size();
		for(int i=0; i<length;i++){
			if(array.get(i)%2==0){array.remove(i);length=array.size()-1;i--;}
		}
		System.out.print(Arrays.toString(array.toArray()));*/
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList = new HashSet<String>(Arrays.asList("hot","cog","dot","dog","lot","log"));
		
		
		System.out.println(ladderLength(beginWord, endWord, wordList));
		
	}
	
	
	//Accepted on 7.25.2016
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		HashMap <String, Integer> map = new HashMap<String, Integer>();
		List<String> list= new ArrayList<String>();
		int index = 0;
		String curr;
		map.put(beginWord, 1);
		list.add(beginWord);
		if(wordList.contains(beginWord)){wordList.remove(beginWord);}
		
		while(index<list.size()){
			curr = list.get(index);
			if(curr.equals(endWord)){return map.get(curr);}
			if(differByOne(curr,endWord)){return map.get(curr)+1;}
			for (int i=0; i<curr.length();i++){
				char[] currSet = curr.toCharArray();
				for(char j='a';j<='z';j++){
					currSet[i]=j;
					if(wordList.contains(String.valueOf(currSet))){
						//System.out.println("String: "+String.valueOf(currSet)+" value: "+(map.get(curr)+1));
						list.add(String.valueOf(currSet));
						map.put(String.valueOf(currSet), map.get(curr)+1);
						wordList.remove(String.valueOf(currSet));
					}
				}
			}
			index++;
		}
		return 0;
	}
	
	
	//Taking toooooo long time
	public static int ladderLength3(String beginWord, String endWord, Set<String> wordList) {
		HashMap <String, Integer> map = new HashMap <String, Integer>();
		List<String> list = new ArrayList<String>();
		List<String> dict = new ArrayList<String>(wordList);
		int index=0;
		String curr, str;
		map.put(beginWord, 1);
		list.add(beginWord);
		int listLength = dict.size();
		
		while(index< list.size()){
			curr = list.get(index);
			if(differByOne(curr,endWord)){return map.get(curr)+1;}
			
			for(int i=0;i<listLength;i++){
				str = dict.get(i);
				if(!map.containsKey(str) && differByOne(curr,str)){
					list.add(str);
					map.put(str, map.get(curr)+1);
					dict.remove(str);
					i--;
				}
				listLength = dict.size();
			}
			index++;
		}
        return 0;
    }
	
	
	//still taking too long time, and having errors.
	public static int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
		HashMap <String, Integer> startMap = new HashMap <String, Integer>();
		HashMap <String, Integer> endMap = new HashMap <String, Integer>();
		
		List<String> startList = new ArrayList<String>();
		List<String> endList = new ArrayList<String>();
		List<String> startDictList = new ArrayList<String>(wordList);
		List<String> endDictList = new ArrayList<String>(wordList);
		
		String startCurr, endCurr;
		
		int startListIndex = 0;
		int endListIndex = 0;
		int startDictListLength = startDictList.size();
		int endDictListLength = endDictList.size();
		
		startMap.put(beginWord,1);
		endMap.put(endWord, 1);
		
		startList.add(beginWord);
		endList.add(endWord);
		
		while(startListIndex<startList.size() && endListIndex<endList.size()){
			startCurr = startList.get(startListIndex);
			System.out.println("start queue working on: "+startCurr);
			endCurr = endList.get(endListIndex);
			System.out.println("end queue working on: "+endCurr);
			
			for(int i=0; i<startDictListLength; i++){
				if(differByOne(startCurr,startDictList.get(i))){
					
					if(endMap.containsKey(startDictList.get(i))){return endMap.get(startDictList.get(i))+startMap.get(startCurr);}
					startList.add(startDictList.get(i));
					startMap.put(startDictList.get(i), startCurr.equals(startDictList.get(i))? startMap.get(startCurr):startMap.get(startCurr)+1);
					startDictList.remove(i);
					startDictListLength = startDictList.size();
					i--;
				}
			}
			startListIndex++;
			for(int j=0; j<endDictListLength; j++){
				if(differByOne(endCurr,endDictList.get(j))){
					
					if(startMap.containsKey(endDictList.get(j))){return startMap.get(endDictList.get(j))+endMap.get(endCurr);}
					endList.add(endDictList.get(j));
					endMap.put(endDictList.get(j), endCurr.equals(endDictList.get(j))?endMap.get(endCurr):endMap.get(endCurr)+1);
					endDictList.remove(j);
					endDictListLength = endDictList.size();
					j--;
				}
			}
			endListIndex++;
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
