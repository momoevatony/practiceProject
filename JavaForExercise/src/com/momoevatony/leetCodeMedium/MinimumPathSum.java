package com.momoevatony.leetCodeMedium;

import java.util.Arrays;

public class MinimumPathSum {
	
	public static void main (String args[]){
		int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(minPathSum(grid));
	}
	
	public static int minPathSum(int[][] grid) {
        if (grid.length<=0 || grid[0].length<=0){return -1;}
        int[][] minMap = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
        	for(int j=0; j<grid[i].length;j++){
        		if(j == 0 && i==0){minMap[i][j] = grid[i][j];}
        		else if(i==0){minMap[i][j] = minMap[i][j-1]+grid[i][j];}
        		else if(j==0){minMap[i][j] = minMap[i-1][j]+grid[i][j];}
        		else{minMap[i][j] = Math.min(minMap[i-1][j], minMap[i][j-1])+grid[i][j];}
        	}
        }
        
        return minMap[grid.length-1][grid[0].length-1];
    }
	

}
