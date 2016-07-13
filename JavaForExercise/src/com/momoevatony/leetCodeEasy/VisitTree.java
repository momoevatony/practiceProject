package com.momoevatony.leetCodeEasy;

import java.util.ArrayList;

public class VisitTree {
	
	static class TreeNode {
		TreeNode left = null;
		TreeNode right = null;
		int data;
		boolean visitied = false;
		
		public TreeNode (int data){
			this.left = null;
			this.right = null;
			this.data = data;
		}
	}
	
	public static void main (String args[]){
		TreeNode node1 = new TreeNode (1);
		TreeNode node2 = new TreeNode (2);
		TreeNode node3 = new TreeNode (2);
		TreeNode node4 = new TreeNode (3);
		TreeNode node5 = new TreeNode (3);
		TreeNode node6 = new TreeNode (3);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		
		visitTree(node1);
		System.out.println(compareSymmetric(node1));
	}

	
	static void visitTree(TreeNode node1){
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		list.add(node1);
		int listIndex = 0;
		
		while(!list.isEmpty() && listIndex < list.size()){
			TreeNode curr = list.get(listIndex);
			System.out.println(curr.data);
			
			if(curr.left!=null){list.add(curr.left);}
			if(curr.right!=null){list.add(curr.right);}
			
			listIndex ++;
		}
	}
	
	static boolean compareSymmetric (TreeNode node1){
		ArrayList<TreeNode> leftList = new ArrayList<TreeNode>();
		ArrayList<TreeNode> rightList = new ArrayList<TreeNode>();
		int listIndex = 0;
		
		leftList.add(node1);
		rightList.add(node1);
		
		while(listIndex < leftList.size()){
			TreeNode leftCurr = leftList.get(listIndex);
			TreeNode rightCurr = rightList.get(listIndex);
			System.out.println("comparing ".concat(Integer.toString(leftCurr.data)).concat(" and ").concat(Integer.toString(rightCurr.data)));
			if(leftCurr.data != rightCurr.data || !(leftCurr.left == null ^ rightCurr.right==null) || !(leftCurr.right == null ^ rightCurr.left==null)) {return false;}
			
			if(leftCurr.left!=null){leftList.add(leftCurr.left);}
			if(leftCurr.right!=null){leftList.add(leftCurr.right);}
			
			if(rightCurr.right!=null){rightList.add(rightCurr.right);}
			if(rightCurr.left!=null){rightList.add(rightCurr.left);}
			
			listIndex++;
		}
		
		return true;
	}
	
	static void visitTree2(TreeNode node1){
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		list.add(node1);
		int listIndex = 0;
		
		while(!list.isEmpty() && listIndex < list.size()){
			TreeNode curr = list.get(listIndex);
			
			if(curr.left!=null){list.add(curr.left);}
			if(curr.right!=null){list.add(curr.right);}
			
			listIndex ++;
		}
	}
	
}
