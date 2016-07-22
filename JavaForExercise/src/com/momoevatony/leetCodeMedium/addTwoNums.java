package com.momoevatony.leetCodeMedium;

import java.util.Arrays;
import com.momoevatony.dataStructure.ListNode;

public class addTwoNums {
	public static void main (String args[]){
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);
		l1.next=new ListNode(4);
		l1.next.next = new ListNode(3);
		l2.next=new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = addTwoNumbers(l1,l2);
		
		while(l1!=null){
			System.out.print(l1.val + " ");
			l1=l1.next;
		}
		System.out.println("plus");
		while(l2!=null){
			System.out.print(l2.val + " ");
			l2=l2.next;
		}
		System.out.println("equals");
		while(l3!=null){
			System.out.print(l3.val + " ");
			l3=l3.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 ==null) {return null;}
		if(l1 == null || l2 ==null) {return l1==null ? l2:l1;}
		
        ListNode head = new ListNode(0);
        ListNode curr = new ListNode((l1.val+l2.val)%10);
        head.next = curr;
        int l1Num, l2Num, newNum;
        int carry=(l1.val+l2.val)>= 10?1:0;
        while(l1.next != null || l2.next != null){
        	l1 = l1.next!=null? l1.next: new ListNode(0);
        	l2 = l2.next!=null? l2.next: new ListNode(0);
        	newNum = (l1.val + l2.val + carry);
        	carry = newNum>=10?1:0;
        	curr.next = new ListNode(newNum%10);
        	curr=curr.next;
        }
        head = head.next;
        return head;
    }
	 
	
}
