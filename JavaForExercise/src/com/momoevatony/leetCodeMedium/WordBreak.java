package com.momoevatony.leetCodeMedium;

import java.util.Set;

public class WordBreak {
	
	
	
	public boolean wordBreak(String s, Set<String> wordDict) {
		if(wordDict.contains(s)){return true;}
		int index = 1;
		while(index<=s.length()){
			if(wordDict.contains(s.substring(0,index))){
				if(wordBreak(s.substring(index,s.length()),wordDict)){
				    return true;
				}
			}
			index++;
		}
		return false;
    }
}
