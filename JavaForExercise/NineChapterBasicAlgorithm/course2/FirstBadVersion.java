package course2;

public class FirstBadVersion {
	
	//accetped 1.21.2017 1272ms
	public int findFirstBadVersion(int n) {
        // write your code here
		if(n<0){return 1;}
		int start = 1, end = n;
		while(start + 1 < end){
			int mid = (end - start) / 2 + start;
			if(isBadVersion(mid)){
				end = mid;
			}else{
				start = mid;
			}
		}
		
		if(isBadVersion(start)){return start;}
		if(isBadVersion(end)){return end;}
		
		return 1;
    }
	
	private boolean isBadVersion(int n){
		return true;
	}
}
