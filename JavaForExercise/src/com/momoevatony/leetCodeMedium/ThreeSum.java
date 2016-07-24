package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
	
	public static void main (String args[]){
		int[] input = {};
		List<List<Integer>> list = threeSum (input);
		for (List<Integer> innerList : list){
			System.out.print(Arrays.toString(innerList.toArray()));
		}
	}
	
	//7.24.2016 Note: 两种方法都有同样问题：出现相同数字时候不应该直接跳过！！ 例如[-1,-1,2]
	//7.24.2016 Update: 上述问题已改正，然而还有问题：[]输入应该返回[]而不是null,直接返回list即可。
	//Accepted on 7.24.2016
	
	static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(nums.length<3){return list;}

        Arrays.sort(nums);
        for (int i=0; i<nums.length-2;i++){
        	if(nums[i]>0){break;}
        	while(i<nums.length-2 && nums[i]!=0 && nums[i] == nums[i+1] && nums[i+2] == nums[i+1]){i++;}
        	int j=i+1;
        	int k=nums.length-1;
        	while(j<k){
        		while(j<nums.length-2 && nums[j]!=0 && nums[j] == nums[j+1] && nums[j+2] == nums[j+1]){j++;}
    			while(k>2 && nums[k]!=0 && nums[k] == nums[k-1] && nums[k-2] == nums[k-1]){k--;}
        		if(nums[i]+nums[j]+nums[k] > 0){k--;}
        		else if(nums[i]+nums[j]+nums[k] <0){j++;}
        		else {
        			if(!list.contains(Arrays.asList(nums[i],nums[j],nums[k]))){
        				list.add(Arrays.asList(nums[i],nums[j],nums[k]));
        			}
        			j++;k--;
        		}
        	}
        }
        return list;
    }
	
	
	//Easy way
	//not correct
	static List<List<Integer>> threeSum2(int[] nums){
        List<Integer> innerList = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
		
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
        	while(nums[i] == nums[i+1]){i++;}
        	for (int j=i+1;j<nums.length-1;j++){
        		while(nums[j] == nums[j+1]){j++;}
        		for(int k=j+1; k<nums.length;k++){
        			while(k<nums.length-1 && nums[k] == nums[k+1]){k++;}
        			if(nums[i]+nums[j]+nums[k] == 0){innerList.add(nums[i]);innerList.add(nums[j]);innerList.add(nums[k]);list.add(innerList);}
        		}
        	}
        }
        
        return list;
	}

}
