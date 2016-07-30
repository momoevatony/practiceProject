package com.momoevatony.leetCodeMedium;

import java.util.Stack;

public class UniquePaths {
	public int uniquePaths2(int m, int n) {
		Stack<Node> stack = new Stack<Node>();
		Node curr = new Node(0,0);
		stack.push(curr);
		int ways = 0;
		while(!stack.isEmpty()){
			curr = stack.pop();
			if((curr.row == m-1) && curr.col == n-1){ways++;}
			if(curr.col<n-1){stack.push(new Node(curr.row, curr.col+1));}
			if(curr.row<m-1){stack.push(new Node(curr.row+1, curr.col));}
		}
		return ways;
    }

	private class Node{
		int row;
		int col;
		Node(int row, int col){this.row = row; this.col=col;}
	}
	
	public int uniquePaths(int m, int n) {
		if(m<=0 || n<=0){return 0;}
		if(m==1 || n==1){return 1;}
		int[][] resultMap = new int[m][n];
		for(int i=m-1;i>=0;i--){
			for(int j=n-1;j>=0;j--){
				if(i==m-1 || j==n-1){resultMap[i][j]=1;}
				else{resultMap[i][j] = resultMap[i+1][j]+resultMap[i][j+1];}
			}
		}
		return resultMap[0][0];
    }
}
