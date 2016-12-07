package com.momoevatony.dataStructure;

public class Trie {
	private final int MAX_SIZE = 26;
	
	private class TrieNode{
		int num;
		char ch;
		boolean end;
		
		TrieNode [] child;
		
		public TrieNode(){
			this.num = 1;
			this.child = new TrieNode[MAX_SIZE];
			this.end = false;
		}
	}
	
	public void insert(TrieNode node, String str){
		if(str.length()==0 || str == null){return;}
		
		char[] letters = str.toCharArray();
		for (int i=0;i<letters.length;i++){
			node.ch=letters[i];
			int position = letters[i]-'a';
			if(node.child[position] == null){
				node.child[position] = new TrieNode();
			}else{
				node.child[position].num++;
			}
			node = node.child[position];
			if(i==letters.length-1){node.end=true;}
		}
	}
	
	public int findCount(TrieNode node, String str){
		if(str.length()==0 || str == null){return 0;}
		
		char [] letters = str.toCharArray();
		for(char ch : letters){
			int position = ch-'a';
			if(node.child[position] == null){
				return 0;
			}else{
				node = node.child[position];
			}
		}
		return node.num;
	}
}
