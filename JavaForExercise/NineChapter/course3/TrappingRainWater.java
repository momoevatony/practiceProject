package course3;

public class TrappingRainWater {
	
	//Two pointers Accepted 12.7.2016 1489ms
	public int trapRainWater(int[] heights) {
        // write your code here
		if(heights==null || heights.length<=0){return 0;}
		int result = 0;
		
		int left = 0;
		int right = heights.length-1;
		int middle;
		while(left<right){
			if(heights[left]<heights[right]){
				middle = left+1;
				while(middle<right && heights[middle]<=heights[left]){
					result += heights[left]-heights[middle];
					middle++;
				}
				left=middle;
			}else{
				middle=right-1;
				while(middle>left && heights[middle] <= heights[right]){
					result += heights[right] - heights[middle];
					middle--;
				}
				right = middle;
			}
		}
		return result;
    }
	public int trapRainWater2(int[] heights) {
        // write your code here
		if(heights==null || heights.length<=0){return 0;}
		int result = 0;
		
		int left = 0;
		int right = heights.length-1;
		int[] maxHeights = new int [heights.length+1];
		while(left<right){
			if(heights[left] < heights[right]){
				
				left++;
			}else{
				right--;
			}
		}
		return result;
    }
	
	
	
	//Heap solution TODO
	public class Solution {
	    /**
	     * @param heights: an array of integers
	     * @return: a integer
	     */
		public int trapRainWater(int[] heights) {
	        if (heights.length == 0) {
	            return 0;
	        }
	        
	        int[] maxHeights = new int[heights.length + 1];
	        maxHeights[0] = 0;
	        for (int i = 0; i < heights.length; i++) {
	            maxHeights[i + 1] = Math.max(maxHeights[i], heights[i]);
	        }
	        
	        int max = 0, area = 0;
	        for (int i = heights.length - 1; i >= 0; i--) {
	            area += Math.min(max, maxHeights[i]) > heights[i]
	                    ? Math.min(max, maxHeights[i]) - heights[i]
	                    : 0;
	            max = Math.max(max, heights[i]);
	        }
	        
	        return area;
	    }
	}
}
