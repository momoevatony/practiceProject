package course4;

import java.util.ArrayList;
import java.util.List;

public class FindPeakElement2 {
	
	//Accepted 5.29.2017 Can be optimized for doing row search and column search alternatively.
	public List<Integer> findPeakII(int[][] A) {
        // write your code here
        return binarySearch(A, 0, A.length - 1);
    }
    
    private List<Integer> binarySearch(int[][] A, int start, int end) {
        int mid = (start + end) / 2;
        int maxPos = arrayMaxPos(A[mid]);
        if (isPeak(A, mid, maxPos)) {
            List<Integer> list = new ArrayList<>();
            list.add(mid);
            list.add(maxPos);
            return list;
        } else if (A[mid - 1][maxPos] > A[mid][maxPos]) {
            return binarySearch(A, start, mid);
        } else {
            return binarySearch(A, mid, end);
        }
    }
    
    private int arrayMaxPos(int[] nums) {
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPos = nums[i] > nums[maxPos] ? i : maxPos;
        }
        return maxPos;
    }
    
    private boolean isPeak(int[][] A, int row, int col) {
        int curr = A[row][col];
        if (row > 0 && A[row - 1][col] > curr) {
            return false;
        }
        if (row < A.length - 1 && A[row + 1][col] > curr) {
            return false;
        }
        if (col > 0 && A[row][col - 1] > curr) {
            return false;
        }
        if (col < A[0].length - 1 && A[row][col + 1] > curr) {
            return false;
        }
        
        return true;
    }
}
