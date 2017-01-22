package course2;

public class SearchInBigSortedArray {
	
	//accepted 1.21.2017 14795ms
	public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
		if(reader.get(0)>target){return -1;}
        int end = 1;
		while(reader.get(end) < target){
			end=end*2;
		}
		
		int start = 0;
		while(start+1<end){
			int mid = (end-start)/2+start;
			if(reader.get(mid) == target){
				end = mid;
			}else if(reader.get(mid) < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		
		if(reader.get(start) == target){return start;}
		if(reader.get(end) == target){return end;}
		
		return -1;
    }
	
	private class ArrayReader{
		public int get(int n){
			return 0;
		}
	}
}
