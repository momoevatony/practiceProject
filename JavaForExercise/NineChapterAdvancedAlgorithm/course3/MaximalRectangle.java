package course3;

import java.util.Stack;

public class MaximalRectangle {
	
	//accepted 5.29.2017
	public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int [][] height = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row == 0) {
                    height[0][col] = matrix[row][col] ? 1 : 0;
                    continue;
                }
                if (matrix[row][col]) {
                    height[row][col] = height[row - 1][col] + 1;
                } else {
                    height[row][col] = 0;
                }
            }
        }
        
        for (int row = 0; row < height.length; row++) {
            max = Math.max(max, largestRec(height[row]));
        }
        
        return max;
    }
    
    private int largestRec (int[] height) {
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
