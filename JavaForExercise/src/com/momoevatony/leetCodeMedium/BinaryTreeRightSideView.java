package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeRightSideView {
	
	//Accepted 9.14.2016
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
        if(root == null){return list;}
        
        List<TreeNode> stack = new ArrayList<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
        	int size = stack.size();
        	list.add(stack.get(0).val);
        	while(size-->0){
        		TreeNode curr = stack.get(0);
        		if(curr.right!=null){stack.add(curr.right);}
        		if(curr.left!=null){stack.add(curr.left);}
        		stack.remove(0);
        	}
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
