package course3;

public class FlattenBinaryTree {
	
	//accetped 2.6.2017 //1441ms
	public void flatten(TreeNode root) {
        // write your code here
		
		if(root == null){
			return;
		}
		
		if(root.left == null && root.right == null){
			return;
		}
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		flatten(left);
		flatten(right);
		
		if(left!=null){
			root.right = left;
			root.left = null;
			while(left.right!=null){
				left = left.right;
			}
			left.right = right;
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
