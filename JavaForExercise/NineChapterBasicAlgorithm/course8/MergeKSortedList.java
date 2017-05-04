package course8;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
	
	//Accepted 5.3.2017 2994ms
	public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists == null || lists.size() == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(!heap.isEmpty()) {
            ListNode top = heap.poll();
            curr.next = top;
            curr = top;
            if(top.next != null) {
                heap.add(top.next);
            }
        }
        
        return dummy.next;
    }
    
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode first, ListNode second) {
            return first.val - second.val;
        }
    };
    
    public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		    val = x;
		    next = null;
		}
	}
}
