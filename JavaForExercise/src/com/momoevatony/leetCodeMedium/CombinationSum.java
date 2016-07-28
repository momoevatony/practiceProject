package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public static void main(String args[]){
		int[] candidates = {2,3,6,7};
		int target = 1;
		List<List<Integer>> list = combinationSum(candidates, target);
		for(List<Integer>curr:list){
			List<Integer> print = new ArrayList<Integer>(curr);
			System.out.println(Arrays.toString(print.toArray()));
		}
	}
	
	
	//Accepted 7.27.2016
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List <List<Integer>> list = new ArrayList <List<Integer>>();
		Arrays.sort(candidates);
		if(target<candidates[0]){return list;}
		combinationSumDFS(candidates, 0, new ArrayList<Integer>(), list, target);
		System.out.println(list.size());
        return list;
    }
	
	public static void combinationSumDFS(int[] candidates, int index, List<Integer> tempList, List<List<Integer>> list, int target){
		System.out.println("DFS called with index: "+index+" and target: "+target+", tempList is:"+Arrays.toString(tempList.toArray()));
		while(index<candidates.length-1 && candidates[index] ==candidates[index+1]){index++;}
		if(target == 0 ){list.add(new ArrayList<Integer>(tempList));System.out.println(Arrays.toString(tempList.toArray())+" list added!");}
		else if(candidates[index] > target){return;}
		else {
			for(int start = index; start<candidates.length && candidates[start] <= target;start++){
				tempList.add(candidates[start]);
				combinationSumDFS(candidates, start, tempList, list, target-candidates[start]);
				tempList.remove(tempList.size()-1);
			}
		}
	}
}
