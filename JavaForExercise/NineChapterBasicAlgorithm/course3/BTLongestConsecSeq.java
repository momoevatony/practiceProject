package course3;

public class BTLongestConsecSeq {
	
	
	//2.6.2017 TODO
	public int longestConsecutive(TreeNode root) {
        // Write your code here
		return 0;
    }
	
	private ResultType helper(TreeNode root){
		if(root == null){return new ResultType(null,0);}
		
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		
	}
	
	private class ResultType{
		int count;
		TreeNode root;
		public ResultType(TreeNode root, int count){
			this.count = count;
			this.root = root;
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
