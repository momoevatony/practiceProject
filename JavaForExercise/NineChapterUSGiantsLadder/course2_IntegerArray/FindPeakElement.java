package course2_IntegerArray;

public class FindPeakElement {
	
	//accepted 5.23.2017 1493ms
	public int findPeak(int[] A) {
        // write your code here
		int start = 0;
		int end = A.length - 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return mid;
			}else if (A[mid] > A[mid - 1]) {
				start = mid;
			}else {
				end = mid;
			}
		}
		
		return -1;
    }
}
