package com.momoevatony.chapter10;

import java.util.Arrays;

public class chapter10_1_SortedMerge {
	public static void main(String args[]){
		int[]arrayA = new int[8];
		int[]arrayB = new int[4];
		for (int i=0;i<4;i++){
			arrayA[i]=2*i+1;
			arrayB[i]=2*(i+1);
		}
		System.out.println(Arrays.toString(arrayA));
		System.out.println(Arrays.toString(arrayB));
		System.out.println(Arrays.toString(sortedMerge(arrayA, arrayB)));
	}
	
	public static int[] sortedMerge (int[] arrayA, int[] arrayB){
		int indexA = arrayA.length - arrayB.length -1;
		int indexB = arrayB.length-1;
		for (int i=arrayA.length-1;i>0;i--){
			if(arrayA[indexA]>arrayB[indexB]){
				arrayA[i] = arrayA[indexA];
				indexA--;
			}else{
				arrayA[i] = arrayB[indexB];
				indexB--;
			}
		}
		return arrayA;
	}

}
