package com.momoevatony.leetCodeMedium;


public class InsertionSortList {
	
	//Accepted 8.30.2016
	public ListNode insertionSortList(ListNode head) {
		if(head==null || head.next ==null){return head;}
		if(head.val>head.next.val){
			ListNode next = head.next;
			head.next = next.next;
			next.next = head;
			head = next;
		}
		ListNode end = head.next;
		while(end.next!=null){
			ListNode key = end.next;
			if(key.val>=end.val){end=end.next;continue;}
			if(key.val<=head.val){end.next = key.next;key.next=head;head=key;continue;}
			
			ListNode pointer = head;
			ListNode prev = pointer;
			while(pointer!=key && pointer.val<key.val){
				prev = pointer;
				pointer=pointer.next;
			}
			end.next = key.next;
			prev.next = key;
			key.next = pointer;
		}
		
		
        return head;
    }
	
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
}
