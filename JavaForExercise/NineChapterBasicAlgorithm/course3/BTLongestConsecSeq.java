package course3;

public class BTLongestConsecSeq {

	//accepted 3.7.2017 11704ms
	private int max=0;
	public int longestConsecutive(TreeNode root) {
        // Write your code here
		helper(root);
		return max;
    }
	
	private int helper(TreeNode root){
		if(root == null){return 0;}
		if(root.left == null && root.right == null){if(max<1){max=1;}return 1;}
		
		int left = helper(root.left);
		int right = helper(root.right);
		
		if(root.left!=null && root.right!=null){
			if(root.val!=root.left.val-1 && root.val != root.right.val-1){
				if(max<1){max=1;}
				return 1;
			}else if(root.val!=root.left.val-1){
				if(max<right+1){max=right+1;}
				return right+1;
			}else if(root.val!=root.right.val-1){
				if(max<left+1){max=left+1;}
				return left+1;
			}else{
				if(max<Math.max(left, right)+1){max=Math.max(left, right)+1;}
				return Math.max(left, right)+1;
			}
		}else if(root.left!=null){
			if(root.val==root.left.val-1){
				if(max<left+1){max=left+1;}
				return left+1;
			}
			return 1;
		}else{
			if(root.val==root.right.val-1){
				if(max<right+1){max=right+1;}
				return right+1;
			}
			return 1;
		}
		
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
