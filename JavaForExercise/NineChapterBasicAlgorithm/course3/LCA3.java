package course3;

public class LCA3 {
	
	//Accepted 3.7.2017 2412ms
	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
		ResultType result = helper(root,A,B);
		if(result.found){return result.root;}
		return null;
    }
	
	private ResultType helper (TreeNode root, TreeNode A, TreeNode B){
		if (root==null) {return new ResultType(null,false);}
		if (root==A && root==B){return new ResultType(root, true);}
		ResultType left = helper(root.left, A, B);
		ResultType right = helper(root.right, A, B);
		
		if(left.root == null && right.root == null){
			if(root ==A || root==B){
				return new ResultType(root, false);
			}
			return new ResultType(null,false);
		}else if(right.root==null){
			if(root ==A || root==B){
				return new ResultType(root, true);
			}
			return left;
		}else if(left.root==null){
			if(root ==A || root==B){
				return new ResultType(root, true);
			}
			return right;
		}else{
			return new ResultType(root,true);
		}
		
	}
	
	public class ResultType {
		public TreeNode root;
		public boolean found;
		
		public ResultType(TreeNode root, boolean found){
			this.root = root;
			this.found = found;
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
