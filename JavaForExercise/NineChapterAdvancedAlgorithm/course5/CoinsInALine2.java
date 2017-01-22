package course5;

public class CoinsInALine2 {
	
	//accepted 12.16.2016 1291ms
	public boolean firstWillWin(int[] values) {
        // write your code here
		if(values.length<=2){return true;}
		int[] sum = new int[values.length];
		int[] maxSum = new int[values.length];
		
		sum[sum.length-1] = values[values.length-1];
		sum[sum.length-2] = values[values.length-1]+values[values.length-2];
		maxSum[maxSum.length-1] = values[values.length-1];
		maxSum[maxSum.length-2] = values[values.length-1]+values[values.length-2];
		
		for(int i=values.length-3;i>=0;i--){
			sum[i] = sum[i+1]+values[i];
			maxSum[i] = Math.max(sum[i] - maxSum[i+1], sum[i] - maxSum[i+2]);
		}
		
		return maxSum[0] > (sum[0]/2);
    }
}
