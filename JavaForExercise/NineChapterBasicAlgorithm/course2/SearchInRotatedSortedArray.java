package course2;

public class SearchInRotatedSortedArray {
	
	//accepted 2440ms
	public int search(int[] A, int target) {
        // write your code here
		if(A==null || A.length<=0){return -1;}
		int start = 0, end = A.length-1;
		while(start + 1 < end){
			int mid = (end - start) / 2 + start;
			
			if(A[mid] == target){return mid;}
			
			if(A[mid] < A[start]){
				if(A[mid]<target && A[end]>=target){
					start = mid;
				}else{
					end = mid;
				}
			}else{
				if(A[mid]>target && A[start]<=target){
					end = mid;
				}else{
					start = mid;
				}
			}
		}
		if(A[start] == target) {return start;}
		if(A[end] == target) {return end;}
		return -1;
    }
}
