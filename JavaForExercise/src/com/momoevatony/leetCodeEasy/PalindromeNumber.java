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
	
	//Accepted 9.6.2016
	public static boolean isPalindrome(int x){
		if(x<0 || (x!=0 && x%10==0)){return false;}
		int rev = 0;
		while(x>rev){
			rev = rev*10+x%10;
			x=x/10;
		}
		return (x==rev || x==rev/10);
	}

}
