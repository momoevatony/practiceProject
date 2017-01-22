package course3;

import java.util.Stack;

public class MinStack {
	
	
	//Makes no sense to me by accepted 12.16.2016 2384ms
	private Stack<Integer> stack;
	private Stack<Integer> min;
	
	public MinStack() {
        // do initialize if necessary
		stack = new Stack<Integer>();
		min = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
    	stack.push(number);
    	if(min.isEmpty()){
    		min.push(number);
    	}else if(min.peek()>=number){
    		min.push(number);
    	}
    }

    public int pop() {
        // write your code here
    	if(min.peek().equals(stack.peek())){
    		min.pop();
    	}
    	return stack.pop();
    }

    public int min() {
        // write your code here
    	return min.peek();
    }
}
