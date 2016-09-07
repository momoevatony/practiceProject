package com.momoevatony.leetCodeEasy;

public class ReverseInteger {
	
	//Accepted 9.6.2016
	public int reverse(int x) {
		boolean neg = false;
		if(x<0){neg=true; x=-x;}
		int result = 0;
		while(x>0){
			if(result> (Integer.MAX_VALUE/10) ){return 0;}
			result = result*10+x%10;
			x/=10;
		}
		
		return neg?-result:result;
    }
}
