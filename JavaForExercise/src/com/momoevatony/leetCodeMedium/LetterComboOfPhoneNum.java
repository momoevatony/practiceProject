package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterComboOfPhoneNum {
	public static void main(String args[]){
		String digits = "22";
		List<String> list = letterCombinations(digits);
		for(String str:list){
			System.out.println(str);
		}
	}
	
	//Accepted 7.27.2016
	public static List<String> letterCombinations(String digits) {
		if (digits.length()<=0) {return new ArrayList<String>();}
		HashMap <String , List<String>> map = new HashMap<String, List<String>>();
		map.put("2", new ArrayList<String>(Arrays.asList("a","b","c")));
		map.put("3", new ArrayList<String>(Arrays.asList("d","e","f")));
		map.put("4", new ArrayList<String>(Arrays.asList("g","h","i")));
		map.put("5", new ArrayList<String>(Arrays.asList("j","k","l")));
		map.put("6", new ArrayList<String>(Arrays.asList("m","n","o")));
		map.put("7", new ArrayList<String>(Arrays.asList("p","q","r","s")));
		map.put("8", new ArrayList<String>(Arrays.asList("t","u","v")));
		map.put("9", new ArrayList<String>(Arrays.asList("w","x","y","z")));
		List<String> list = new ArrayList<String>();
		
		return letterComboDP(digits, 0, list, map);
    }
	
	private static List<String> letterComboDP(String digits, int index, List<String> list, HashMap <String , List<String>> map){
		System.out.println("Index now is: "+index);
		
		if (index ==digits.length()){return list;}
		else if (index == 0){
			list = map.get(Character.toString(digits.charAt(index)));
			System.out.println("new list with length : "+list.size()+" formed");
			return letterComboDP(digits, index+1, list, map);
		}else{
			List<String> list2 = map.get(Character.toString(digits.charAt(index)));
			List<String> newList = new ArrayList<String>();
			for(String str2: list2){
				for(String str: list){
					newList.add(str.concat(str2));
					System.out.println("adding: " + str.concat(str2));
				}
			}
			list = newList;
			return letterComboDP(digits, index+1, list, map);
		}
	}

}
