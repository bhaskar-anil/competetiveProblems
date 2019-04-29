package leetcode;


public class BST {
	TreeNode root;
	
	public void insert(Integer value) {
		TreeNode node = new TreeNode(value);
		TreeNode cNode = this.root;
		if(cNode == null) {
			// empty BST
			this.root = node;
		} else {
			insertRecursive(cNode, node);
		}
	}
	

	private void insertRecursive(TreeNode cNode, TreeNode node) {
		if(cNode.value > node.value) {
			if(cNode.left == null) {
				cNode.left = node;
			} else {
				insertRecursive(cNode.left, node);
			}
		}
		
		if(cNode.value < node.value) {
			if(cNode.right == null) {
				cNode.right = node;
			} else {
				insertRecursive(cNode.right, node);
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
	}

}

class TreeNode {
	Integer value;
	TreeNode left;
	TreeNode right;
	TreeNode parent; // maybe not needed
	
	public TreeNode(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}
