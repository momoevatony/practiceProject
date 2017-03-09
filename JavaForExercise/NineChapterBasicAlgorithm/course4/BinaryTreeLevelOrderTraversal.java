package course4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	//accepted 3.8.2017 3087ms
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if(root == null) {return list;}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			ArrayList<Integer> level = new ArrayList<>();
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode curr = queue.poll();
				level.add(curr.val);
				if(curr.left!=null){queue.offer(curr.left);}
				if(curr.right!=null){queue.offer(curr.right);}
			}
			list.add(level);
		}
		
		return list;
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
