package leetcode;

public class MyList {
	
	private Node head;
	
	class Node{
		Integer data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public int pop() {
		return 0;
	}
	
	public void push(int data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			head = newNode;
			return;
		}
		while(this.head.next != null) {
			head = head.next;
		}
		head.next = newNode;
	}
	
	/*------------driver-----------*/
	public static void main(String[] args) {
		MyList ll = new MyList();
		
		ll.push(1);
		ll.push(2);
		ll.push(3);
		ll.push(4);
	}

}
