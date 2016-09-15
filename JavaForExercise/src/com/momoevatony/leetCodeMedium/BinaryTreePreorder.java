package com.momoevatony.leetCodeMedium;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorder {
	//Accepted 9.14.2016
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
        if(root == null){return list;}
        
        Stack <TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode curr = stack.pop();
        	list.add(curr.val);
        	if(curr.right!=null){stack.push(curr.right);}
        	if(curr.left!=null){stack.push(curr.left);}
        }
        
		return list;
    }
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
