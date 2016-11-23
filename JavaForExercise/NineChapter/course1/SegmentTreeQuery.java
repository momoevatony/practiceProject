package course1;

public class SegmentTreeQuery {
	
	public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
		if(start>root.end || end < root.start){return Integer.MAX_VALUE;}
		if(root.start>=start && root.end<=end){return root.max;}
		
		int mid = (root.start+root.end)/2;
		//TODO
		return -1;
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
