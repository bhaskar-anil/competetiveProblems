package interviewbit;

import java.util.Arrays;
import java.util.List;

public class Graph<T> {
	
	GNode<T> root;
	List<GNode<T>> nodes;
	
	
	
	// visit a node and then iterate through it's neighbors
	void DFS(GNode<T> root) {
		if(root == null) {
			return;
		}
		visit(root);
		
		for (GNode<T> neighbor : root.neighbors) {
			if(neighbor.visited == false) {
				DFS(neighbor);
			}
		}
	}
	
	void BFS(GNode<T> root) {
		if(root == null) {
			return;
		}
		Queue<T> q = new Queue<>();
		q.enqueue(root.value);
		visit(root);
		while(!q.isEmpty()) {
			for (GNode<T> neighbor : root.neighbors) {
				if(neighbor.visited == false) {
					q.enqueue(neighbor.value);
					visit(neighbor);
				}
			}
			q.dequeue();
		}
	}
	
	void visit(GNode<T> node) {
		System.out.println(node.value + " ");
		node.visited = true;
	}

	public static void main(String[] args) {

		// create all nodes
		GNode<Integer> n0 = new GNode<>(0);
		GNode<Integer> n1 = new GNode<>(1);
		GNode<Integer> n2 = new GNode<>(2);
		GNode<Integer> n3 = new GNode<>(3);
		GNode<Integer> n4 = new GNode<>(4);
		GNode<Integer> n5 = new GNode<>(5);
		
		// make adjacency list
		n0.neighbors = Arrays.asList(n1, n4, n5);
		n1.neighbors = Arrays.asList(n3, n4, n2, n0);
		n2.neighbors = Arrays.asList(n1, n3);
		n3.neighbors = Arrays.asList(n2, n4, n1);
		n4.neighbors = Arrays.asList(n0, n1, n3);
		n5.neighbors = Arrays.asList(n0);
		
		// create graph
		Graph<Integer> g = new Graph<>();
		g.root = n0;
		
		//g.DFS(n0);
		
		g.BFS(n0);
	}

}

class GNode<T> {
	T value;
	boolean visited;
	List<GNode<T>> neighbors;
	
	public GNode(T value) {
		this.value = value;
		this.visited = false;
		this.neighbors = null;
	}
}

class GNodeQueue<T>{
	
}
