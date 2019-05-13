package interviewbit;

// LIFO
public class Queue<T> {
	QueueNode<T> head;
	QueueNode<T> tail;
	
	public void enqueue(T data) {
		QueueNode<T> node = new QueueNode<>(data);
		if(this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
	}
	
	public void dequeue() {
		if(head == null) {
			return;
		}
		this.head = this.head.next;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		q.dequeue();
	}

}

class QueueNode<T> {
	T data;
	QueueNode<T> next;
	
	public QueueNode(T data) {
		this.data = data;
		next = null;
	}
}
