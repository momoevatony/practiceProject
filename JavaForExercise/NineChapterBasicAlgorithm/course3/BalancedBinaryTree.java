package course3;

public class BalancedBinaryTree {
	
	//Accepted 2.2.2017 1728ms
	public boolean isBalanced(TreeNode root) {
        // write your code here
		return helper(root).isBalanced;
    }
	
	private ResultType helper(TreeNode root){
		
		if(root == null){
			return new ResultType(true, 0);
		}
		
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		if(!left.isBalanced || !right.isBalanced){
			return new ResultType(false, 0);
		}
		
		if(Math.abs(left.height-right.height)>1){
			return new ResultType(false, 0);
		}
		
		return new ResultType(true, Math.max(left.height, right.height)+1);
	}
	
	private class ResultType{
		public boolean isBalanced;
		public int height;
		public ResultType(boolean isBalanced, int height){
			this.isBalanced = isBalanced;
			this.height = height;
		}
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
