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
	
	//Accepted on 7.26.2016
    public static List<String> generateParenthesis(int n) {
    	List<String> list = new ArrayList<String>();
        if(n==1){return Arrays.asList("()");}
        String curr = "";
        generateByOne(curr, n, n, list);
        return list; 
    }
    
    static void generateByOne(String curr, int left, int right, List<String> list){
    	if(left == 0 && right == 0){list.add(curr);}
    	
    	if(left > 0) {generateByOne(curr+"(", left-1, right, list);}
    	if(left < right) {generateByOne(curr+")", left, right-1, list);}

    }
}
