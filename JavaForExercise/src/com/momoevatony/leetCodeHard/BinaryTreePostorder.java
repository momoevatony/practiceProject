package com.momoevatony.leetCodeHard;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorder {
	
	//Accepted 9.14.2016
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root==null){return list;}
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
        	while(curr!=null){
        		TreeNode temp = curr.left;
        		curr.left = null;
        		stack.push(curr);
        		curr=temp;
        	}
        	if(!stack.isEmpty()){
        		curr=stack.pop();
        		if(curr.right != null){
        			TreeNode temp = curr.right;
        			curr.right = null;
        			stack.push(curr);
        			curr=temp;
        			continue;
        		}else{
        			list.add(curr.val);
        			if(stack.isEmpty()){break;}
        			curr = stack.pop();
        		}
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
