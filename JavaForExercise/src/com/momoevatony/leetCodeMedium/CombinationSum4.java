package com.momoevatony.leetCodeMedium;

import java.util.Arrays;
import java.util.HashMap;

public class CombinationSum4 {
	private static int ways=0;
	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	//TODO
	public static void main(String args[]){
		int[] nums = {1,2,3};
		int target = 4;
		System.out.println(combinationSum4(nums,target));
	}
	
	public static int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		if(nums.length<=0 || target<nums[0]){return 0;}
		combinationSum4Recur(nums,target);
		return ways;
    }
	
	public static void combinationSum4Recur (int [] nums, int target){
		if(target == 0){ways+= 1;}
		for(int i=0; i<=nums.length-1;i++){
			if(nums[i]>target){break;}
			combinationSum4Recur(nums, target-nums[i]);
		}
	}
	
	public static void combinationSum4DP (int[] nums, int target, HashMap<Integer, Integer> map, int currTarget){
		
		
	}
	
}
