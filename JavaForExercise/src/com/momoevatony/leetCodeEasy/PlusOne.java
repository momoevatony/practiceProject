package com.momoevatony.leetCodeEasy;

import java.util.Arrays;

public class PlusOne {
	public static void main (String args[]){
		int[] array = {9,9,9,9,9};
		System.out.println(Arrays.toString(plusOne(array)));
		
	}
	//Accepted 9.7.2016
	static int[] plusOne (int[] digits){
		int carry = 1;
		for (int i=digits.length-1;i>=0;i--){
			if (digits[i] ==9 && carry == 1){digits[i]=0; carry=1;}
			else if (carry ==1) {digits[i]++;carry =0;}
		}
		if(carry == 1){int[] res = new int[digits.length+1]; res[0]=1; return res;} 
		
		return digits;
	}

}
