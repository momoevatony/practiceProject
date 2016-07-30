package com.momoevatony.leetCodeMedium;

import java.util.HashMap;

public class JumpGame {
	
	public boolean canJump2(int[] nums) {
        if(nums.length<=0){return false;}
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		return canJumpRe(nums,0, map);
    }
	private boolean canJumpRe (int[] nums, int index, HashMap<Integer, Boolean> map){
		if(index == nums.length-1) {return true;}
		if(map.containsKey(index)){return map.get(index);}
		boolean result = false;
		int max = nums[index];	
		for(int i = 1; i<=max;i++){
			result = result || canJumpRe(nums, index+i, map);
		}
		map.put(index, result);
		return result;
	}
	
	//Accepted 7.29.2016
	public boolean canJump(int[] nums) {
        if(nums.length<=0){return false;}
        int currIndex = nums.length-1;
        int canReachIndex = nums.length-1;
        while(currIndex>=0){
        	if (nums[currIndex] >= canReachIndex - currIndex){
        		canReachIndex = currIndex;
        	}
        	currIndex--;
        }
		return canReachIndex == 0;
    }

}
