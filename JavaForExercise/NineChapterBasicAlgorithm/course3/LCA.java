package course3;

public class LCA {
	
	//Accepted 3.7.2017 2027ms
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
		if(root == null){return null;}
		if(root == A){return A;}
		if(root == B){return B;}
		
		TreeNode left = lowestCommonAncestor(root.left,A,B);
		TreeNode right = lowestCommonAncestor(root.right,A,B);
		
		if(left == A && right == B){return root;}
		if(left == null){return right;}
		return left;
		
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
