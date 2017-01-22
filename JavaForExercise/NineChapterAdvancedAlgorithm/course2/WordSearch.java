package course2;

import java.util.HashMap;
import java.util.Map;

public class WordSearch {
	
	//Accepted 12.6.2016 3474ms
	public boolean exist(char[][] board, String word) {
        // write your code here
		Trie trie = new Trie();
		trie.add(word);
		for (int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(existDy("",board,i,j,trie)){
					return true;
				}
			}
		}
		return false;
    }
	
	private boolean existDy(String curr, char[][]board, int row, int col, Trie trie){
		if(row<0 || row>=board.length || col<0 || col>=board[0].length){return false;}
		curr = curr+Character.toString(board[row][col]);
		if(trie.search(curr)){return true;}
		if(!trie.prefixSearch(curr)){return false;}

		int [] dx = {-1,0,1,0};
		int [] dy = {0,-1,0,1};
		
		for(int i=0;i<dx.length;i++){
		    board[row][col] ^= 256;
			if(existDy(curr,board,row+dx[i],col+dy[i],trie)){return true;}
			board[row][col] ^= 256;
		}
		
		return false;
	}
	
	private class Trie{
		private TrieNode root;
		
		public Trie(){
			root = new TrieNode(' ');
		}
		
		public void add (String word){
			TrieNode curr = root;
			char[] letters = word.toCharArray();
			for(char ch:letters){
				if(!curr.childrenMap.containsKey(ch)){curr.childrenMap.put(ch, new TrieNode(ch));}
				curr = curr.childrenMap.get(ch);
			}
			curr.end = true;
		}
		
		public boolean prefixSearch(String word){
			TrieNode curr = root;
			char[] letters = word.toCharArray();
			for(char ch: letters){
			    if(ch<'A' || ch>'z'){return false;}
				int index = ch-'A';
				if(!curr.childrenMap.containsKey(ch)){return false;}
				curr = curr.childrenMap.get(ch);
			}
			return true;
		}
		public boolean search (String word){
			TrieNode curr = root;
			char[] letters = word.toCharArray();
			for(char ch: letters){
			    if(ch<'A' || ch>'z'){return false;}
				int index = ch-'A';
				if(!curr.childrenMap.containsKey(ch)){return false;}
				curr = curr.childrenMap.get(ch);
			}
			return curr.end;
		}
		
	}
	private class TrieNode{
		char ch;
		Map<Character, TrieNode> childrenMap = new HashMap<Character, TrieNode>();
		boolean end;
		public TrieNode(char ch){
			this.ch=ch;
			Map<Character, TrieNode> childrenMap = new HashMap<Character, TrieNode>();
			end = false;
		}
	}
	
}
