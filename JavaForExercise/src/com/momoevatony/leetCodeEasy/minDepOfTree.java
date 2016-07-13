package com.momoevatony.leetCodeEasy;

import java.util.ArrayList;

import com.momoevatony.leetCodeEasy.VisitTree.TreeNode;

public class minDepOfTree {
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
		node4.left = node6;
		System.out.println(minDepth(node1));
	}
	
	static int minDepth (TreeNode node){
		
		int depth = 0;
		int index = 0;
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		list.add(node);
		while (index < list.size()){
			TreeNode curr = list.get(index);
			System.out.println("Visiting node: "+Integer.toString(curr.data));
			if(curr.left == null || curr.right ==null) {return depth;}
			list.add(curr.left);
			list.add(curr.right);
			index++;
			depth++;
		}
		
		return depth;
	}

}
