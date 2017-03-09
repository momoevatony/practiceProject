package course2;

public class ClosestNumInSortedArray {
	
	//Accepted 3.8.2017 17937ms
	public int closestNumber(int[] A, int target) {
        // Write your code here
		int start = 0;
		int end = A.length-1;
		int mid;
		
		while(start+1<end){
			mid = (end-start)/2+start;
			
			if(A[mid]==target){
				return mid;
			}else if (A[mid]<target){
				start = mid;
			}else{
				end = mid;
			}
		}
		
		return Math.abs(A[start]-target) < Math.abs(A[end]-target)?start:end;
    }
}
