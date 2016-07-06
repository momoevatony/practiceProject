package com.momoevatony.sortAlgorithm;

public class SimpleSort {
	public static int[] array = {32, 14, 97, 55, 75, 1, 58, 2, 73, 76, 36, 57, 26, 71, 33, 51, 56, 27, 35, 81};
	public static void main (String args[]){
		//array = bubbleSort(array);
		array = insertionSort(array);
		for (int i=0; i<array.length-1;i++){
			System.out.print(" ,"+Integer.toString(array[i]));
		}
		
	}
	
	public static int[] bubbleSort(int[] array){
		int length = array.length;
		int temp;
		for (int i = length-2; i>=0; i--){
			for (int j=0; j<i; j++){
				if(array[j]>=array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	
	public static int[] selectionSort(int[] array){
		int length = array.length;
		int min, tmp, minIndex;
		for (int i=0; i<length; i++){
			min = array[i];
			minIndex = i;
			for (int j=i+1; j<length-1;j++){
				if (array[j] < min){
					min = array[j];
					minIndex = j;
				}
			}
			tmp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = tmp;
		}
		return array;
	}
	
	public static int[] insertionSort (int[] array){
		int length = array.length;
		int key;
		for (int i=1; i<length; i++){
			key = array[i];
			for (int j=i; j>0 && key<array[j-1] ; j--){
				array[j] = array[j-1];
				array[j-1] = key;
			}
		}
		return array;
	}
	
	public static int[] shellSort (int[] array){
		return array;
	}

}
