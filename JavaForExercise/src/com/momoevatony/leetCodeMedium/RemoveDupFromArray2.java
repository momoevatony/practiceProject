package com.momoevatony.leetCodeMedium;

import java.util.HashMap;

public class RemoveDupFromArray2 {
	
	public int removeDuplicates(int[] nums) {
        if(nums.length ==1){return 1;}
		HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        int length=0; int i=0;
        while(i<nums.length){
        	if(!map.containsKey(nums[i]) || map.get(nums[i])==1){
        	    nums[length]=nums[i];
                length++;i++;
                if(!map.containsKey(nums[i])){map.put(nums[i], 1);}
                else{map.put(nums[i], 2);}
        	}
        	else{while(i<nums.length && nums[i] == nums[i-1]){i++;}}
        }
        return length;
    }
}
