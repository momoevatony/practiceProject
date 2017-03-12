package course3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePathSum2 {
	
	//{1,2,3,4,-1,-3,#,#,#,2,#,6,5,2,3}, 6
	public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
		List<List<Integer>> list = new ArrayList<>();
		if(root == null) {return list;}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			List<Integer> innerList = new ArrayList<Integer>();
			helper(curr, list, innerList, target);
			if(curr.left != null) {queue.offer(curr.left);}
			if(curr.right != null) {queue.offer(curr.right);}
		}
		
		return list;
    }
	
	private void helper(TreeNode root, List<List<Integer>> list, List<Integer> innerList, int remainTarget) {
		if(root == null) {return;}
		
		innerList.add(root.val);
		if(root.val == remainTarget) {
			list.add(new ArrayList<Integer>(innerList));
			innerList.remove(innerList.size()-1);
			return;
		}
		
		helper(root.left, list, innerList, remainTarget - root.val);
		helper(root.right, list, innerList, remainTarget - root.val);
		innerList.remove(innerList.size()-1);
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
