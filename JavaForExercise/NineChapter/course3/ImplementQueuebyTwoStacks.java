package course3;

import java.util.Stack;

public class ImplementQueuebyTwoStacks {
	
	//Accepted 12.16.2016 1904ms
	private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueuebyTwoStacks() {
       // do initialization if necessary
    	stack1 = new Stack<Integer>();
    	stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
    	while(!stack2.isEmpty()){
    		stack1.push(stack2.pop());
    	}
    	stack2.push(element);
    	while(!stack1.isEmpty()){
    		stack2.push(stack1.pop());
    	}
    }

    public int pop() {
        // write your code here
    	return stack2.pop();
    }

    public int top() {
        // write your code here
    	return stack2.peek();
    }
}
