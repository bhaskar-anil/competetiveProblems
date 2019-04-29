package leetcode;

public class LL<T> {
	int capacity;
	LLNode<?> head;
	LLNode<?> tail;
	
	public LL(int capacity){
		this.capacity = capacity;
		this.head = null;
		this.tail = null;
	}
	
	// adds a node in the front
	public void addNode(Integer value) {
		LLNode<Integer> newNode = new LLNode<Integer>(value);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.next = this.head;
			this.head = newNode;
		}
	}

	public static void main(String[] args) {
		LL<Integer> intLL = new LL<>(5);
		
		intLL.addNode(1);
		intLL.addNode(2);
		
	}

}

class LLNode<T> {
	T value;
	LLNode<?> next;
	
	public LLNode(T value) {
		super();
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
