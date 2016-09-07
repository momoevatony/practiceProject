package com.momoevatony.leetCodeMedium;


public class ReverseLinkedList2 {

	//accepted 8.31.2016
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || head.next == null || m==n){return head;}
		
		ListNode start = head;
		ListNode startPrev = null;
		ListNode end = head;
		ListNode endNext = null;
		for(int i=1;i<n;i++){
			if(i<m){startPrev=start;start=start.next;}
			end = end.next;
			endNext = end.next;
		}
		
		ListNode prev = endNext;
		ListNode curr = start;
		while(prev!=end){
			ListNode next=curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		if(startPrev ==null){return prev;}
		startPrev.next = prev;
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
