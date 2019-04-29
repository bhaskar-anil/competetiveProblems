package leetcode;

public class ListNode {
	ListNode next = null;
	int val;
	
	
	public ListNode(int data) {
		this.val = data;
	}
	
	
	void addToTail(int data) {
		ListNode end = new ListNode(data);
		ListNode n = this;
		
		while(n.next != null) {
			n = n.next;
		}
		
		n.next = end;
	}
	
	ListNode addSorted(int data) {
		ListNode n = this;
		ListNode newNode = new ListNode(data);
		while(n.next != null && n.next.val <= data) {
			n = n.next;
		}
		
		newNode.next = n.next;
		n.next = newNode;
		
		
		return this;
	}
	
	public static ListNode mergeSorted(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		}
		int i = 0;
		while(i < lists.length && lists[i] == null) {
			i++;
			if(i == lists.length) {
				return null;
			}
		}
		ListNode head = lists[i];
		//brute force solution
		for(int j = i+1; j < lists.length; j++) {
			ListNode currHead = lists[j];
			while(currHead != null) {
				
				ListNode n = head;
				int data = currHead.val;
				ListNode newNode = new ListNode(data);
				while(n.next != null && n.val <= data) {
					n = n.next;
				}
				newNode.next = n.next;
				n.next = newNode;
				
				currHead = currHead.next;
			}
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head3= null;
		ListNode head4= null;
		ListNode head5 = null;
		ListNode head1 = new ListNode(1);
		
		ListNode head2 = new ListNode(0);
		//head2.addToTail(5);
		
		ListNode merged = mergeSorted(new ListNode[] {head1, head2});
	}

}
