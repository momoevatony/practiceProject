package com.momoevatony.leetCodeEasy;

public class NumOfPrimeNumbers {
	public static void main(String args[]){
		
	}
	
	static int numOfPrimeNum (int n){
		if (n<0) {return -1;}
		int numOfPrime = 0;
		for (int i=3;i<n;i=i+2){
			if(isPrime (i)){numOfPrime++;}
		}
		return numOfPrime;
	}
	static boolean isPrime(int n){
		
		return true;
	}

}
