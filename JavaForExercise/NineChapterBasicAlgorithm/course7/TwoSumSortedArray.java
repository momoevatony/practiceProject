package course7;

public class TwoSumSortedArray {
	
	//accepted 5.2.2017 2257ms
	public int[] twoSum(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 2) {
            return new int[2];
        }
        
        int[] ans = new int[2];
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return ans;
    }
}
