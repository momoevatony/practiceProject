package com.momoevatony.leetCodeEasy;

import java.util.Arrays;

public class RemoveDupFromArray {
	public static void main (String args[]){
		int[] array = {1,2,2,2,3,4,5,5,6};
		System.out.println(Arrays.toString(removeDup(array)));
	}
	
	public static int[] removeDup(int[] array){
		int newLength = 0;
		for (int i=0; i<array.length-1;i++){
			if(array[i] != array[i+1]){array[newLength+1]=array[i+1];newLength++;}
		}
		return array;
	}

}
