package com.momoevatony.leetCodeEasy;

public class ClimbingStairs {
	public static void main (String args[]){
		System.out.println(climbStairs(5));
		System.out.println(climbStairs2(5));
	}
	
	static int climbStairs(int n){
		if (n==0 || n==1) {return 1;}
		
		return climbStairs(n-1)+climbStairs(n-2);
	}
	static int climbStairs2(int n) {
        if(n==0||n==1||n==2)
            return n;
        int [] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        
        for(int i = 3; i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
