package course2;

public class FindPeakElement {
	
	//accepted 1.21.2017 1855ms
	public int findPeak(int[] A) {
        // write your code here
		int start = 0, end = A.length-1;
		while(start + 1 < end){
			int mid = (end - start) / 2 + start;
			
			if(A[mid] > A[mid-1] && A[mid] > A[mid+1]){return mid;}
			else if(A[mid]>A[mid-1]){
				start = mid;
			}else{
				end = mid;
			}
		}
		if(A[start] > A[start -1] && A[start] >A[start + 1]){return start;}
		
		return end;
    }
}
