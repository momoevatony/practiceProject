package course3;

public class MinimumSubtree {
	
	//Accepted 2.6.2017 6621ms
	private ResultType result = new ResultType(null,Integer.MAX_VALUE);
	
	public TreeNode findSubtree(TreeNode root) {
        // Write your code here
		if(root == null){return null;}
		sum(root);
		return result.root;
    }
	private int sum(TreeNode root){
		if(root == null){return 0;}
		int sum = root.val+sum(root.left)+sum(root.right);
		if(sum<result.sum){result = new ResultType(root,sum);}
		return sum;
	}
	
	private class ResultType{
		TreeNode root;
		int sum;
		public ResultType(TreeNode root, int sum){
			this.root = root;
			this.sum = sum;
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
