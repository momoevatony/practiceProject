package course3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	
	//accepted 5.23.2017 7915ms
	public boolean isValidParentheses(String s) {
        // Write your code here
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		
		Stack<Character> stack = new Stack<>();
		
		for (char ch : s.toCharArray()) {
			if (map.containsKey(ch)) {
				stack.push(ch);
			} else {
				if (stack.isEmpty() || ch != map.get(stack.pop())) {
					return false;
				}
			}
		}
		
		return stack.isEmpty(); 
    }
}
