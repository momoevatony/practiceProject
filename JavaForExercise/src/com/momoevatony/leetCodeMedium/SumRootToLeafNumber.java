package com.momoevatony.leetCodeMedium;


public class SumRootToLeafNumber {
	
	//accepted 7.25.2016
	
	public int sumNumbers(TreeNode root) {
        if(root == null) {return 0;}
        if(root.left == null && root.right == null){return root.val;}
        if(root.val ==0){return sumNumbers(root.left)+sumNumbers(root.right);}
		return sumNumbers(root.left,root.val)+sumNumbers(root.right,root.val);
    }
	
	public int sumNumbers(TreeNode root, int curr){
		if(root==null){return 0;}
		curr = Integer.parseInt(Integer.toString(curr).concat(Integer.toString(root.val)));
		if(root.left == null && root.right == null){return curr;}
		return sumNumbers(root.left, curr)+ sumNumbers(root.right, curr);
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
