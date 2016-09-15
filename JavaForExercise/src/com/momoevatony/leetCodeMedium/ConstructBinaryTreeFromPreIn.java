package com.momoevatony.leetCodeMedium;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreIn {
	
	//Accepted 9.14.2016
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length!=inorder.length || preorder.length==0){return null;}
		
		return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
	
	private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
		if(preStart > preEnd) {return null;}
		if(preStart == preEnd){return new TreeNode(preorder[preStart]);}
		TreeNode root = new TreeNode(preorder[preStart]);
		int leftSize = 0;
		for (int i=inStart; i<=inEnd;i++){
			if(root.val == inorder[i]){break;}
			leftSize++;
		}
		
		root.left = buildTree(preorder, inorder, preStart+1, preStart+leftSize, inStart, inStart+leftSize-1);
		root.right = buildTree(preorder, inorder, preStart+1+leftSize, preEnd,inStart+leftSize+1,inEnd);

		return root;
	}
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
