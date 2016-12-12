package course4;

public class MinimumWindowSubstring {
	
	//Accetped 12.11.2016 2571ms
	public String minWindow(String source, String target) {
        // write your code
		boolean[]ref = new boolean[256];
		int[] map = new int[256];
		for(int i=0;i<target.length();i++){
			ref[target.charAt(i)]=true;
			map[target.charAt(i)]++;
		}
		
		String ans="";
		int length = Integer.MAX_VALUE;
		int slow=0, fast=0;
		
		for(;slow<source.length();slow++){
			while(fast<source.length()){
				if(isEmpty(map)){
					break;
				}
				if(ref[source.charAt(fast)]){
					map[source.charAt(fast)]--;
				}
				fast++;
			}
			
			if(length>fast-slow && isEmpty(map)){
			    length=fast-slow;
			    ans=source.substring(slow,fast);
			}
			if(ref[source.charAt(slow)]){
				map[source.charAt(slow)]++;
			}
		}
		return ans;
    }
	
	private boolean isEmpty(int[] map){
		for(int i=0;i<map.length;i++){
			if(map[i]>0){return false;}
		}
		return true;
	}
}
