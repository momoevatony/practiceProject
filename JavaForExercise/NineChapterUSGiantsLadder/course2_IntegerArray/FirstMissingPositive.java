package course2_IntegerArray;

public class FirstMissingPositive {
	
	//accepted 5.19.2017 3207ms
	public int firstMissingPositive(int[] A) {
        // write your code here    
        if (A == null || A.length == 0) {
            return 1;
        }
        
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != i + 1) {
                int temp = A[A[i] - 1];
                if (temp == A[i]) {
                    break;
                }
                A[A[i]- 1] = A[i];
                A[i] = temp;
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return ++i;
            }
        }
        
        return A.length + 1;
    }
}
