package Others;

public class SegmentTreeQuery {
	
	
	//Accepted 11/29/2016 7671 ms
	public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
		if(start>root.end || end < root.start){return Integer.MIN_VALUE;}
		if(root.start>=start && root.end<=end){return root.max;}
		int leftMax = query(root.left, start, end);
		int rightMax = query(root.right, start, end);
		return leftMax>rightMax?leftMax:rightMax;
    }
	
	public class SegmentTreeNode {
	    public int start, end, max;
	    public SegmentTreeNode left, right;
	    public SegmentTreeNode(int start, int end, int max) {
	        this.start = start; this.end = end; this.max = max;
	        this.left = this.right = null;
	   }
	}
}
