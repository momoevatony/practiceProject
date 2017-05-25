package course2_IntegerArray;

public class SearchForRange {
	
	//accepted 5.23.2017 7719ms
	public int[] searchRange(int[] A, int target) {
        // write your code here
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		
		if (A == null || A.length == 0) {
			return result;
		}
		
		int start = 0;
		int end = A.length - 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if (A[start] == target) {
			result[0] = start;
		} else if (A[end] == target) {
			result[0] = end;
		}
		
		start = 0;
		end = A.length - 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (A[end] == target) {
			result[1] = end;
		} else if (A[start] == target) {
			result[1] = start;
		}
		
		return result;
    }
}
