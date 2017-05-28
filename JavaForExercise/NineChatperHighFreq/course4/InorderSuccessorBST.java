package course4;

public class InorderSuccessorBST {
	
	//accepted 5.27.2017
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }
        
        TreeNode result = null;
        while (root.val != p.val) {
            if (root.val < p.val) {
                root = root.right;
            }
            if (root.val > p.val) {
                result = root;
                root = root.left;
            }
        }
        
        if (root.right != null) {
            result = root.right;
            while (result.left != null) {
                result = result.left;
            }
        }
        
        return result;
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
