package com.momoevatony.leetCodeEasy;

import java.util.Arrays;

public class MoveZeros {
	public static void main(String args[]){
		int[]input = {0,1,0,3,4,5,12,0};
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(moveZeros(input)));
	}
	
	static int[] moveZeros (int[] input){
		int slowerIndex=0;
		int fasterIndex=0;
		while(fasterIndex<input.length){
			if(input[fasterIndex]!=0){
				input[slowerIndex] = input[fasterIndex];
				slowerIndex++;
				fasterIndex++;
			}else{fasterIndex++;}
		}
		while(slowerIndex<input.length){
			input[slowerIndex++]=0;
		}
		return input;
	}

}
