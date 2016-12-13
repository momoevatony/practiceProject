package course5;

public class MaximumProductSubarray {
	
	//TODO
	public int maxProduct(int[] nums) {
        // write your code here
		if(nums.length==0){return 0;}
		int[] map = new int[nums.length];
		int[] abs = new int[nums.length];
		int max = nums[0];
		int absMax = nums[0];
		map[0] = nums[0];
		abs[0] = nums[0];
		for(int i=0; i<nums.length;i++){
			if(nums[i] ==0){map[i]=0;abs[i]=0;continue;}
			map[i] = map[i-1]*nums[i]<nums[i] ? nums[i]:map[i-1]*nums[i];
			abs[i] = abs[i-1]==0?nums[i]:nums[i]*abs[i-1];
			max = Math.max(map[i],max);
			absMax = Math.max(abs[i], absMax);
		}
		return Math.max(max,absMax);
    }
}
