package course4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RemoveSubstrings {

	//accepted 3.9.2017 9330ms
	public int minLength(String s, Set<String> dict) {
        // Write your code here
		if(s == null || s.length() == 0) {return 0;}
		int min = s.length();
		Queue<String> queue = new LinkedList<String>();
		Set<String> hash = new HashSet<String>();
		queue.offer(s);
		hash.add(s);
		
		while(!queue.isEmpty()) {
			String curr = queue.poll();
			for(String str : dict){
				int found = curr.indexOf(str);
				while(found != -1) {
					String next = curr.substring(0, found) + curr.substring(found + str.length(), curr.length());
					if(next.length() < min) {min = next.length();}
					if(!hash.contains(next)) {
						queue.offer(next);
						hash.add(next);
					}
					found = curr.indexOf(str, found+1);
				}
			}
		}
		
		return min;
    }
}
