package leetcode;

import java.util.List;
import java.util.Queue;

public class Graph {
	
	public Node[] nodes;
	
	static class Node {
		private Integer vertex;
		private Node[] children;
		private boolean isVisited = false;
		
		public Node(Integer vertex) {
			this.vertex = vertex;
		}
	}
	
	static class MyQueue{
		private QueueNode head;
		private QueueNode tail;
		
		static class QueueNode{
			private Integer element;
			private QueueNode next;
			
			public QueueNode(Integer element) {
				this.element = element;
			}
		}
		
		public void enqueue(Integer element) {
			QueueNode newNode = new QueueNode(element);
			if(tail != null) {
				tail.next = newNode;
			}
			tail = newNode;
			if(head == null) {
				head = tail;
			}
		}
	}
	
	public void dfs(Node root) {
		if(root != null) {
			System.out.println(root.vertex);
			root.isVisited = true;
			for(int i = 0; i < root.children.length; i++) {
				if(!root.children[i].isVisited) {
					dfs(root.children[i]);
				}
			}
		}
	}
	
	public List<String> dfs(List<String> res, String curr, char[] digits){
		if(curr.length() == digits.length) {
			res.add(curr);
			return res;
		}
		for(int i = 0; i < digits.length; i++) {
			dfs(res, curr+digits[i], digits);
		}
		
		return res;
	}
	
	public void bfs(Node root) {
		MyQueue queue = new MyQueue();
		queue.enqueue(root.vertex);
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		//create the graph
		Graph g = new Graph();
		Node n0 = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n10 = new Node(10);
		Node n12 = new Node(12);
		Node n7 = new Node(7);
		Node n9 = new Node(9);
		Node n11 = new Node(11);
		
		n0.children = new Node[] {n1, n3};
		n1.children = new Node[] {n0, n2, n11};
		n2.children = new Node[] {n1, n4};
		n3.children = new Node[] {n0};
		n4.children = new Node[] {n1, n10, n7};
		n7.children = new Node[] {n4, n9};
		n9.children = new Node[] {n7};
		n10.children = new Node[] {n4, n12};
		n11.children = new Node[] {n1};
		n12.children = new Node[] {n10};

		//check if two people are friends
		//DFS approach
		g.dfs(n0);
		
	}

}
