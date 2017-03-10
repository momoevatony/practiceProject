package course5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	
	//accepted 3.9.2017 2119ms
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
		List<List<Integer>> list = new ArrayList<>();
		if(num.length == 0) {return list;}
		
		Arrays.sort(num);
		ArrayList<Integer> innerList = new ArrayList<>();
		
		DFS(list, innerList, num, target, 0);
		
		return list;
    }
	
	private void DFS(List<List<Integer>> list, ArrayList<Integer> innerList, int[] nums, int remainTarget, int startIndex) {
		if(remainTarget == 0) {
			list.add(new ArrayList<Integer>(innerList));
		}
		
		for(int i = startIndex; i < nums.length; i++) {
			if(nums[i] > remainTarget){return;}
			if(i != startIndex && nums[i] == nums[i - 1]) {continue;}
			
			innerList.add(nums[i]);
			DFS(list, innerList, nums, remainTarget-nums[i], i+1);
			innerList.remove(innerList.size() - 1);
		}
	}
}
