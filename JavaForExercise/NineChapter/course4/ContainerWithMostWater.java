package course4;

public class ContainerWithMostWater {
	
	//Accepted 12.11.2016 3527ms
	public int maxArea(int[] heights) {
        // write your code here
		if(heights.length<=1){return 0;}
		int maxArea = 0;
		int left = 0;
		int right = heights.length-1;
		
		while(left<right){
			if(heights[left] < heights[right]){
				maxArea = Math.max(maxArea, (right-left)*heights[left]);
				while(left<right && heights[left+1]<=heights[left]){
					left++;
				}
				left++;
			}else{
				maxArea = Math.max(maxArea, (right-left)*heights[right]);
				while(left<right && heights[right-1]<=heights[right]){
					right--;
				}
				right--;
			}
		}
		
		return maxArea;
    }
}
