package course3;

import java.util.ArrayList;

import course3.BTPreorder.TreeNode;

public class BTInorder {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null) {return list;}
		
		inOrder(list, root);
		
		return list;
    }
	
	private void inOrder(ArrayList<Integer> list, TreeNode root){
		if(root == null) {return;}

		inOrder(list, root.left);
		list.add(root.val);
		inOrder(list, root.right);
	}

}
