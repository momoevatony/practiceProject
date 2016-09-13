package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzag {
	
	//Accepted 9.12.2016
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root==null){return list;}
		boolean flag = false;
		List<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> innerList = new ArrayList<Integer>();
			while(size-->0){
				TreeNode curr = queue.get(0);
				innerList.add(curr.val);
				if(curr.left!=null){queue.add(curr.left);}
				if(curr.right!=null){queue.add(curr.right);}
				queue.remove(0);
			}
			if(flag){Collections.reverse(innerList);}
			flag=!flag;
			list.add(innerList);
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
