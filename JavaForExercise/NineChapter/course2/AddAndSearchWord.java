package course2;

public class AddAndSearchWord {
	
	
	//Accepted 12.6.2016 3281ms
	TrieNode initial = new TrieNode(' ');
	
	public void addWord(String word) {
        // Write your code here
		TrieNode root = initial;
		char[] letters = word.toCharArray();
		for(char ch:letters){
			int index = ch-'a';
			if(root.children[index] == null) {root.children[index] = new TrieNode(ch);}
			root = root.children[index];
		}
		root.end=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
    	return search(word, initial);
    }
    
    private boolean search (String word, TrieNode root){
    	System.out.println(word);
    	System.out.println(root.ch);
    	int wordIndex = 0;
    	while(wordIndex<word.length()){
    		char ch = word.charAt(wordIndex);
    		if(ch == '.'){
    			boolean flag = false;
    			for(TrieNode node: root.children){
    				if(node==null){continue;}
    				flag = flag||search(word.substring(wordIndex+1), node);
    			}
				return flag;
    		}else{
    			int index = ch-'a';
    			if(root.children[index] == null){return false;}
    			root = root.children[index];
    			wordIndex++;
    		}
    	}
    	return root.end;
    }
    
    private class TrieNode{
    	boolean end;
    	char ch;
    	TrieNode[] children;
    	public TrieNode(char ch){
    		this.ch = ch;
    		children = new TrieNode[26];
    		end = false;
    	}
    	
    }
}
