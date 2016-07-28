package com.momoevatony.leetCodeMedium;

public class DivideTwoInt {
	public static void main(String args[]){
		int dividend = 2147483646;
		int divisor = 1;
		int result = dividend/divisor;
		System.out.println(result);
		System.out.println(divide(dividend,divisor));
	}
	public static int divide(int dividend, int divisor) {
		long dividendLong = dividend;
		long divisorLong = divisor;
		boolean dividendPos=true, divisorPos=true;
		if(dividend<0){dividendPos = false; dividendLong = -dividendLong;}
		if(divisor<0){dividendPos = false; divisorLong = -divisorLong;}
		int result = divideDP(dividendLong, divisorLong, divisorLong, 0)>Integer.MAX_VALUE? Integer.MAX_VALUE: (int)divideDP(dividendLong, divisorLong, divisorLong, 0);
		return dividendPos^divisorPos?result:-result;
    } 
	
	
	//TODO 7.27.2016
	private static long divideDP(long dividend, long divisor, long currDivisor, long currResult){
		if(dividend<divisor){return 0;}
		return (divideDP(dividend-divisor, divisor, currDivisor, currResult)+1);
	}
}
