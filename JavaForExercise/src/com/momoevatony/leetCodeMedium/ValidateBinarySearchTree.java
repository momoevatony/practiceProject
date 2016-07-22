package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Stack;

import com.momoevatony.dataStructure.TreeNode;

public class ValidateBinarySearchTree {
	
	public static void main (String args[]){
		TreeNode root = new TreeNode (10);
		root.left = new TreeNode (5);
		root.right = new TreeNode (15);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(20);
		
		System.out.println(isValidBST2(root));
		
	}
	
	
	//the following method is totally wrong!!!!!!!
	//Stupid mistake made on 7/21/2016
	public static boolean isValidBST(TreeNode root) {
		if(root == null){return false;}
		if(root.left ==null && root.right ==null) {return true;}
		
		ArrayList <TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		int index = 0;
		TreeNode curr= new TreeNode();
		
		while (index<list.size()){
			curr = list.get(index);
			if(curr.left != null) {
				if (curr.left.data > curr.data) {return false;}
				list.add(curr.left);
			}
			if(curr.right!= null){
				if (curr.right.data < curr.data) {return false;}
				list.add(curr.right);
			}
			index++;
		}
		
		return true;
    }
	
	public static boolean isValidBST2(TreeNode root) {
		Stack <TreeNode> stack = new Stack<TreeNode>();
		Stack <Integer> values = new Stack<Integer>();
		TreeNode curr = root;
		int check;
		while(!stack.isEmpty() || curr!=null){
			while(curr!=null){
				stack.push(curr);
				curr=curr.left;
			}
			if(!stack.isEmpty()){
				curr=stack.pop();
				System.out.print(curr.data+ " ");
				if(!values.isEmpty() && curr.data<values.peek()){return false;}
				values.push(curr.data);
				curr=curr.right;
			}
		}
		return true;
	}

}
