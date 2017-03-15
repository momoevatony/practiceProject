package course6;

public class InsertIntoCyclicSortedList {
	
	//accepted 3.14.2017 8328ms
	public ListNode insert(ListNode node, int x) {
        // Write your code here
		if(node == null){
            ListNode curr = new ListNode(x);
            curr.next = curr;
            return curr;
        }
        if(node.next == node) {
            node.next = new ListNode(x);
            node.next.next = node;
            return node;
        }
        
        ListNode dummy = new ListNode(0);
		dummy.next = node;
		ListNode curr = node;
		if(curr.val > x) {
		    while(curr.val < curr.next.val) {
		        curr = curr.next;
		        if(curr == dummy.next) {break;}
		    }
		    curr = curr.next;
		}
		
		while(curr.next.val < x) {
			curr = curr.next;
		    if(curr == dummy.next) {break;}
		}
		ListNode next = curr.next;
		curr.next = new ListNode(x);
		curr.next.next = next;
		
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
