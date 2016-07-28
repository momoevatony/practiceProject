package com.momoevatony.leetCodeMedium;

import java.util.Arrays;

public class ThreeSumClosest {
	public static void main(String args[]){
		int[]nums = {0,1,2};
		//System.out.println(Arrays.toString(nums));
		//System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 1,nums.length)));
		System.out.println(threeSumClosest(nums,100));
		//twoSum(nums,81);
	}
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = nums[0]+nums[1]+nums[2];
		for(int i=0; i<nums.length-2;i++){
			if(i>0 && nums[i]==nums[i-1]){continue;}
			int left = i+1;
			int right = nums.length-1;
			while(left < right){
				int currSum = nums[i]+nums[left]+nums[right];
				if(currSum == target){return target;}
				if(currSum < target){
					if((target-currSum)<Math.abs(target-closest)){
						closest = currSum;
					}
					left++;
				}
				else if(currSum > target){
					if((currSum-target)<Math.abs(target-closest)){
						closest = currSum;
					}
					right--;
				}
			}
		}
        return closest;
    }
	public static void twoSum(int[] nums, int target){
		Arrays.sort(nums);
		int i=0; int j=nums.length-1;
		while(i<j){
			if(nums[i]+nums[j]==target){System.out.println("found number: "+nums[i]+" and number: "+nums[j]);j--;}
			if(nums[i]+nums[--j]> target){System.out.println("number j: "+nums[j]);}
			if(nums[i]+nums[j]< target){i++;}
		}
	}
	
	public int [] check (){
		return new int[] {2,3};
	}
}
