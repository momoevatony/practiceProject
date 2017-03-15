package course6;

public class MergeTwoSortedList {
	
	//accepted 3.14.2017 18356ms
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
		if(l1 == null) {return l2;}
		if(l2 == null) {return l1;}
		
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			}else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		if(l1 == null) {
			curr.next = l2;
		}
		if(l2 == null) {
			curr.next = l1;
		}
		
		return dummy.next;
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
