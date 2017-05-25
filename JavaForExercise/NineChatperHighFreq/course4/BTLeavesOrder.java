package course4;

import java.util.ArrayList;
import java.util.List;

public class BTLeavesOrder {
	
	//accepted 5.24.2017 11610ms
	public List<List<Integer>> findLeaves(TreeNode root) {
        // Write your code here
        List<List<Integer>> list = new ArrayList<>();
        
        if (root == null) {
            return list;
        }
        
        dfs(list, root);
        return list;
    }
    
    private int dfs (List<List<Integer>> list, TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            if (list.size() == 0) {
                List<Integer> innerList = new ArrayList<>();
                innerList.add(root.val);
                list.add(new ArrayList<>(innerList));
            } else {
                List<Integer> innerList = list.get(0);
                innerList.add(root.val);
            }
            return 1;
        }
        
        int leftLevel = dfs(list, root.left);
        int rightLevel = dfs(list, root.right);
        
        int level = Math.max(leftLevel, rightLevel);
        if (list.size() <= level) {
            List<Integer> innerList = new ArrayList<>();
            innerList.add(root.val);
            list.add(new ArrayList<>(innerList));
        } else {
            List<Integer> innerList = list.get(level);
            innerList.add(root.val);
        }
        
        return level + 1;
    }
    
    public class TreeNode {
	    public int val;
	    public TreeNode left, right;
	    public TreeNode(int val) {
	        this.val = val;
	        this.left = this.right = null;
	    }
	}
}
