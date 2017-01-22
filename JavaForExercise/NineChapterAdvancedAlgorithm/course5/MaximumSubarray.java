package course5;

public class MaximumSubarray {
	
	//Accepted 12.12.2016 1879ms
	public int maxSubArray(int[] nums) {
        // write your code
        if(nums.length==0){return 0;}
        int[] map = new int[2];
        map[0] = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            map[i%2] = map[(i-1)%2]>0?map[(i-1)%2]+nums[i] : nums[i];
            max = Math.max(max, map[i%2]);
        }
        return max;
    }
}
