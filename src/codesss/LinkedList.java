package codesss;

public class LinkedList {

	Node head;
	Node tail;
	private int size;
	
	public void insertFirst(int val) {
		Node node = new Node(val);
		if(head==null) {
			head = node;
			tail=node;
			return;
		}
		node.next = head;
		head = node;
		size++;
	}
	public void insertLast(int val) {
		if(tail==null) {
			insertFirst(val);
			return;
		}
		Node node = new Node(val);
		tail.next = node;
		tail = node;
		size++;
	}
	public void insertAt(int val, int index) {
		
		size++;
	}
	public void display() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.val+"-->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	
	private class Node {
		int val;
		Node next;
		
		Node(int val){
			this.val=val;
		}
		Node(int val, Node next){
			this.val = val;
			this.next = next;
		}
	}
}
