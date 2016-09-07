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
	
	//Accepted 9.6.2016
	static int[] twoSum(int[]nums, int target){
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<nums.length; i++){
			Integer index = map.get(target-nums[i]);
			if(index == null){
				map.put(nums[i], i);   // !!!!!!
			}else {
				return new int[]{index, i}; 
			}
		}
		return result;
	}

}
