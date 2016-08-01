package com.momoevatony.leetCodeEasy;

public class RemoveDupFromArray {
	
	//Accepted 7.31.2016
	
	public int removeDuplicates(int[] nums) {
        if(nums.length ==1){return 1;}
        int length=1;
        for(int i=1;i<nums.length;i++){
            while(i<nums.length && nums[i] == nums[i-1]){i++;}
            if(i==nums.length){break;}
            nums[length]=nums[i];
            length++;
        }
        return length;
    }

}
