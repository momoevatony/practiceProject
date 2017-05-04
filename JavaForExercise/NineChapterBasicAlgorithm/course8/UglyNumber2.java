package course8;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumber2 {
	public int nthUglyNumber(int n) {
        // Write your code here
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        Long[] factors = {2L, 3L, 5L};
        queue.add(1L);
        set.add(1L);
        Long curr = 1L;
        
        for (int i = 0; i < n; i++) {
            curr = queue.poll();
            set.remove(curr);
            
            for(int j = 0; j < factors.length; j++) {
                Long next = curr * factors[j];
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
        
        return curr.intValue();
    }
}
