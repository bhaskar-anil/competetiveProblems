package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DLL<T> {
	int size;
	DLLNode<T> head;
	DLLNode<T> tail;
	
	public DLL() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	// add a node in front
	public void addInFront(DLLNode<T> node) {
		if(this.head == null) {
			// there are no elements
			// this is going to be the first element
			this.size++;
			this.head = node;
			this.tail = node;
		} else {
			// there are already some nodes in the DLL
			node.next = this.head;
			this.head.previous = node;
			this.head = node;
			this.size++;
		}
	}
	
	// remove a node from a DLL
	public void removeANode(DLLNode<T> node) {
		// if the node is the tail, special case
		if(this.tail == node) {
			this.tail = this.tail.previous;
			this.tail.next = null;
			this.size--;
		} else {
			node.previous.next = node.next;
			node.next.previous = node.previous;
			this.size--;
		}
	}
	
	public int size() {
		return this.size;
	}
	
	

	public static void main(String[] args) {
		LRUCache<Integer> lruCache = new LRUCache<>(4);
		lruCache.add(1);
		lruCache.add(2);
		lruCache.add(3);
		lruCache.add(1);
	}
}

class DLLNode<T> {
	T value;
	DLLNode<T> next;
	DLLNode<T> previous;
	
	public DLLNode(T value) {
		this.value = value;
		this.next = null;
		this.previous = null;
	}

	public DLLNode<?> getNext() {
		return next;
	}

	public void setNext(DLLNode<T> next) {
		this.next = next;
	}

	public DLLNode<?> getPrevious() {
		return previous;
	}

	public void setPrevious(DLLNode<T> previous) {
		this.previous = previous;
	}
}

class LRUCache<T>{
	int capacity;
	Map<T, DLLNode<T>> nodesMap;
	DLL<T> nodesDLL;
	
	public LRUCache(int cap) {
		this.capacity = cap;
		this.nodesMap = null;
		this.nodesDLL = null;
	}
	
	public void add(T element) {
		DLLNode<T> node = new DLLNode<>(element);
		if(this.nodesMap == null) {
			// this means the LRUCache is empty
			// add an element to the LRUCache, it includes below two steps
			//     1. put the dllNode object into hashmap, so we can get it if it needs to be removed
			//	   2. add the element into dll
			
			this.nodesMap = new HashMap<>();
			this.nodesMap.put(element, node);
			
			this.nodesDLL = new DLL<>();
			this.nodesDLL.addInFront(node);
		} else {
			DLLNode<T> existing = this.nodesMap.get(element);
			if(existing != null) {	
				this.nodesDLL.removeANode(existing);
				this.nodesDLL.addInFront(node);
				this.nodesMap.put(element, node);
			} else {
				// element is not there in the cache
				if(this.nodesDLL.size() == this.capacity) {
					// and cache is full
					// need to remove the tail element from the dll
					this.nodesDLL.removeANode(this.nodesDLL.tail);
					this.nodesDLL.addInFront(node);
				} else {
					this.nodesDLL.addInFront(node);
					this.nodesMap.put(element, node);
				}
			}
		}
	}
}
