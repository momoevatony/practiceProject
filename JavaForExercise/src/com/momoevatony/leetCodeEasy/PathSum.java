package com.momoevatony.leetCodeEasy;

import com.momoevatony.leetCodeEasy.VisitTree.TreeNode;

public class PathSum {

	public static void main (String args[]){
		TreeNode node1 = new TreeNode (1);
		TreeNode node2 = new TreeNode (2);
		TreeNode node3 = new TreeNode (3);
		TreeNode node4 = new TreeNode (4);
		TreeNode node5 = new TreeNode (5);
		TreeNode node6 = new TreeNode (6);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		System.out.println(sum(node1, 10, 0));
	}
	
	static boolean sum(TreeNode node, int sum){
		
		
		return false;
	}
	
	static boolean sum(TreeNode node, int finalSum, int currSum){
		
		if (node.left == null && node.right == null){
			return (finalSum == currSum+node.data); 
		} else if (node.left != null){
			if (!sum(node.left, finalSum, currSum+node.data)){
				return (node.right != null && sum(node.right, finalSum, currSum+node.data));
			}else{return true;}
		}
		else {return sum(node.right, finalSum, currSum+node.data);}
	}
	

}
