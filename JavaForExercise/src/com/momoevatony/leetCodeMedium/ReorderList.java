package com.momoevatony.leetCodeMedium;

public class ReorderList {
	
	//Accepted 8.30.2016
	public void reorderList(ListNode head) {
		if(head==null || head.next==null){return;}
		//find the cut point (Mid)
		ListNode fast = head;
		ListNode slow = head;
		ListNode midEnd = null;
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			midEnd = slow;
			slow=slow.next;
		}
		//System.out.println("cutting in mid at node: "+midEnd.val);
		midEnd.next=null;
		
		//reverse the second half and merge the two lists
		ListNode secondPointer = reverseList(slow);
		ListNode firstPointer = head;
		while(secondPointer!=null){
			//System.out.println("working on first: "+firstPointer.val+" and second: "+secondPointer.val);
			ListNode firstNext = firstPointer.next;
			ListNode secondNext = secondPointer.next;
			firstPointer.next = secondPointer;
			firstPointer = firstNext;
			if(firstPointer == null){break;}
			secondPointer.next = firstPointer;
			secondPointer = secondNext;
		}
		
    }
	
	public ListNode reverseList(ListNode head){
		ListNode prev = null;
		ListNode curr = head;
		while(curr!=null){
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
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
