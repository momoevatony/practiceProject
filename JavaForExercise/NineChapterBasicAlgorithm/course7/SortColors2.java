package course7;

public class SortColors2 {
	
	//Accepted 5.2.2017 3932ms
	public void sortColors2(int[] colors, int k) {
        // write your code here
        sortColorsByK(colors, 0, colors.length - 1, 1, k);
    }
    
    private void sortColorsByK (int[] colors, int start, int end, int colorFrom, int colorTo) {
        if(start >= end || colorFrom == colorTo) {return;}
        //System.out.println(Arrays.toString(colors) + "start: "+start+ " end: "+end);
        
        int left = start;
        int right = end;
        int colorMid = (colorFrom + colorTo) / 2;
        
        while (left < right) {
            while (left < right && colors[left] <= colorMid) {
                left++;
            }
            while (left < right && colors[right] > colorMid) {
                right--;
            }
            if(left < right) {
                swap(colors, left, right);
                left++;
                right--;
            }
        }
        if (colors[left] > colorMid) {
            left--;
        }
        
        sortColorsByK(colors, start, left, colorFrom, colorMid);
        sortColorsByK(colors, left + 1, end, colorMid + 1, colorTo);
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
