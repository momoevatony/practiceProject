package course5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	//accepted 3.9.2017 2152ms
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
		List<List<Integer>> list = new ArrayList<>();
		if(candidates == null || candidates.length == 0) {return list;}
		
		int [] nums = removeDuplicates(candidates);
		ArrayList<Integer> innerList = new ArrayList<>();
		
		DFS(list, innerList, nums, target, 0);
		
		return list;
    }
	
	private void DFS (List<List<Integer>> list, ArrayList<Integer> innerList, int[] nums, int remainTarget, int startIndex){
		if(remainTarget == 0) {
			list.add(new ArrayList<Integer>(innerList));
		}
		
		for(int i=startIndex; i<nums.length; i++) {
			if(nums[i] > remainTarget) {return;}
			if(i != startIndex && nums[i] == nums[i-1]) {continue;}
			innerList.add(nums[i]);
			DFS(list, innerList, nums, remainTarget-nums[i], i);
			innerList.remove(innerList.size()-1);
		}
		
	}
	
	private int[] removeDuplicates(int[] candidates){
		if(candidates.length == 1){return candidates;}
		Arrays.sort(candidates);
		int slow = 0;
		for(int i=1; i<candidates.length; i++) {
			if(candidates[i] != candidates[slow]) {
				candidates[++slow] = candidates[i];
			}
		}
		return Arrays.copyOf(candidates, slow+1);
	}
}
