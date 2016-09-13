package com.momoevatony.leetCodeEasy;

import java.util.ArrayList;
import java.util.List;

import com.momoevatony.leetCodeEasy.VisitTree.TreeNode;

public class minDepOfTree {
	
	//Accepted 9.12.2016
	public int minDepth(TreeNode root) {
        if(root==null){return 0;}
        int depth = 0;
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int size = queue.size();
        	while(size-->0){
        		TreeNode curr = queue.get(0);
        		if(curr.left==null && curr.right==null){return depth+1;}
        		if(curr.left!=null){queue.add(curr.left);}
        		if(curr.right!=null){queue.add(curr.right);}
        		queue.remove(0);
        	}
        	depth++;
        }
        return depth;
    }
}
