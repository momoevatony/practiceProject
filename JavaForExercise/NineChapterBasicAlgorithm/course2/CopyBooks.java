package course2;

public class CopyBooks {
	
	//Accepted 1.22.2017 1372ms
	public int copyBooks(int[] pages, int k) {
        // write your code here
		int[] arrayInfo = arrayMaxAndSum(pages);
		int start = arrayInfo[0], end = arrayInfo[1];
		
		while(start + 1 < end){
			int mid = (end - start) / 2 + start;
			
			if(valid(pages, mid, k)){
				start = mid;
			}else{
				end = mid;
			}
		}
		if(valid(pages, end, k)){return end;}
		
		return start;
    }
	
	private int[] arrayMaxAndSum(int[] input){
		int max[] = {Integer.MIN_VALUE,0};
		for(int i : input){
			max[0] = max[0]>i?max[0]:i;
			max[1]+=i;
		}
		return max;
	}
	
	private boolean valid(int[] pages, int time, int k){
		int count = 1;
		int curr = 0;
		for(int i=0; i<pages.length; i++){
			if(pages[i]+curr <= time){
				curr+=pages[i];
			}else{
				count++;
				curr = pages[i];
			}
		}
		
		return count<=k;
	}
}
