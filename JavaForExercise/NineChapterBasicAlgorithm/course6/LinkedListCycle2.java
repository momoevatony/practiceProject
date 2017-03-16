package course6;

public class LinkedListCycle2 {
	
	//accepted 3.15.2017
	public ListNode detectCycle(ListNode head) {  
        // write your code here
        if(head == null || head.next == null) {return null;}
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next == null) {return null;}
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode entry = head;
        while(entry != slow.next) {
            entry = entry.next;
            slow = slow.next;
        }
        return entry;
    }
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		    val = x;
		    next = null;
		}
	}
}	
