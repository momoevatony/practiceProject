package course2;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
	
	//Accepted 12.6.2016 3400ms
	public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
		ArrayList<String> list = new ArrayList<String>();
		if(words.size()==0 || board==null || board.length ==0 || board[0].length==0 ){return list;}
		Trie trie = new Trie();
		for(String word:words){
			trie.add(word);
		}
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				search(list,"",board,i,j,trie);
			}
		}
		
		return list;
    }
	
	private void search(ArrayList<String> list, String curr, char[][]board, int row, int col, Trie trie){
		if(row<0||row>=board.length||col<0||col>=board[0].length){return;}
		curr = curr+Character.toString(board[row][col]);
		if(!trie.prefixSearch(curr)){return;}
		if(trie.search(curr)){
			if(!list.contains(curr)){list.add(curr);}
		}
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		for(int i=0;i<dx.length;i++){
			board[row][col]^=256;
			search(list, curr,board,row+dx[i],col+dy[i],trie);
			board[row][col]^=256;
		}
	}
	
	private class TrieNode{
		char ch;
		TrieNode[] children;
		boolean end;
		
		public TrieNode(char ch){
			this.ch = ch;
			children = new TrieNode[26];
			end = false;
		}
	}
	
	private class Trie{
		TrieNode root;
		
		public Trie(){
			root = new TrieNode(' ');
		}
		
		public void add(String word){
			TrieNode curr = root;
			char[] letters = word.toCharArray();
			for(char ch:letters){
				int index = ch-'a';
				if(curr.children[index] == null){curr.children[index] = new TrieNode(ch);}
				curr = curr.children[index];
			}
			curr.end = true;
		}
		
		public boolean prefixSearch(String word){
			TrieNode curr = root;
			char[] letters = word.toCharArray();
			for(char ch:letters){
				if(ch<'a' || ch>'z'){return false;}
				int index = ch-'a';
				if(curr.children[index] == null) {return false;}
				curr = curr.children[index];
			}
			return true;
		}
		
		public boolean search (String word){
			TrieNode curr = root;
			char[] letters = word.toCharArray();
			for(char ch:letters){
				if(ch<'a' || ch>'z'){return false;}
				int index = ch-'a';
				if(curr.children[index] == null) {return false;}
				curr = curr.children[index];
			}
			return curr.end;
		}
	}
}
