package course6;

public class MedianOfTwoSortedArray {
	
	//Accepted 5.1.2017 1691ms
	public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here 
        
        if ((A.length + B.length) % 2 == 0) {
            return (findKth(A, 0, B, 0, (A.length + B.length) / 2 + 1) + findKth(A, 0, B, 0, (A.length + B.length) / 2)) / 2.0;
        } else {
            return findKth(A, 0, B, 0, (A.length + B.length) / 2 + 1);
        }
        
    }
    
    private int findKth (int[] A, int indexA, int[] B, int indexB, int k) {
        if (A.length <= indexA) {
            return B[indexB + k - 1];
        }
        
        if (B.length <= indexB) {
            return A[indexA + k - 1];
        }
        
        if (k == 1) {
            return Math.min(A[indexA], B[indexB]);
        }
        
        int pivotA = Integer.MAX_VALUE;
        int pivotB = Integer.MAX_VALUE;
        
        if (indexA + k / 2 - 1 < A.length) {
            pivotA = A[indexA + k / 2 - 1];
        }
        if (indexB + k / 2 - 1 < B.length) {
            pivotB = B[indexB + k / 2 - 1];
        }
        
        if (pivotA < pivotB) {
            indexA = indexA + k / 2;
        } else {
            indexB = indexB + k / 2;
        }
        
        return findKth(A, indexA, B, indexB, k - k / 2);
    }
}
