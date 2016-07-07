package com.momoevatony.leetCodeEasy;

public class PalindromeNumber {
	public static void main(String args[]){
		int x = 123454321;
		int firstDigit = x;
		int digit = 1;
		while (firstDigit >= 10){
			digit++;
			firstDigit = firstDigit/10;
		}
		//System.out.println(Integer.toString( (x-firstDigit*(int)Math.pow(10,digit-1)-x%10)/10) ) ;
		//System.out.println(Integer.toString(digit) + " "+ Integer.toString(firstDigit));
		System.out.println(isPalindrome(x));
	}
	
	public static boolean isPalindrome(int x){
		System.out.println(x);
		if (x/10 ==0){return true;}
		int firstDigit = x;
		int digit = 1;
		while (firstDigit >= 10){
			digit++;
			firstDigit = firstDigit/10;
		}
		
		return (firstDigit == x%10 && isPalindrome((x-firstDigit*(int)Math.pow(10,digit-1)-x%10)/10));
		
	}

}
