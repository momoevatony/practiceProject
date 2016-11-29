package Others;

public class SegmentTreeBuild {
	
	//Accepted 11/22/2016 3267 ms
	public SegmentTreeNode build(int start, int end) {
        // write your code here
		if(start>end){return null;}
		SegmentTreeNode root = new SegmentTreeNode (start, end);
		if(start!=end){
			int mid = (start+end)/2;
			root.left = build(start, mid);
			root.right = build(mid+1,end);
		}
		return root;
    }
	
	public class SegmentTreeNode {
	    public int start, end;
	    public SegmentTreeNode left, right;
	    public SegmentTreeNode(int start, int end) {
	        this.start = start; this.end = end;
	        this.left = this.right = null;
	   }
	}
}
