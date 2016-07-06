package com.momoevatony.sortAlgorithm;

import java.util.*;

public class MergeSort {
	
	public static void main (String args[]){
		int[] array = {32, 14, 97, 55, 75, 1, 58, 2, 73, 76, 36, 57, 26, 71, 33, 51, 56, 27, 35, 81, 9};
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	static void mergeSort(int[] array){
		
		if (array.length>1){
		
		
			int [] leftPart = new int [array.length / 2 ];
			int [] rightPart = new int[array.length-leftPart.length];
			
			System.arraycopy(array, 0, leftPart, 0, leftPart.length);
			System.arraycopy(array, leftPart.length, rightPart, 0, rightPart.length);
			
			mergeSort (leftPart);
			mergeSort (rightPart);
			merge (leftPart, rightPart, array);
		}
	}
	
	static void merge (int[] leftPart, int[] rightPart, int[] array){
		int leftIndex = 0;
		int rightIndex = 0;
		int arrayIndex = 0;
		
		while (leftIndex < leftPart.length && rightIndex < rightPart.length){
			if(leftPart[leftIndex] < rightPart[rightIndex]){
				array[arrayIndex] = leftPart[leftIndex];
				leftIndex++;
			}
			else{
				array[arrayIndex] = rightPart[rightIndex];
				rightIndex++;
			}
			arrayIndex++;
		}
		System.arraycopy(leftPart, leftIndex, array, arrayIndex, leftPart.length-leftIndex);
		System.arraycopy(rightPart, rightIndex, array, arrayIndex, rightPart.length-rightIndex);
		
	}
	
}
