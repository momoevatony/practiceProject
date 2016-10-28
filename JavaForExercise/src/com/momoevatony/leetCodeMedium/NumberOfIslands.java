package com.momoevatony.leetCodeMedium;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfIslands {
	
	
	//Accepted 10.26.2016. 20ms, can be improved.
	public int numIslands(char[][] grid) {
		if(grid.length<=0 || grid[0].length<=0){
			return 0;
		}
		boolean[][] map = new boolean[grid.length][grid[0].length];
		int numOfIslands = 0;
		for(int i=0; i<=grid.length-1; i++){
			for (int j=0; j<=grid[0].length-1; j++){
				if(map[i][j] == false && grid[i][j] != '0'){
				    map[i][j] = true;
					grid[i][j]='0';numOfIslands++;
					Stack <Node> stack = new Stack<Node>();
					stack.push(new Node(i,j));
					while(!stack.isEmpty()){
						Node curr = stack.pop();
						System.out.println("Working on node row: "+curr.row+" col: "+curr.col);
						if(curr.row-1>=0 && grid[curr.row-1][curr.col]=='1'){
							grid[curr.row-1][curr.col] ='0';
							map[curr.row-1][curr.col] =true;
							stack.push(new Node(curr.row-1, curr.col));
						}
						if(curr.col-1>=0 && grid[curr.row][curr.col-1]=='1'){
							grid[curr.row][curr.col-1] ='0';
							map[curr.row][curr.col-1] =true;
							stack.push(new Node(curr.row, curr.col-1));
						}
						if(curr.row+1<=grid.length-1 && grid[curr.row+1][curr.col]=='1'){
							grid[curr.row+1][curr.col] ='0';
							map[curr.row+1][curr.col] =true;
							stack.push(new Node(curr.row+1, curr.col));
						}
						if(curr.col+1<=grid[0].length-1 && grid[curr.row][curr.col+1]=='1'){
							grid[curr.row][curr.col+1] ='0';
							map[curr.row][curr.col+1] =true;
							stack.push(new Node(curr.row, curr.col+1));
						}
					}
				}
			}
		}
		for (int k=0;k<=grid.length-1;k++){
		    System.out.println(Arrays.toString(grid[k]));
		}
		
		return numOfIslands;
    }
	class Node{
		int row;
		int col;
		public Node (int row, int col){
			this.row = row;
			this.col = col;
		}
	}
}
