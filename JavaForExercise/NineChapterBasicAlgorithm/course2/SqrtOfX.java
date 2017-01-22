package course2;

public class SqrtOfX {
	
	//accepted 1.21.2017 1186ms
	public int sqrt(int x) {
        // write your code here
		if(x<=0){return 0;}
		long start = 1, end = x;
		while(start + 1<end){
			long mid = (end-start)/2 + start;
			if(mid*mid==x){
				return (int)mid;
			}else if(mid*mid<x){
				start = mid;
			}else{
				end = mid;
			}
		}
		if(end*end <=x){return (int)end;}
		return (int)start;
    }
}
