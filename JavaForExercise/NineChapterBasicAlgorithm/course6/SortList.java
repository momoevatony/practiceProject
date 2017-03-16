package course6;

public class SortList {
	
	//accepted 3.15.2017 2119ms
	public ListNode sortList(ListNode head) {  
        // write your code here
		if(head == null || head.next == null) {return head;}
		ListNode mid = findMid(head);

		ListNode right = sortList(mid.next);
		mid.next = null;
		ListNode left = sortList(head);
		
		return mergeSorted(left, right);
    }
	
	private ListNode mergeSorted(ListNode l1, ListNode l2) {
		if(l1 == null) {return l2;}
		if(l2 == null) {return l1;}
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;

		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
				curr = curr.next;
			}else {
				curr.next = l2;
				l2 = l2.next;
				curr = curr.next;
			}
		}
		
		if(l1 != null) {
			curr.next = l1;
		}else {
			curr.next = l2;
		}
		
		return dummy.next;
	}
	
	private ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
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
