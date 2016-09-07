package com.momoevatony.leetCodeEasy;

public class RemoveNthNodeFromList {
	
	static class Node {
		Node next = null;
		int data;
		
		public Node (int data){
			this.next = null;
			this.data = data;
		}
	}
	
	public static void main(String args[]){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(3);
		Node node5 = new Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		print (node1);
		System.out.println();
		//print (removeNth (node1, 3));
		System.out.println();
		print (removeDuplicate (node1));
	}
	
	//Accepted 9.6.2016
	public static Node removeNth (Node head, int n){
		if (head == null) {return null;}
		
		Node slow = head;
		Node fast = head;
		
		for (int i=0; i<n; i++){
			fast = fast.next;
		}
		if (fast == null){
			return head.next;
		}
		
		while (fast.next!=null){
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}
	
	static void print(Node node){
		System.out.print(Integer.toString(node.data).concat(" -> "));
		if (node.next!=null){
			print(node.next);
		}else {return;}
	}
	
	public static Node removeDuplicate (Node head){
		if (head.next ==null){return null;}
		Node moving = head.next;
		Node curr = head;
		while (moving != null){
			System.out.println("current is ".concat(Integer.toString(curr.data).concat(" moving is: ").concat(Integer.toString(moving.data))));
			if (curr.data == moving.data){curr.next = moving.next; moving = moving.next;}
			else {curr=moving;moving = moving.next;}
		}
		
		return head;
	}

}
