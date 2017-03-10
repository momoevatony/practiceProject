package course4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertBTtoLLbyDepth {
	
	//Accepted 3.9.2017 8897ms
	public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
		List<ListNode> list = new ArrayList<ListNode>();
		if(root == null) {return list;}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			TreeNode curr = queue.poll();
			ListNode listNode = new ListNode(curr.val);
			list.add(listNode);
			if(curr.left != null) {queue.offer(curr.left);}
			if(curr.right != null) {queue.offer(curr.right);}
			for(int i = 1; i < size; i++) {
				curr = queue.poll();
				listNode.next = new ListNode(curr.val);
				listNode = listNode.next;
				if(curr.left != null) {queue.offer(curr.left);}
				if(curr.right != null) {queue.offer(curr.right);}
			}
		}
		
		return list;
    }
	
	public class TreeNode {
	    public int val;
	    public TreeNode left, right;
	    public TreeNode(int val) {
	        this.val = val;
	        this.left = this.right = null;
	    }
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
