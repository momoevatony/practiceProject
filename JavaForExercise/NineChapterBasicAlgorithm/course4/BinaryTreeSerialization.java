package course4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialization {
	
	//NEEDS REDO
	//accepted 3.8.2017 1561ms
	public String serialize(TreeNode root) {
        // write your code here
		if(root==null){return "{}";}
		
		ArrayList<TreeNode> list = new ArrayList<>();
		list.add(root);
		int index = 0;
		while(index<list.size()){
			TreeNode curr = list.get(index);
			if(curr!=null){
				list.add(curr.left);
				list.add(curr.right);
			}
			index++;
		}
		index--;
		while(list.get(index) == null){
			index--;
		}

		StringBuilder sb = new StringBuilder();
		TreeNode curr = list.get(0);
		sb.append("{"+curr.val);
		for(int i = 1; i <= index; i++){
			curr = list.get(i);
			if(curr!=null){
				sb.append(","+curr.val);
			}else{
				sb.append(",#");
			}
		}
		sb.append("}");
		return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
    	if(data.equals("{}")){return null;}
    	String[] vals = data.substring(1,data.length()-1).split(",");
    	TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
    	ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
    	queue.add(root);
    	
    	int index = 0;
    	boolean isLeftChild = true;
    	
    	for(int i=1; i<vals.length; i++){
    		if(!vals[i].equals("#")){
    			TreeNode child = new TreeNode(Integer.parseInt(vals[i]));
    			
    			if(isLeftChild){
    				queue.get(index).left = child;
    			}else{
    				queue.get(index).right = child;
    			}
    			queue.add(child);
    		}
    		if(!isLeftChild){
    			index++;
    		}
    		isLeftChild = !isLeftChild;
    	}
    	
    	return root;
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
