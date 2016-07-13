package com.momoevatony.leetCodeEasy;

import com.momoevatony.leetCodeEasy.VisitTree.TreeNode;

public class MaxDepOfTree {
	public static void main (String args[]){
		TreeNode node1 = new TreeNode (1);
		TreeNode node2 = new TreeNode (2);
		TreeNode node3 = new TreeNode (3);
		TreeNode node4 = new TreeNode (4);
		TreeNode node5 = new TreeNode (5);
		TreeNode node6 = new TreeNode (6);
		TreeNode node7 = new TreeNode (7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node4.left = node6;
		node6.left = node7;
		System.out.println(maxDepth(node1));
	}
	
	static int maxDepth(TreeNode node){
		return maxDepth(node, 1);
	}
	
	static int maxDepth(TreeNode node, int depth){
		System.out.println("Visiting Node: "+Integer.toString(node.data));
		if(node.left == null && node.right == null){return depth;}
		else if (node.right == null) {return maxDepth(node.left, depth+1);}
		else {return maxDepth(node.left, depth+1)>maxDepth(node.right, depth+1)? maxDepth(node.left, depth+1): maxDepth(node.right, depth+1);}
		
	}
}
