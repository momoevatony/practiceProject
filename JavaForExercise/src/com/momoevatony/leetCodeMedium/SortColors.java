package com.momoevatony.leetCodeMedium;

public class SortColors {
	
	//accepted 9.12.2016
	public void sortColors(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		int ptr = 0;
		while (ptr <= end){
			if(nums[ptr] ==1){
				ptr++;
			}else if (nums[ptr] ==0){
				nums[ptr] = nums[start];
				nums[start] = 0;
				ptr++; start++;
			}else if (nums[ptr] ==2){
				nums[ptr] = nums[end];
				nums[end] = 2;
				end--;
			}
		}
    }

}
