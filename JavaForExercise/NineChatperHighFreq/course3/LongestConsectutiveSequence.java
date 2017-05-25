package course3;

import java.util.HashSet;

public class LongestConsectutiveSequence {
	
	/*
	 *	 Given [100, 4, 200, 1, 3, 2],
	 *	 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
	 */
	
	//accepted 5.24.2017 1419ms
	public int longestConsecutive(int[] num) {
        // write you code here
		HashSet<Integer> set = new HashSet<>();
		
		int result = 0;
		
		for (int i : num) {
			set.add(i);
		}
		
		for (int i = 0; i < num.length; i++) {
			int curr = num[i];
			int prev = curr - 1;
			while (set.contains(prev)) {
				set.remove(prev);
				prev--;
			}
			int next = curr + 1;
			while (set.contains(next)) {
				set.remove(next);
				next++;
			}
			
			result = Math.max(result, (next - prev - 1));
		}
		
		return result;
    }
}
