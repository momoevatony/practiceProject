package com.momoevatony.leetCodeMedium;

public class FindPeakElement {
	
	//Accepted 10.26.2016
	public int findPeakElement(int[] nums) {
		if(nums.length<=1){return 0;}
		int peak = 0;
		while(peak < nums.length-1 && nums[peak]<=nums[peak+1]){peak++;}
		return peak;
	}

}
