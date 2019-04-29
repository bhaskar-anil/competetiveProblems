package leetcode;


public class MyStack<E> {
	
	static class StackNode<T>{
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data){
			this.data = data;
			this.next = null;
		}
		
		public void push(T data) {
			StackNode<T> newNode = new StackNode<>(data);
			
		}
	}

}
