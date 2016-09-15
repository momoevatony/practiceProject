package com.momoevatony.leetCodeMedium;

public class FlatternBinaryTree {
	//Accetped 9.14.2016
	public void flatten(TreeNode root) {
        if(root==null || (root.left==null&&root.right==null)){return;}
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left=null;
        while(root.right!=null){root = root.right;}
        root.right = temp;
    }
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
