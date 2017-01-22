package course5;

public class LongestIncreasingSubsequence {
	
	//Accepted 12.12.2016 1710ms
	public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
		if(nums.length<=0){return 0;}
		if(nums.length==1){return 1;}
		
		return DP(nums, 0,Integer.MIN_VALUE,0);
	}
	
	public int DP(int[] nums, int index, int currMax, int currLength){
		if(index >= nums.length){return currLength;}
		if(index == nums.length-1){
			if( nums[index]> currMax){return currLength+1;}
			return currLength;
		}
		
		if(nums[index] <= currMax){return DP(nums,index+1,currMax,currLength);}
		return Math.max(DP(nums,index+1,nums[index],currLength+1), DP(nums,index+1,currMax,currLength));
	}
}
