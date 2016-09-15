package com.momoevatony.leetCodeMedium;

public class ConstructBinaryTreeFromInPost {
	
	//Accepted 9.14.2016
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder.length!=inorder.length || inorder.length==0){return null;}
		
		return buildTree(postorder, inorder, 0, postorder.length-1, 0, inorder.length-1);
    }
	
	private TreeNode buildTree(int[] postorder, int[] inorder, int postStart, int postEnd, int inStart, int inEnd){
		if(postStart > postEnd) {return null;}
		if(postStart == postEnd){return new TreeNode(postorder[postEnd]);}
		TreeNode root = new TreeNode(postorder[postEnd]);
		int leftSize = 0;
		for (int i=inStart; i<=inEnd;i++){
			if(root.val == inorder[i]){break;}
			leftSize++;
		}
		
		root.left = buildTree(postorder, inorder, postStart, postStart+leftSize-1, inStart, inStart+leftSize-1);
		root.right = buildTree(postorder, inorder, postStart+leftSize, postEnd-1,inStart+leftSize+1,inEnd);

		return root;
	}
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
