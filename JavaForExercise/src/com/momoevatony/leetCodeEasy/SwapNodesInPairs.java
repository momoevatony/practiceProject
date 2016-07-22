package com.momoevatony.leetCodeEasy;

import com.momoevatony.dataStructure.ListNode;

public class SwapNodesInPairs {
	
	public static void main (String args[]){
		ListNode l1 = new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		l1.next.next.next.next.next = new ListNode(6);
		ListNode temp = l1;
		ListNode l2 = swapPairs(l1);
		while(temp!=null){
			System.out.print(temp.val + " ");
			temp=temp.next;
		}
		System.out.println("Swaps as:");
		while(l2!=null){
			System.out.print(l2.val + " ");
			l2=l2.next;
		}
	}
	static ListNode swapPairs(ListNode head){
		if(head == null) {return null;}
		if(head.next == null) {return head;}
		ListNode curr = new ListNode(head.val);
		curr.next= swapPairs(head.next.next);
		head.next.next = curr;
		return head.next;
	}
}
