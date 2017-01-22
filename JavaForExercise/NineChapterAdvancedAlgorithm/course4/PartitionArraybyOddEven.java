package course4;

public class PartitionArraybyOddEven {
	
	//Accepted 12.17.2016 1489ms
	public void partitionArray(int[] nums) {
        // write your code here;
		int i=0;
		int j=nums.length-1;
		
		while(i<j){
			while(i<j&&nums[i]%2==1){i++;}
			while(i<j&&nums[j]%2==0){j--;}
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;j--;
		}
    }
}
