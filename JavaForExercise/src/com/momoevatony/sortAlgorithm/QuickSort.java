package com.momoevatony.sortAlgorithm;

import java.util.Arrays;

public class QuickSort {
	
	public static void main (String args[]){
		int[] array = {32, 14, 97, 55, 75, 1, 58, 2, 73, 76, 36, 57, 26, 71, 33, 51, 56, 27, 35, 81, 9};
		quickSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	static void quickSort (int[] array){
		quickSort(array, 0, array.length-1);
	}
	
	static void quickSort (int[] array, int start, int end){
		if (start < end){
			
			int i = start;
			int j = end;
			
			while (i<j){
				int pivot = array[start];
				System.out.println(Arrays.toString(array));
				while (array[i]<=pivot && i<=end && i<j){
					i++;
				}
				while (array[j]>pivot && j>=start && j>=i){
					j--;
				}
				if(i<j){
					swap(array, i, j);
				}
			}
			
			swap (array, start, j);
			quickSort(array, start, j-1);
			quickSort(array, j+1, end);
		}
	}
	static void swap(int array[], int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	

}

