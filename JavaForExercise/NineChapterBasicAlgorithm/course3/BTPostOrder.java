package course3;

import java.util.ArrayList;

import course3.BTPreorder.TreeNode;

public class BTPostOrder {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null) {return list;}
		
		postOrder(list, root);
		
		return list;
    }
	
	private void postOrder(ArrayList<Integer> list, TreeNode root){
		if(root == null) {return;}

		postOrder(list, root.left);
		postOrder(list, root.right);
		list.add(root.val);
	}
}
