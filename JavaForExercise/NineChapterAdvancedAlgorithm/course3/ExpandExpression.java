package course3;

import java.util.Stack;

public class ExpandExpression {
	
	//accepted 5.28.2017 7663ms
	public String expressionExpand(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return s;
        }
        
        int time = 0;
        Stack<Object> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <='9') {
                time = time * 10 + (ch - '0');
            } else if (ch == '[') {
                stack.push(time);
                time = 0;
            } else if (ch == ']') {
                //do something here
                expand(stack);
            } else {
                stack.push(Character.toString(ch));
            }
        }
        
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
    
    private void expand(Stack<Object> stack) {
        Stack<String> stack2 = new Stack<String>();
        while (!stack.isEmpty()) {
            
            Object obj = stack.pop();
            
            if (obj instanceof Integer) {
                StringBuilder sb = new StringBuilder();
                while (!stack2.isEmpty()) {
                    sb.append(stack2.pop());
                }
                for (int i = 0; i < (int)obj; i++) {
                    stack.push(sb.toString());
                }
                return;
            } else {
                stack2.push((String)obj);
            }
        }
    }
}
