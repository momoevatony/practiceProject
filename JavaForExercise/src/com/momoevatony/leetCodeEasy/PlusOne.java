package com.momoevatony.leetCodeEasy;

import java.util.Arrays;

public class PlusOne {
	public static void main (String args[]){
		int[] array = {9,9,9,9,9};
		System.out.println(Arrays.toString(plusOne(array)));
		
	}
	
	static int[] plusOne (int[] array){
		int carry = 1;
		for (int i=array.length-1;i>0;i--){
			if (array[i] ==9 && carry == 1){array[i]=0; carry=1;}
			else if (carry ==1) {array[i]++;carry =0;}
		}
		if(carry == 1){int[] res = new int[array.length+1]; res[0]=1; return res;} 
		
		return array;
	}

}
