package leetcode;

public class BST2DLL {
	
	// convert a bst to dll in sorted order
	static DLL<Integer> bst2Dll(BST bst){
		// to do so we will do in-order traversal
		DLL<Integer> dll = new DLL<Integer>();
		DLLNode<Integer> cDLLNode = new DLLNode<>(-1);
		inOrderTraverseAndPrepareDLL(bst.root, cDLLNode, dll);
		return dll;
	}
	
	static void inOrderTraverseAndPrepareDLL(TreeNode cTreeNode, DLLNode<Integer> cDLLNode, DLL<Integer> dll) {
		if(cTreeNode.left != null) {
			inOrderTraverseAndPrepareDLL(cTreeNode.left, cDLLNode, dll);
		} else {
			DLLNode<Integer> dllNode = new DLLNode<>(cTreeNode.value);
			if(dll.head == null) {
				// dll is empty yet, add as a head
				dll.head = dllNode;
				cDLLNode = dllNode;
			} else {
				while(cDLLNode.next != null) {
					cDLLNode = cDLLNode.next;
				}
				dllNode.previous = cDLLNode;
				cDLLNode.next = dllNode;
			}
		}
		if(cTreeNode.right != null) {
			inOrderTraverseAndPrepareDLL(cTreeNode.right, cDLLNode, dll);
		} else {
			DLLNode<Integer> dllNode = new DLLNode<>(cTreeNode.value);
			if(dll.head == null) {
				// dll is empty yet, add as a head
				dll.head = dllNode;
				cDLLNode = dllNode;
			} else {
				while(cDLLNode.next != null) {
					cDLLNode = cDLLNode.next;
				}
				dllNode.previous = cDLLNode;
				cDLLNode.next = dllNode;
			}
		}
	}

	public static void main(String[] args) {
		BST b = new BST();
		b.insert(10);
		b.insert(8);
		b.insert(12);
		b.insert(9);
		b.insert(7);
		
		DLL<Integer> d = bst2Dll(b);
	}

}
