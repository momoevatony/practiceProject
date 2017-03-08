package course3;

public class ValidateBST {

	//accepted 3.7.2017 2841ms
	public boolean isValidBST(TreeNode root) {
        // write your code here
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	private boolean helper(TreeNode root, int min, int max){
		if(root == null){return true;}
		
		if(root.left!=null){if(root.left.val<=min || root.left.val>=root.val){if(root.left.val==Integer.MIN_VALUE){return true;}return false;}}
		if(root.right!=null){if(root.right.val<=root.val || root.right.val>=max){if(root.right.val==Integer.MAX_VALUE){return true;}return false;}}
		boolean left = helper(root.left, min, root.val);
		boolean right = helper(root.right, root.val, max);
		
		return left&&right;
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
