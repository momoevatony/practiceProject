package course7;

public class SortColors {
	
	//Accepted 5.2.2017 8092ms
	public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length <= 1) {
            return;
        }
        
        int left = 0;
        int right = nums.length - 1;
        int curr = 0;
        
        while (curr <= right) {
            if (nums[curr] == 0) {
                swap(nums, curr, left);
                curr++;
                left++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, right);
                right--;
            } else {
                curr++;
            }
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
