package leetcode;

public class LL<T> {
	int capacity;
	LLNode<T> head;
	LLNode<T> tail;
	
	public LL(int capacity){
		this.capacity = capacity;
		this.head = null;
		this.tail = null;
	}
	
	// adds a node in the front
	public void addNodeInFront(T value) {
		LLNode<T> newNode = new LLNode<>(value);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.next = this.head;
			this.head = newNode;
		}
	}
	
	public void addNodeInEnd(LLNode<T> newNode) {
		if(head == null) { // empty LL
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}
	}
	
	public void reverse() {
		if(head == null) {
			return;
		}
		LLNode<T> newNode = new LLNode<>(head.value);
		this.tail = newNode;
		LLNode<T> current = newNode;
		
		while(head.next != null) {
			LLNode<T> newN = new LLNode<>(head.next.value);
			newN.next = current;
			current = newN;
			head = head.next;
		}
		head = current;
	}

	public static void main(String[] args) {
		LL<Integer> intLL1 = new LL<Integer>(5);
		LL<Integer> intLL2 = new LL<Integer>(5);
		
		LLNode<Integer> n1 = new LLNode<>(1);
		LLNode<Integer> n2 = new LLNode<>(2);
		LLNode<Integer> n3 = new LLNode<>(3);
		LLNode<Integer> n4 = new LLNode<>(4);
		LLNode<Integer> n5 = new LLNode<>(5);
		LLNode<Integer> n6 = new LLNode<>(6);
		LLNode<Integer> n7 = new LLNode<>(7);
		LLNode<Integer> n8 = new LLNode<>(8);
		LLNode<Integer> n9 = new LLNode<>(9);
		LLNode<Integer> n10 = new LLNode<>(10);
		
		intLL1.addNodeInEnd(n1);
		intLL1.addNodeInEnd(n2);
		intLL1.addNodeInEnd(n3);
		intLL1.addNodeInEnd(n4);
		intLL1.addNodeInEnd(n5);
		intLL1.addNodeInEnd(n6);
		intLL1.addNodeInEnd(n10);
		
		
		intLL2.addNodeInEnd(n7);
		intLL2.addNodeInEnd(n8);
		intLL2.addNodeInEnd(n9);
		intLL2.addNodeInEnd(n6);
		
		System.out.println(getIntersectionNode(n1, n7).toString());
		
	}
	
	public static LLNode<?> getIntersectionNode(LLNode<?> a, LLNode<?> b) {
		int la = length(a);
		int lb = length(b);
		
		if (la > lb){
			int diff = la - lb;
			// a is a bigger LL
			// traverse a till same length
			a = traverseNodes(a, diff);
		}
		
		if (lb > la){
			int diff = lb - la;
			// a is a bigger LL
			// traverse a till same length
			b = traverseNodes(b, diff);
		}
		
		return checkForIntersection(a, b);
        
    }
	
	static LLNode<?> checkForIntersection(LLNode<?> a, LLNode<?> b){
		while(a.next != null && b.next != null) {
			if(a.next == b.next) {
				return a.next;
			}
			a = a.next;
			b = b.next;
		}
		return null;
	}
	
	static int length(LLNode<?> a) {
		int length = 0;
		if(a == null) {
			return length;
		}
		while(a.next != null) {
			length++;
			a = a.next;
		}
		return length;
	}
	
	static LLNode<?> traverseNodes(LLNode<?> head, int n){
		for(int i = 0; i < n; i++) {
			head = head.next;
		}
		return head;
	}

}

class LLNode<T> {
	T value;
	LLNode<T> next;
	
	public LLNode(T value) {
		this.value = value;
		this.next = null;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
