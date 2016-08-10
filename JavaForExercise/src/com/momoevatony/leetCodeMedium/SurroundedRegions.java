package com.momoevatony.leetCodeMedium;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SurroundedRegions {
	
	public static void main(String args[]){
		char[][] board = {{'X','X','X','X','X'},{'X','O','O','O','X'},{'X','X','O','O','X'},{'X','X','X','O','X'},{'X','O','X','X','X'}};
		for(char[] row:board){
			System.out.println(Arrays.toString(row));
		}
		
		solve(board);
		for(char[] row:board){
			System.out.println(Arrays.toString(row));
		}
	}
	
	
	
	public static void solve(char[][] board) {
        if(board.length<=0){return;}
		boolean[][] map = new boolean[board.length][board[0].length];
		for(int i=0; i<board.length;i++){
			for(int j=0; j<board[0].length;j++){
				if(i==0||j==0||i==board.length-1||j==board[0].length-1||board[i][j]=='X'||map[i][j]){map[i][j]=true;continue;}
				List<Node> backTrackList = new ArrayList<Node>();
				List<Node> pathTrackList = new ArrayList<Node>();
				pathTrackList.add(new Node(i,j));
				int pathTrackIndex = 0;
				boolean surrounded = true;
				while(pathTrackIndex<pathTrackList.size()){
					Node curr = pathTrackList.get(pathTrackIndex);
					if(map[curr.row][curr.col]){pathTrackIndex++;continue;}
					map[curr.row][curr.col] = true;
					//System.out.println("Working on row: "+curr.row+" col: "+curr.col);
					if(curr.row==0||curr.row==board.length-1||curr.col==board[0].length-1||curr.col==0){surrounded=false;break;}
					board[curr.row][curr.col]='X';
					backTrackList.add(new Node(curr.row,curr.col));
					//System.out.println("adding row: "+curr.row+" col: "+curr.col+" to backTrackList");

					if(board[curr.row-1][curr.col]=='O'){if(map[curr.row-1][curr.col]){surrounded=false;break;}pathTrackList.add(new Node(curr.row-1,curr.col));}
					if(board[curr.row][curr.col-1]=='O'){if(map[curr.row][curr.col-1]){surrounded=false;break;}pathTrackList.add(new Node(curr.row,curr.col-1));}
					if(board[curr.row+1][curr.col]=='O'){if(map[curr.row+1][curr.col]){surrounded=false;break;}pathTrackList.add(new Node(curr.row+1,curr.col));}
					if(board[curr.row][curr.col+1]=='O'){if(map[curr.row][curr.col+1]){surrounded=false;break;}pathTrackList.add(new Node(curr.row,curr.col+1));}

					pathTrackIndex++;
				}
				if(!surrounded){
					for (int k=0;k<backTrackList.size();k++){
						board[backTrackList.get(k).row][backTrackList.get(k).col]='O';
					}
				}
			}
		}
    }
	
	public static class Node{
		int row;
		int col;
		public Node(int row, int col){this.row=row; this.col=col;}
	}
	
	//to be completed. 8.10.2016
	public static void solve2(char[][] board){
		boolean[][]map=new boolean[board.length][board[0].length];
		for(int i=0;i<board[0].length;i++){
			map[0][i]=true;
			if(board[0][i]=='O'){
				
			}
		}
	}
	
}
