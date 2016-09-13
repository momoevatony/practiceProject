package com.momoevatony.leetCodeMedium;

import java.util.Arrays;

public class SearchForRange {
	
	public static void main(String[] args){
		int[]nums = {1,5};
		int target = 4;
		System.out.println(Arrays.toString(searchRange(nums,target)));
	}
	
	//Accetped 9.7.2016
	public static int[] searchRange(int[] nums, int target) {
		if(target<nums[0] || target>nums[nums.length-1]){return new int[]{-1,-1};}
		int start = 0;
		int end = nums.length-1;
		int mid = (start+end)/2;	
		if(nums.length==1){return new int[]{0,0};}
		if(nums.length==2){
		    if(nums[0]==target){
				if(nums[1]==target){return new int[]{0,1};}
				else {return new int[]{0,0};}
			}
			if(nums[1]==target){
				return new int[]{1,1};
			}
			return new int[]{-1,-1};}
		while(start<end-1){
			//System.out.println("start: "+start+" mid: "+mid+" end: "+end);
			if(nums[mid] == target || nums[start] == target || nums[end] == target){
				start= nums[mid] == target? mid : nums[start] == target? start:end;
				end= nums[mid] == target? mid : nums[start] == target? start:end;
				while(start>0&&nums[start-1]==target){start--;}
				while(end<nums.length-1&&nums[end+1]==target){end++;}
				return new int[]{start,end};
			}
			else if(nums[mid]<target){
				start = mid;
				mid =  (start+end)/2;
			}else{
				end = mid;
				mid =  (start+end)/2;
			}
		}
		return new int[]{-1,-1};
    }

}
