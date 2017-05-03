package course7;

import java.util.Arrays;

public class TwoSumUniquePairs {
	
	//Accepted 5.2.2017 3530ms
	public int twoSum6(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2) {return 0;}
        
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                count++;
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        
        return count;
    }
}
