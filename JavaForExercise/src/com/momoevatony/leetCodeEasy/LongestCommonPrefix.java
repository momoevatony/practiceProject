package com.momoevatony.leetCodeEasy;

public class LongestCommonPrefix {
	
	//Accepted 9.6.2016
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0){return "";}
		if(strs.length==1){return strs[0];}
		String result = strs[0];
		while(result.length()>0){
			boolean found = true;
			for(int i=1; i<strs.length;i++){
				if(strs[i].length()<result.length() || !strs[i].substring(0,result.length()).equals(result) ){
					if(result.length()==1){return "";}
					result=result.substring(0,result.length()-1);
					found=false;
					break;
				}
			}
			if(found){return result;}
		}
		
		return "";
    }

}
