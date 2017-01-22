package course2;

public class FindMinInRotatedSortedArray {
	
	//accetped 1.21.2017 1451ms
	public int findMin(int[] nums) {
        // write your code here
		int start=0, end = nums.length-1;
		
		while(start + 1 < end){
			int mid = (end - start) / 2 + start;
			if(nums[mid]>nums[start] && nums[mid] < nums[end]){return nums[start];}
			else if(nums[mid]<nums[start]){
				end = mid;
			}else{
				start = mid;
			}
		}
		return nums[start]<nums[end]?nums[start]:nums[end];
    }
}
