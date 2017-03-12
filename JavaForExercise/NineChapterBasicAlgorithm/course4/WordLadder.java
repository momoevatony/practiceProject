package course4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	//accepted 3.10.2017 2956ms
	public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
		if(start.length() ==0 || end.length() == 0) {return 0;}
        if(start.equals(end)) {return 1;}
		int length = 1;
		Queue<String> queue = new LinkedList<String>();
		Set<String> hash = new HashSet<String>();
		queue.offer(start);
		hash.add(start);
		
		while(!queue.isEmpty()){
			length++;
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				String curr = queue.poll();
				for(int index = 0; index < curr.length(); index++){
					for(char ch = 'a'; ch < 'z'; ch++){
						String next = curr.substring(0, index) + ch + curr.substring(index+1, curr.length());
						if(!next.equals(start) && next.equals(end)) {return length++;}
						if(!hash.contains(next) && dict.contains(next)){
							queue.offer(next);
							hash.add(next);
						}
					}
				}
			}
		}
		return 0;
    }
	
	/*
	private boolean oneEditAway(String a, String b){
		if(a.length() != b.length() || a.equals(b)){return false;}
		boolean foundOne = false;
		for (int i=0; i<a.length(); i++){
			if(a.charAt(i) != b.charAt(i)){
				if(foundOne) {return false;}
				foundOne = true;
			}
		}
		return true;
	}
	*/
}
