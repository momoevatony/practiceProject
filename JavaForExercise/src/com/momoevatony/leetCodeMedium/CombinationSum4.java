package com.momoevatony.leetCodeMedium;

import java.util.Arrays;

public class CombinationSum4 {
	private static int ways=0;
	
	
	//TODO
	public static void main(String args[]){
		int[] nums = {1,2,3};
		int target = 3;
		System.out.println(combinationSum4(nums,target));
	}
	
	public static int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		if(nums.length<=0 || target<nums[0]){return 0;}
		combinationSum4Recur(nums,target);
		return ways;
    }
	
	public static void combinationSum4Recur (int [] nums, int target){
		System.out.println("target now is: "+target);
		if(target == 0){System.out.println("called!");ways+= 1;}
		for(int i=0; nums[i]<=target&&i<nums.length-1;i++){
			combinationSum4Recur(nums, target-nums[i]);
		}
	}
}
