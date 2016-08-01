package com.momoevatony.leetCodeMedium;

public class RemoveDupFromSortedList2 {
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	//Accepted 7.31.2016
	public ListNode deleteDuplicates(ListNode head) {
		head = findNext(head);
		if(head==null || head.next == null){return head;}
		
		ListNode curr = head;
		while(curr.next!=null){
			curr.next = findNext(curr.next);
			if(curr.next == null){break;}
			curr = curr.next;
		}
        return head;
    }
	
	private ListNode findNext(ListNode head){
		if(head==null || head.next == null){return head;}
		while(head.next!= null && head.next.val == head.val){
            while(head.next != null && head.val == head.next.val){
            	head = head.next;
            }
        	if (head.next == null){return null;}
        	else {head = head.next;}
        }
		return head;
	}
}
