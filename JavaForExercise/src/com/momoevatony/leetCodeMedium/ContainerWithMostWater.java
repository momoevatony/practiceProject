package com.momoevatony.leetCodeMedium;

public class ContainerWithMostWater {
	
	
	//Accepted 7.27.2016
	public int maxArea(int[] height){
		int maxArea=0;
		int left=0;int leftHi=0;
		int right=height.length-1; int rightHi=0;
		int currArea = 0;
		
		while(left<right){
			leftHi=height[left];
			rightHi=height[right];
			currArea = (leftHi<rightHi? leftHi:rightHi)*(right-left);
			maxArea = currArea>maxArea?currArea:maxArea;
			
			if(leftHi<rightHi){
				while(left<right && height[left]<=leftHi){left++;}
			}else{
				while(left<right && height[right]<=rightHi){right--;}
			}
		}
		return maxArea;
	}
	
	//first try: time limit exceed as expected lol
	public int maxArea2(int[] height) {
		int max=0, curr=0;
		for(int i=0;i<height.length-1;i++){
			for(int j=height.length-1;j>i;j--){
				curr = (height[i]>=height[j]?height[i]:height[j])*(j-i);
				max = curr>=max?curr:max;
			}
		}
		return max;
    }

}
