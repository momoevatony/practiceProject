package com.momoevatony.searchAlgorithm;

public class BinarySearch {
	public static void main (String args[]){
		int[] array = {1,2,3,4,5,6,7,8,9};
		System.out.print(Integer.toString(binarySearch2(array, 5)));
	}
	
	public static int binarySearch1(int[] array, int x){
		int start = 0;
		int end = array.length-1;
		int mid;
		while (start<=end){
			mid = (start + end)/2;
			if (array[mid] < x){
				start = mid+1;
			}else if (array[mid]>x){
				end = mid-1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	
	public static int binarySearch2(int[] array, int x){
		return binarySearchRecur(array, x, 0, array.length-1);
	}
	
	public static int binarySearchRecur(int[] array, int x, int start, int end){
		if (start>end){return -1;}
		
		int mid = (start+end)/2;
		if (array[mid]>x){return binarySearchRecur(array,x,mid+1,end);}
		else if(array[mid]<x){return binarySearchRecur(array,x,mid-1,end);}
		else {return mid;}
	}
	
}
