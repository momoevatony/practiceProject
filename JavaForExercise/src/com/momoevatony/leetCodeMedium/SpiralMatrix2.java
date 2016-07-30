package com.momoevatony.leetCodeMedium;

import java.util.Arrays;

public class SpiralMatrix2 {
	
	public static void main (String args[]){
		int n = 4;
		for (int[] array: generateMatrix(n)){
			System.out.println(Arrays.toString(array));
		}
	}
	
	//Accepted 7.29.2016
	public static int[][] generateMatrix(int n) {
        if(n==0){return new int[0][0];}
        int[][] result = new int[n][n];
        int top = 0; int bottom = n-1;
        int left = 0; int right = n-1;
        int curr = 0;
        while(curr<n*n){
        	for(int i=left;i<=right && curr<=n*n;i++){
        		result[top][i]=++curr;
        	}
        	top++;
        	for(int i=top; i<=bottom && curr<=n*n; i++){
        		result[i][right] = ++curr;
        	}
        	right--;
        	for(int i=right; i>=left && curr<=n*n; i--){
        		result[bottom][i] = ++curr;
        	}
        	bottom--;
        	for(int i=bottom; i>=top && curr<=n*n; i--){
        		result[i][left]= ++curr;
        	}
        	left++;
        }
        return result;
    }
}
