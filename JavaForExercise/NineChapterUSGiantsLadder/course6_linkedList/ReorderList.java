package course6_linkedList;

public class ReorderList {
	
	//accepted 5.26.2017
	public void reorderList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode right = reverseList(slow.next);
        slow.next = null;
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        while (right != null) {
            ListNode leftNext = head.next;
            ListNode rightNext = right.next;
            head.next = right;
            right.next = leftNext;
            head = leftNext;
            right = rightNext;
        }
        
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
