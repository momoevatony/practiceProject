package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
	public BSTIterator(TreeNode root) {
        visitInOrder(root);
    }
	
	private List<Integer> queue = new ArrayList<Integer>();
	private int queueIndex=0;
	
	private void visitInOrder(TreeNode root){
		if(root == null){return;}
		visitInOrder(root.left);
		queue.add(root.val);
		visitInOrder(root.right);
	}

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (queueIndex>=queue.size());
    }

    /** @return the next smallest number */
    public int next() {
    	queueIndex++;
        return queue.get(queueIndex);
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
