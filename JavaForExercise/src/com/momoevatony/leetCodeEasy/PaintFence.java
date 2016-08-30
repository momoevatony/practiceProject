package com.momoevatony.leetCodeEasy;

public class PaintFence {
	
	//Accepted 8.29.2016
	public int numWays(int n, int k){
		if(n<=1 || k<=0){return n*k;}
		if(k==1){return n>2?0:1;}
		
		int[]ways = new int[n];
		ways[0] = k;
		ways[1] = k*k;
		for(int i=2; i<n;i++){
			ways[i] = (k-1)*ways[i-1] + (k-1)*ways[i-2];
		}
		
		return ways[n-1];
	}

}
