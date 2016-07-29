package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	
	public static void main (String args[]){
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		for(List<String>innerList:groupAnagrams2(strs)){
			System.out.println(Arrays.asList(innerList.toArray()));
		}
		//System.out.println(test[0]);
		//HashMap<String , Integer> map = new HashMap<String, Integer>();
		//map.put("test", 1);
		//char[]test = "test".toCharArray();
		//System.out.println(map.containsKey(new String(test)));
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {	
		List<List<String>> list = new ArrayList<List<String>>();
		if(strs.length <=0){return list;}
		boolean[] added = new boolean[strs.length];
		int index = 0;
		while(index<strs.length){
			while(index<strs.length && added[index]){index++;}
			if(index==strs.length){break;}
			System.out.println("working on word: "+strs[index]);
			
			List<String> innerList = new ArrayList<String>();
			String str1 = strs[index];
			innerList.add(str1);
			
			int moving = index+1;
			while(moving < strs.length){
				while(moving<strs.length && added[moving]){moving++;}
				if(moving==strs.length){break;}
				System.out.println("comparing word: "+strs[index]+" and "+strs[moving]);
				String str2 = strs[moving];
				if(validAnagram(str1, str2)){
					innerList.add(str2);
					added[moving] = true;
				}
				moving++;
			}
			list.add(innerList);
			index++;		
		}
		return list;
    }
	
	private static boolean validAnagram(String str1, String str2){
		if(str1.length() != str2.length()){return false;}
		int[] checkList = new int[256];
		
		for (char c1:str1.toCharArray()){
			checkList[c1]++;
		}
		
		for(char c2:str2.toCharArray()){
			if(--checkList[c2] <0){return false;}
		}
		
		return true;
	}
	
	//Accepted on 7.28.2016
	public static List<List<String>> groupAnagrams2 (String[] strs) {	
		List<List<String>> list = new ArrayList<List<String>>();
		if(strs.length<=0){return list;}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<strs.length;i++){
			char[] curr = strs[i].toCharArray();
			Arrays.sort(curr);
			if(map.containsKey(new String(curr))){
				list.get(map.get(new String(curr))).add(strs[i]);
			}else{
				list.add(new ArrayList<String>(Arrays.asList(strs[i])));
				map.put(new String(curr), list.size()-1);
			}
		}
		return list;
	}
}
