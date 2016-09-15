package com.momoevatony.leetCodeEasy;

import com.momoevatony.leetCodeMedium.FlatternBinaryTree.TreeNode;

public class InvertBinaryTree {
	//Accepted 9.14.2016
	public TreeNode invertTree(TreeNode root) {
        if(root == null) {return null;}
        
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        
        return root;
    }
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
