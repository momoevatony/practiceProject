package course3;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreePaths {
	
	//accepted 2.2.2017 2785ms
	public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
		List<String> paths = new ArrayList<String>();
		
		if(root == null){return paths;}
		if(root.left == null && root.right == null){
			paths.add(Integer.toString(root.val));
		}
		
		List<String> left = binaryTreePaths(root.left);
		List<String> right = binaryTreePaths(root.right);
		
		if(root.left!=null){
			for(int i = 0; i<left.size(); i++){
				paths.add(Integer.toString(root.val)+"->"+left.get(i));
			}
		}
		if(root.right!=null){
			for(int j = 0; j<right.size(); j++){
				paths.add(Integer.toString(root.val)+"->"+right.get(j));
			}
		}
		
		return paths;
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
