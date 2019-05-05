package interviewbit;

public class MinHeap {
	
	int [] heap;
	int size;
	int maxSize;
	
	public MinHeap(int maxSize) {
		super();
		this.heap = new int[maxSize + 1];
		this.heap[0] = Integer.MIN_VALUE;
		this.size = 0;
		this.maxSize = maxSize;
	}

	public boolean isLeaf(int pos) {
		if(this.size < leftChild(pos) && this.size < leftChild(pos)) {
			return true;
		}
		return false;
	}
	
	public int parent(int pos) {
		return pos/2;
	}
	
	public int leftChild(int pos) {
		return 2 * pos;
	}
	
	public int rightChild(int pos) {
		return (2 * pos) + 1;
	}
	
	public void insert(int element) {
		this.heap[++this.size] = element;
		
		int current = this.size;
		while(this.heap[current] < this.heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	private void swap(int current, int parent) {
		int temp = this.heap[current];
		this.heap[current] = this.heap[parent];
		this.heap[parent] = temp;
	}
	
	public int extractMin() {
		int extracted = heap[1];
		heap[1] = heap[size--];
		minHeapify(1);
		return extracted;
	}

	private void minHeapify(int pos) {
		if(isLeaf(pos)) {
			return;
		}
		// check if any child is smaller
		if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
			// get the smaller child
			if(heap[leftChild(pos)] < heap[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				minHeapify(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				minHeapify(rightChild(pos));
			}
		}
	}
	
	public void print() {
		System.out.println("min heap is:");
		for(int i = 1; i <= size; i++) {
			System.out.print(heap[i]);
			if(i < size) {
				System.out.print(", ");
			} else {
				System.out.print("\n");
			}
		}
	}
	
	public void heapSort() {
		int originalSize = size;
		while(size > 1) {
			int temp = size;
			int min = extractMin();
			heap[temp] = min;
		}
		size = originalSize;
	}

	public static void main(String[] args) {
		MinHeap mh = new MinHeap(10);
		mh.insert(10);
		mh.insert(15);
		mh.insert(11);
		mh.insert(20);
		mh.insert(8);
		mh.insert(25);
		mh.insert(7);
		mh.insert(11);
		mh.insert(3);
		mh.insert(12);
		
		//mh.heapSort();
		
		mh.print();
		System.out.println("extracted value: " + mh.extractMin());
		mh.print();
		System.out.println("extracted value: " + mh.extractMin());
		System.out.println("extracted value: " + mh.extractMin());
		mh.print();
		
	}

}
