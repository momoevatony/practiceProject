package com.momoevatony.leetCodeMedium;

public class MaxSubArray {
	public static void main(String args[]){
		int[]nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	
	//Accepted 7.28.2016
	public static int maxSubArray(int[] nums) {
		int index=0;
		int currMax= 0;
		int max = nums[0];
		
		while(index<nums.length){
			if(nums[index]>0){
				currMax=currMax>0?currMax+nums[index]:nums[index];
			}else{
				currMax+=nums[index];
			}
			currMax = currMax>nums[index]? currMax:nums[index];
			max = max>currMax? max:currMax;
			index++;
		}
		
        return max;
    }

}
