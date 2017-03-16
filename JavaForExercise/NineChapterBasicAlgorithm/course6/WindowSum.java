package course6;

public class WindowSum {
	
	//accepted 3.15.2017
	public int[] winSum(int[] nums, int k) {
        // write your code here
		if(nums == null || nums.length ==0 || nums.length < k) {return new int[0];}
		int[] winSum = new int[nums.length - k + 1];
		for(int i = 0; i < nums.length; i++) {
			if(i < k) {
				winSum[0] = winSum[0] + nums[i];
			}else {
				winSum[i - k + 1] = winSum[i - k] - nums[i - k] + nums[i];
			}
		}
		
		return winSum;
    }
}
