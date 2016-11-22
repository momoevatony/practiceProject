package com.momoevatony.leetCodeMedium;


public class MinSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int sum = 0;
		int minLen = 0;
		
		for(int end=0; end<nums.length; end++){
			if(nums[end]>=s){return 1;}
			sum += nums[end];
			if(sum>=s){
				if(minLen == 0) {minLen=end;}
				int tempSum = sum;
				int start=0;
				while(start<end){
					if(tempSum<s){start--;break;}
					tempSum -= nums[start];
					start++;
				}
				System.out.println("start is: "+ start +"end is: "+end);
				minLen = end-start+1 < minLen? end-start+1:minLen;
			}
		}
		return minLen;
    }
}
