package com.momoevatony.leetCodeEasy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSums {
	
	public static void main (String args[]){
		int[] input = {2,7,11,15};
		int sum = 9;
		int [] twoSum = twoSum(input, sum);
		System.out.println(Arrays.toString(twoSum));
	}
	
	static int[] twoSum(int[]input, int sum){
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<input.length; i++){
			Integer index = map.get(sum-input[i]);
			if(index == null){
				map.put(input[i], i);   // !!!!!!
			}else {
				return new int[]{index, i}; 
			}
		}
		return result;
	}

}
