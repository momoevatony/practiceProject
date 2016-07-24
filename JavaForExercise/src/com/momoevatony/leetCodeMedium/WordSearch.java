package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class WordSearch {
	
	public static void main(String args[]){
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "SEE";
		for(int row=0; row<board.length; row++){
			System.out.println(Arrays.toString(board[row]));
		}

		System.out.println(exist(board,word));
	}
	
	
	//Accepted on 7.24.2016
	public static boolean exist(char[][] board, String word) {
		if(word.length()==0 || word==null){return true;}
		
		for(int row=0; row<board.length;row++){
			for(int col=0; col<board[0].length;col++){
				if(exist(board, row, col, word, 0)){
					return true;
				}
			}
		}
		
		return false;
    }
	
	private static boolean exist(char[][] board, int row, int col, String word, int index){
		if(index == word.length()){return true;}
		if(row<0 || row==board.length || col<0 || col==board[0].length) {return false;}
		if(board[row][col]!=word.charAt(index)){return false;}

		//System.out.println("looking at row: "+row+" col: "+col+" and char: "+word.charAt(index));
		board[row][col] ^=256; //make it to '#' to mark it as visited.
		boolean next = (exist(board, row-1, col, word, index+1) || exist(board, row, col-1, word, index+1) || exist(board, row+1, col, word, index+1) || exist(board, row, col+1, word, index+1));
		board[row][col] ^=256; //path not found, then convert it back.
		return next;
	}
	
}
