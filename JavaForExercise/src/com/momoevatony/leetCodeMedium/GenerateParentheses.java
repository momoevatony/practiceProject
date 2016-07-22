package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
	
	public static void main(String args[]){
		List<String> list = generateParenthesis(4);
		for(String str: list){
			System.out.println(str);
		}
	}
    public static List<String> generateParenthesis(int n) {
        if(n==1){return Arrays.asList("()");}
        return addOneToList(generateParenthesis(n-1));
    }
    
    static List<String> addOneToList(List<String> list){
    	List <String> newList = new ArrayList<String>();
    	String newStr = "";
    	for (String str: list){
    		newStr = str+"()";
    		if(!newList.contains(newStr)){newList.add(newStr);}
    		newStr = "()"+str;
    		if(!newList.contains(newStr)){newList.add(newStr);}
    		newStr = "("+str+")";
    		if(!newList.contains(newStr)){newList.add(newStr);}
    	}
    	return newList;
    }
}
