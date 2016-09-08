package com.momoevatony.leetCodeMedium;

public class SearchInsertPosition {
	
	//Accepted 9.7.2016
	public int searchInsert(int[] nums, int target) {
		int start = 0; int end = nums.length-1;
		
		while(start <= end){
			int mid = start + ( (end-start) >> 1) ;
			if(nums[mid] == target){return mid;}
			if(nums[mid]<target){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		return start;
    }
}
