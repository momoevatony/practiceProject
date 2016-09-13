package com.momoevatony.leetCodeEasy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2 {
	
	//Accepted 9.12.2016
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root==null) {return list;}
        
		levelOrderDP(root,list,0);
		Collections.reverse(list);
		return list;
    }
	
	private void levelOrderDP (TreeNode root, List<List<Integer>> list, int depth){
		List<Integer> innerList = new ArrayList<Integer>();
		if (depth < list.size()){
			innerList = list.get(depth);
			innerList.add(root.val);
		}else{
			innerList.add(root.val);
			list.add(innerList);
		}
		if(root.left!=null){levelOrderDP(root.left,list,depth+1);}
		if(root.right!=null){levelOrderDP(root.right,list,depth+1);}
	}
	
	
	//slower but makes more sense I think...Accepted 9.12.2016
	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root==null) {return list;}
		
		List<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			List<List<Integer>> newList = new ArrayList<List<Integer>>();
			List<Integer> innerList = new ArrayList<Integer>();
			int size = queue.size();
			while(size-->0){
				TreeNode curr = queue.get(0);
				innerList.add(curr.val);
				if(curr.left!=null){queue.add(curr.left);}
				if(curr.right!=null){queue.add(curr.right);}
				queue.remove(0);
			}
			newList.add(innerList);
			newList.addAll(list);
			list = newList;
		}
        
		return list;
    }
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
