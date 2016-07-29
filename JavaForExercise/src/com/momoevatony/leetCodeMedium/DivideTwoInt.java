package com.momoevatony.leetCodeMedium;

public class DivideTwoInt {
	public static void main(String args[]){
		int dividend = -2147483648;
		int divisor = -1;
		int result = dividend/divisor;
		System.out.println(result);
		System.out.println(divide(dividend,divisor));
	}
	
	//Accepted 7.28.2016
	public static int divide(int dividend, int divisor) {
		long dividend_long = dividend;
		long divisor_long = divisor;
		
		boolean dividend_neg = false;
		boolean divisor_neg = false;
		if(divisor<0){
			divisor_neg = true;
			divisor_long = -divisor_long;
		}
		if(dividend<0){
			dividend_neg = true;
			dividend_long = -dividend_long;
		}
		
		long result = divideDP(dividend_long, divisor_long, divisor_long, 0, 1);
		
		result = dividend_neg ^ divisor_neg? -result:result;
		
		if(result>Integer.MAX_VALUE){return Integer.MAX_VALUE;}
		if(result<Integer.MIN_VALUE){return Integer.MIN_VALUE;}
		else{return (int)result;}
    } 
	
	
	//TODO 7.27.2016
	private static long divideDP(long dividend, long divisor, long currDivisor, long currResult, int level){
		if(divisor ==1){return dividend;}
		System.out.println(dividend+" "+divisor+" "+currDivisor+" "+currResult+" "+level);
		if(dividend<divisor){return currResult;}
		while(currDivisor > dividend){currDivisor=currDivisor/2;level=level/2;}
		
		return divideDP(dividend-currDivisor, divisor, currDivisor*2, currResult+level, level*2);
	}
}
