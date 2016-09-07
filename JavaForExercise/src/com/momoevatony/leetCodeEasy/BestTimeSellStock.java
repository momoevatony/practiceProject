package com.momoevatony.leetCodeEasy;

public class BestTimeSellStock {
	
	//Accepted 8.31.2016
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int diff = 0;
		
		for(int n:prices){
			min = n<min?n:min;
			diff = (n-min)<diff? diff:(n-min);
		}
		
		return diff;
    }

}
