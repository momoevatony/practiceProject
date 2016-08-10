package com.momoevatony.leetCodeMedium;

public class SurroundedRegions {
	public void solve(char[][] board) {
        for(int i=0; i<board.length;i++){
        	for(int j=0; j<board[0].length;j++){
        		if(board[i][j]=='O'){
        			if(i==0 || j==0 || i==board.length-1 || j==board[0].length-1){continue;}
        			if(board[i-1][j] == 'O' || board[i][j-1] == 'O'){continue;}
        			if(board[i+1][j] == 'O'){
        				if(surrounded(board, i,j)){board[i][j]='X';}
        			}
        		}
        	}
        }
    }
	
	public boolean surrounded (char[][] board, int row, int col){
		if(row ==0 || col == 0|| row == board.length-1 || col == board[0].length-1) {return false;}
		if(board[row+1][col] == 'X' && board[row][col+1] =='X') {return true;}
		if(board[row+1][col] == 'O'){
			board[row][col] = 'X';
			if(surrounded(board, row+1,col)){return true;}
			else{board[row][col]='O'; return false;}
		}
		
		if(board[row][col+1] =='O'){
			board[row][col] = 'X';
			if(surrounded(board, row,col+1)){return true;}
			else{board[row][col]='O'; return false;}
		}
		return true;
	}
}
