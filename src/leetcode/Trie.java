package leetcode;

public class Trie {
	
	public static void main(String[] args) {
		System.out.println((int)'a');
	}
	
	public void insert(String word) {
		//Capitalize the string
		for(int i = 0; i < word.length(); i++) {
			
		}
	}

}

class TrieNode{
	
	char c;
	//can have an array of chars storing at their ascii index
	//a-z 97-122				 A-Z 65-90
	TrieNode[] alphabates = new TrieNode[123];
	TrieNode childres;
	boolean isLeaf;
	
	public TrieNode(char c) {
		this.c = c;
	}
}
