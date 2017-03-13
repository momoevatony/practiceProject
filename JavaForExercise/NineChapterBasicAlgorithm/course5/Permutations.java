package course5;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        if(nums == null || nums.length ==0) {
            list.add(innerList); 
            return list;
        }
        
        boolean[] added = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dfs(list, innerList, nums, i, added);
        }
        
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> innerList, int[]nums, int startIndex, boolean[] added) {    
        innerList.add(nums[startIndex]);
        added[startIndex] = true;
        
        if(innerList.size() == nums.length) {
            list.add(new ArrayList<Integer>(innerList));
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(added[i]) {
                continue;
            }
            
            dfs(list, innerList, nums, i, added);
        }
        innerList.remove(innerList.size()-1);
        added[startIndex] = false;
    }

}
