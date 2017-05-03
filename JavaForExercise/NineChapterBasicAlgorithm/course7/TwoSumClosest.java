package course7;

import java.util.Arrays;

public class TwoSumClosest {
	
	//Accepted 5.2.2017 10458ms
	public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        if (nums == null) {return -1;}
        
        int min = Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return 0;
            } else if (sum < target) {
                min = min < Math.abs(target - sum) ? min : Math.abs(target - sum);
                left++;
            } else {
                min = min < Math.abs(target - sum) ? min : Math.abs(target - sum);
                right--;
            }
        }
        
        return min;
    }
}
