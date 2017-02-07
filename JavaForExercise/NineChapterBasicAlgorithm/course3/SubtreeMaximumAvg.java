package course3;

public class SubtreeMaximumAvg {
	
	//Accepted 2.6.2017 5414ms
	private double maxAvg = Integer.MIN_VALUE;
	private TreeNode result = null;
	
	public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
		getAvgAndCount(root);
		return result;
    }
	
	private AvgAndCount getAvgAndCount(TreeNode root){
		if(root == null){return new AvgAndCount(0,0);}
		AvgAndCount left = getAvgAndCount(root.left);
		AvgAndCount right = getAvgAndCount(root.right);
		
		int sum = root.val+left.sum+right.sum;
		int count = left.count+right.count+1;
		double avg = (double) sum / count;
		
		if(avg>maxAvg){
			maxAvg = avg;
			result = root;
		}
		return new AvgAndCount(sum,count); 
	}
	
	private class AvgAndCount{
		int sum;
		int count;
		public AvgAndCount(int sum, int count){
			this.sum = sum;
			this.count = count;
		}
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
