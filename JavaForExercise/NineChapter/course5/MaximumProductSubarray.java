package course5;

public class MaximumProductSubarray {
	
	//Accepted 12.14.2016 3508ms
	public int maxProduct(int[] nums) {
        // write your code here
		if(nums.length==0){return 0;}
        if(nums.length==1){return nums[0];}
		
		int[] posMax = new int[nums.length];
		int[] negMax = new int[nums.length];
		
		int max = nums[0];
		posMax[0] = nums[0];
		negMax[0] = nums[0];
		
		for(int i=1; i<nums.length;i++){
			if(nums[i]>0){
				posMax[i] = Math.max(posMax[i-1]*nums[i], nums[i]);
				negMax[i] = Math.min(negMax[i-1]*nums[i], nums[i]);
			}
			else if(nums[i]<0){
				posMax[i] = Math.max(negMax[i-1]*nums[i], nums[i]);
				negMax[i] = Math.min(posMax[i-1]*nums[i], nums[i]);
			}else{
				posMax[i] = 0;
				negMax[i] = 0;
			}
			max = Math.max(posMax[i], max);
		}
		
		return max;
    }
}
