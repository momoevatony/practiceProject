package com.momoevatony.leetCodeEasy;

public class RemoveElementFromArray {
	
	//Accepted 9.7.2016
	public int removeElement(int[] nums, int val) {
        int ptr =0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                nums[ptr++]=nums[i];
            }
        }
        return ptr;
    }
}
