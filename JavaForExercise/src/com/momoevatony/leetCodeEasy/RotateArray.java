package com.momoevatony.leetCodeEasy;

import java.util.Arrays;

public class RotateArray {
	public static void main(String args[]){
		int[]input = {1,2,3,4,5,6,7};
		
		System.out.println(Arrays.toString(rotateArray(input, 3)));
	}
	
	static int[] rotateArray(int[] input, int k){
		int[] output = new int[input.length];
		for (int i=0;i<input.length;i++){
			output[i]=input[(k+1)%input.length];
			k++;
		}
		return output;
	}

}
