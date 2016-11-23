package course1;

import java.util.Arrays;
import java.util.Collections;


public class SegmentTreeBuild2 {
	
	//Accepted 11/22/2016 4571 ms
	public SegmentTreeNode build(int[] A) {
        // write your code here
		if (A.length==0){return null;}
		return build(A,0,A.length-1);
    }
	
	public SegmentTreeNode build(int[]A, int start, int end){
		if (start>end){return null;}
		if (start==end){return new SegmentTreeNode(start,end,A[start]);}
		int[]B = Arrays.copyOfRange(A, start, end+1); Arrays.sort(B);
		SegmentTreeNode root = new SegmentTreeNode(start,end,B[B.length-1]);
		int mid = (start+end)/2;
		root.left = build(A, start,mid);
		root.right = build(A, mid+1,end);
		return root;
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
