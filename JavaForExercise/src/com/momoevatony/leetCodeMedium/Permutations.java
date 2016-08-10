package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	public static void main(String args[]){
		int[] nums = {1,2,3,4};
		List<List<Integer>> list = permute(nums);
		System.out.println(list.size());
	}
	
	//accepted 8.9.2016
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> innerList = new ArrayList<Integer>();
		list.add(innerList);
        if(nums.length<=0){return list;}
        
        return permuteDP(nums, 0, list);
    }
	
	public static List<List<Integer>> permuteDP (int[] nums, int index, List<List<Integer>> list){
		if(index == nums.length){return list;}
		List<List<Integer>> newList = new ArrayList<List<Integer>>();
		if(index == 0){
			List<Integer> newInnerList = new ArrayList<Integer>();
			newInnerList.add(nums[index]);
			newList.add(newInnerList);
			return permuteDP(nums, index+1, newList);
		}
		
		
		for(List<Integer> innerList : list){
			for (int i =0;i<=innerList.size();i++){
				List<Integer> newInnerList = new ArrayList<Integer>(innerList);
				newInnerList.add(i,nums[index]);
				newList.add(newInnerList);
			}
		}
		
		return permuteDP(nums, index+1, newList);
	}

}
