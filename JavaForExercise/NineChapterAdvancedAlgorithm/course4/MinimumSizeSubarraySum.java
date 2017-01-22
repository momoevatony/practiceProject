package course4;

public class MinimumSizeSubarraySum {
	
	//Accetped 12.11.2016 2149ms
	public int minimumSize(int[] nums, int s) {
        // write your code here
		int min=Integer.MAX_VALUE;
		if(nums.length<=0){return -1;}
		int slow=0, fast = 0;
		int sum = 0;
		while(fast<nums.length){
			sum+=nums[fast];
			while(slow<=fast&&sum>=s){
			    min = Math.min(min, fast-slow+1);
				sum-=nums[slow];
				slow++;
			}
			fast++;
		}
		return min==Integer.MAX_VALUE?-1:min;
    }
}
