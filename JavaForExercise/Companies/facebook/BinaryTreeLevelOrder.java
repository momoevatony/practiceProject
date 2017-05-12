package facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import course4.ConvertBTtoLLbyDepth.TreeNode;

public class BinaryTreeLevelOrder {
	
	//accepted 5.11.2017 1959ms
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        if (root == null) {
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                innerList.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            list.add(new ArrayList<Integer>(innerList));
        }
        
        return list;
    }
}
