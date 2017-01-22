package course5;

public class LongestIncreasingContinueSubSeq {
	
	//Accetped 12.12.2016 9018ms
	public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if(A.length<=1){return A.length==1?1:0;}
        int max=0;
        int curr = 1, curr2=1;
        for(int i=1;i<A.length;i++){
            if(A[i] > A[i-1]){curr++; max = max>curr?max:curr;}
            else{curr = 1;}
            
            if(A[A.length-i-1]> A[A.length-i]){curr2++;max = max>curr2?max:curr2;}
            else{curr2 = 1;}
        }
        
        return max;
    }
}
