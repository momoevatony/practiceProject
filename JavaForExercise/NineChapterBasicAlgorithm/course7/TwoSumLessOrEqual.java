package course7;

import java.util.Arrays;

public class TwoSumLessOrEqual {
	
	//Accepted 5.2.2017 3315ms
	public int twoSum5(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if(sum <= target) {
                count += right -left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
