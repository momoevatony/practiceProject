package course3;

public class BinaryTreeMaxPathSum {
	
	//TODO
	public int maxPathSum(TreeNode root) {
        // write your code here
		if(root == null){return 0;}
		if(root.left==null){
			if(root.right ==null){return root.val;}
			if(root.right.val>0){return root.val+root.right.val;}
			return root.val;
		}else{
			
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
