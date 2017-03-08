package course3;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {
	
	//Accepted 3.7.2017 6296ms
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> currList = new ArrayList<Integer>();
		helper(list, currList, root, target);
		return list;
    }
	
	private void helper(List<List<Integer>> list, List<Integer> currList, TreeNode root, int target){
		if(root == null){return;}
		List<Integer> temp = new ArrayList<Integer>(currList);
		if(root.left==null && root.right == null){
			if(root.val == target){
				temp.add(root.val);
				list.add(temp);
				return;
			}
		}
		temp.add(root.val);
		helper(list, temp, root.left, target-root.val);
		helper(list, temp, root.right, target-root.val);
	}
	
	public class TreeNode {
	    public int val;
	    public TreeNode left, right;
	    public TreeNode(int val) {
	        this.val = val;
	        this.left = this.right = null;
	    }
	}
}
