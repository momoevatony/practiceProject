package course3;

import java.util.Stack;

public class LargestRectangleInHistogram {
	//accepted 5.28.2017 See LintCode notes for description.
	public int largestRectangleArea(int[] height) {
        // write your code here
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i <= height.length; i++) {
            int curr = i == height.length ? 0 : height[i];
            while (!stack.isEmpty() && curr < height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
