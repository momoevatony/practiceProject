package com.momoevatony.leetCodeEasy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	
	//Accepted 9.12.2016
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root==null) {return list;}
        
		levelOrderDP(root,list,0);
		
		return list;
    }
	
	private void levelOrderDP (TreeNode root, List<List<Integer>> list, int depth){
		List<Integer> innerList = new ArrayList<Integer>();
		if (depth < list.size()){
			innerList = list.get(depth);
			innerList.add(root.val);
		}else{
			innerList.add(root.val);
			list.add(innerList);
		}
		if(root.left!=null){levelOrderDP(root.left,list,depth+1);}
		if(root.right!=null){levelOrderDP(root.right,list,depth+1);}
	}
	
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
