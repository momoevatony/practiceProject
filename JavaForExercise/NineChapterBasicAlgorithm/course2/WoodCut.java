package course2;

public class WoodCut {
	
	//Accepted 1.21.2017 2116ms
	public int woodCut(int[] L, int k) {
        // write your code here
		int start = 0, end = arrayMax(L);
		while(start + 1 < end){
			int mid = (end - start) / 2 + start;
			if(isValid(L,mid,k)){
				start = mid;
			}else{
				end = mid;
			}
		}
		if(isValid(L, end, k)){return end;}
		
		return start;
    }
	
	private int arrayMax(int[] L){
		int max = Integer.MIN_VALUE;
		for(int i=0; i<L.length-1;i++){
			if(L[i]>max){max = L[i];}
		}
		return max;
	}
	
	private boolean isValid(int[] L, int length, int k){
		int pieces = 0;
		for(int i=0; i<L.length; i++){
			pieces += (L[i] / length);
		}
		return (pieces>=k);
	}
}
