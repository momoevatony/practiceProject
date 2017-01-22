package course1;

import java.util.Arrays;

public class TriangleCount {
	
	//Accepted 11/21/2016 1738 ms
	public int triangleCount(int S[]) {
        // write your code here
        Arrays.sort(S);
        int result =0;
        for(int i = S.length-1;i>=2;i--){
            int left = 0;
            int right = i-1;
            while(left < right){
                int sum = S[left]+S[right];
                if(sum > S[i]){
                    result += right-left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }
}
