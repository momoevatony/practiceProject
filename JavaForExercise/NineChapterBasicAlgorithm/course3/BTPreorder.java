package course3;

import java.util.ArrayList;

public class BTPreorder {
	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null) {return list;}
		
		preOrder(list, root);
		
		return list;
    }
	
	private void preOrder(ArrayList<Integer> list, TreeNode root){
		if(root == null) {return;}
		
		list.add(root.val);
		preOrder(list, root.left);
		preOrder(list, root.right);
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
