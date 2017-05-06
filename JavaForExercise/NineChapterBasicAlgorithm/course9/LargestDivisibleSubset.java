package course9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	
	//accepted 5.6.2017 5897ms
	public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        List<Integer> list = new ArrayList<Integer>();
        
        if(nums == null || nums.length == 0) {return list;}
        
        int[] map = new int[nums.length];
        int[] path = new int[nums.length];
        Arrays.sort(nums);
        int max = 0;
        int endPt = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            int curr = nums[i];
            map[i] = 1;
            path[i] = -1;
            
            for (int j = i - 1; j >= 0; j--) {
                if (curr % nums[j] == 0) {
                    if (map[j] >= map [i]) {
                        map[i] = map[j] + 1;
                        path[i] = j;
                    }
                }
            }
            if (map[i] > max) {
                max = map[i];
                endPt = i;
            }
        }
        /*
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(map));
        System.out.println(Arrays.toString(path));
        System.out.println("Max Length: "+max+" ends at: "+endPt);
        */
        list.add(nums[endPt]);
        
        while (path[endPt] != -1) {
            endPt = path[endPt];
            list.add(nums[endPt]);
        }
        
        return list;
    }
}
