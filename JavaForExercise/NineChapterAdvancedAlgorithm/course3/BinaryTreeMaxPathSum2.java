package course3;

public class BinaryTreeMaxPathSum2 {
	
	//Accepted 12.16.2016 3119ms
	public int maxPathSum2(TreeNode root) {
        // write your code here
		if(root == null){return 0;}
		if(root.left==null && root.right == null){return root.val;}
		if(root.left==null){return Math.max(0,maxPathSum2(root.right))+root.val;}
		if(root.right==null){return Math.max(0,maxPathSum2(root.left))+root.val;}
		return root.val+Math.max(0,Math.max(maxPathSum2(root.left), maxPathSum2(root.right)));
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
