package course5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
	
	//accepted 3.13.2017 1627ms
	public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> innerList = new ArrayList<>();
		
		if(nums == null || nums.length == 0) {
			list.add(innerList);
			return list;
		}
		Arrays.sort(nums);
		boolean[] added = new boolean[nums.length];
		DFS(list, innerList, nums, 0, added);
		
		return list;
    }
	
	private void DFS(List<List<Integer>> list, List<Integer> innerList, int[] nums, int startIndex, boolean[] added) {
		if(innerList.size() == nums.length){
			list.add(new ArrayList<Integer>(innerList));
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(added[i] || (i != 0 && (nums[i] == nums[i-1] && !added[i-1]))) {
				continue;
			}

			innerList.add(nums[i]);
			added[i] = true;
			DFS(list, innerList, nums, i, added);
			innerList.remove(innerList.size()-1);
			added[i] = false;
		}
	}
}
