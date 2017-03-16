package course6;

public class LinkedListCycle {
	
	//accepted 3.15.2017
	public boolean hasCycle(ListNode head) {  
        // write your code here
        if(head == null || head.next == null) {return false;}
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next == null) {return false;}
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
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
