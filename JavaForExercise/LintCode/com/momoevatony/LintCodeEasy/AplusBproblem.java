package com.momoevatony.LintCodeEasy;

public class AplusBproblem {
	public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
		int ans = 0;
		boolean flag = false;
		for(int i=0; i<32;i++){
			boolean aflag = (1<<i & a)!=0;
			boolean bflag = (1<<i & b)!=0;
			
			if(aflag && bflag){
				if(flag){
					ans+=Math.pow(2, i);
				}
				flag = true;
			}else if(aflag ^ bflag){
				if(!flag){
					ans+=Math.pow(2, i);
				}
			}else{
				if(flag){
					ans+=Math.pow(2, i);
				}
				flag = false;
			}
		}
        return ans;
    }
}
