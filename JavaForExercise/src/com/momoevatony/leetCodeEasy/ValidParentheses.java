package com.momoevatony.leetCodeEasy;

import java.util.Stack;

public class ValidParentheses {
	
	//Accepted 9.7.2016
	public boolean isValid(String s) {
		if(s.length()==0){return true;}
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length();i++){
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
				stack.push(s.charAt(i));
			}else{
			    if(stack.isEmpty()){return false;}
				if(s.charAt(i)==')'){
					char curr = stack.pop();
					if(curr != '(') {return false;}
				}
				if(s.charAt(i)==']'){
					char curr = stack.pop();
					if(curr != '[') {return false;}
				}
				if(s.charAt(i)=='}'){
					char curr = stack.pop();
					if(curr != '{') {return false;}
				}
			}
		}
		return stack.isEmpty();
    }

}
