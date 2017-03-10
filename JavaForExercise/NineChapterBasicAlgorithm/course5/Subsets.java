package course5;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	
	//Accepted 3.9.2017 1253ms
	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> innerList = new ArrayList<>();
		list.add(innerList);
		if(nums == null || nums.length == 0) {return list;}
		
		Arrays.sort(nums);
		
		DFS(list, innerList, nums, 0);
		
		return list;
    }
	
	private void DFS(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> innerList,int[] nums, int startIndex){
		if(startIndex == nums.length) {
			return;
		}
		
		for(int i=startIndex; i<nums.length; i++) {
			//if(i != startIndex && nums[i] == nums[i-1]) {continue;}
			innerList.add(nums[i]);
			list.add(new ArrayList<Integer>(innerList));
			DFS(list,innerList,nums,i+1);
			innerList.remove(innerList.size()-1);
		}
	}
}
