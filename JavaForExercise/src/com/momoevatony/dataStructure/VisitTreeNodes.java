package com.momoevatony.dataStructure;

import com.momoevatony.dataStructure.TreeNode;
import java.util.Stack;

public class VisitTreeNodes {
	
	public static void main (String args[]){
		TreeNode root = new TreeNode (1);
		root.left = new TreeNode (2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode (4);
		root.right.left = new TreeNode (5);
		root.right.right = new TreeNode (6);
		root.right.left.left = new TreeNode (7);
		root.right.left.right = new TreeNode (8);
		root.right.right.right = new TreeNode (9);

		visitTreeNodesRecur(root,1);
		System.out.println();
		visitTreeNodePre(root);
		System.out.println();
		visitTreeNodesRecur(root,2);
		System.out.println();
		visitTreeNodeIn(root);
		
		
	}
	
	static void visitTreeNodesRecur (TreeNode root, int code){
		//1: pre-order; 2: in-order; 3: post-order;
		if (root == null){return;}
		if (code == 1){System.out.print(root.data);}
		visitTreeNodesRecur(root.left, code);
		if (code == 2){System.out.print(root.data);}
		visitTreeNodesRecur(root.right, code);
		if (code == 3){System.out.print(root.data);}
	}
	
	static void visitTreeNodePre (TreeNode root){
		Stack <TreeNode> stack = new Stack<TreeNode> ();
		stack.push(root);
		TreeNode curr = new TreeNode();
		while(!stack.isEmpty()){
			curr=stack.pop();
			System.out.print(curr.data);
			if(curr.right!=null){stack.push(curr.right);}
			if(curr.left!=null){stack.push(curr.left);}
		}
	}
	
	static void visitTreeNodeIn (TreeNode root){
		
		Stack <TreeNode> stack = new Stack<TreeNode> ();
		TreeNode curr = root;
		while(curr!=null || !stack.isEmpty()){
			while(curr!= null){
				stack.push(curr);
				curr=curr.left;
			}
			if (!stack.isEmpty()){
				curr=stack.pop();
				System.out.print(curr.data);
				curr=curr.right;
			}
		}
	}
	
	static void visitTreeNodePost (TreeNode root){
		//TODO 7/22/2016
	}
	
}
