package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {
	
	//Accepted 10.31.2016
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> list = new ArrayList<String>();
		if(s.length()<10){return list;}
		Set<String> set = new HashSet<String>();
		for(int i=0; i<=s.length()-10;i++){
			String curr = s.substring(i,i+10);
			if(set.contains(curr)){
				list.add(curr);
			}else{
				set.add(curr);
			}
		}
		
        return list;
    }
}
