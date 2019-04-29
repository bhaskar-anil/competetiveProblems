package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Solution {
	
	public static boolean isPalindrome(int x) {
		char[] arr = new Integer(x).toString().toCharArray();
		
		for(int i = 0, j = arr.length-1; i < arr.length && j > i; i++, j--) {
			if(arr[i] != arr[j]) {
				return false;
			}
		}
		
		
        return true;
        
    }
	
	public static int[] rotateByK(int array[], int k) {
		int[] rotated = new int[array.length];
		// {1, 2, 3, 4, 5} k = 2 : -> {3, 4, 5, 1, 2}
		int i = 0, j = k;
		while(j < array.length) {
			rotated[i++] = array[j++];
		}
		j = 0;
		while(j < k) {
			rotated[i++] = array[j++];
		}
		return rotated;
	}
	
	public List<String> letterCombinations(String digits) {
        //n2
        //brute - force
        //iterate through the digits
        //pick each digit
        //iterate through its chars
        //same with List<String>
		
        List<char[]> chars = new ArrayList<>();
        chars.add(2, new char[] {'a', 'b', 'c'});
        
        char[] digitsArray = digits.toCharArray();
        for(int i = 0; i < digitsArray.length; i++) {
        		for(int j = 0; j < chars.get(digitsArray[i]).length; j++) {
        			
        		}
        }
        return null;
    }
	
	public static int reverseDigit(int x) {
		if(x<0) {
			String str = Integer.toString(x);
			int result = 0;
			@SuppressWarnings("unused")
			int pow = 0;
			for(int i = str.length()-1; i >= 1; i--) {
				result += Integer.parseInt(str.charAt(i)+"") * Math.pow(10, i-1);
				pow++;
			}
			
			return result*-1;
		}
		String str = Integer.toString(x);
		int result = 0;
		@SuppressWarnings("unused")
		int pow = 0;
		for(int i = str.length()-1; i >= 0; i--) {
			result += Integer.parseInt(str.charAt(i)+"") * Math.pow(10, i);
			pow++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(isPalindrome(11));
		
		System.out.println(reverseDigit(-23120));
		
		//int =[] = rotateByK(new int[] {1, 2, 3, 4, 0, 3, 4, 5, 10}, 6);
		
		int[] a = new int[] {1,1,1,1};
		int[] b = new int[] {0,1,0,1};
		int[] c = new int[] {1,1,1,1};
		int[] d = new int[] {1,0,0,1};
		
		int [][] mat = {a, b, c, d};
		//printMatrix(mat, 4);
		System.out.println();
		//printMatrix(rotate90ClockWiseMatrix(mat, 4), 4);
		int path = 0;
		numberOfPaths(4,0,0,path,mat);
		System.out.println(path);
	}
	
	static void numberOfPaths(int n, int i, int j, int path, int[][] arr) {
		System.out.println("visiting ("+i+","+j+")");
		if(i == n-1 && j == n-1) {
			System.out.println("path");
			path++;
			return;
		}
		if(i < n-1) {
			if(arr[i+1][j] == 1) {
				numberOfPaths(n, i+1, j, path, arr);
			}
		}
		if(j < n-1) {
			if(arr[i][j+1] == 1) {
				numberOfPaths(n, i, j+1, path, arr);
			}
		}
	}
	
	static class MyStackArr{
		private Integer[] stack;
		private int i;
		private int min = Integer.MAX_VALUE;
		
		public MyStackArr() {
			this.stack = new Integer[20];
			this.i = 0;
		}
		
		public void push(int data) {
			this.stack[i++] = data;
			if(data < min) min = data;
		}
		
		public int pop() {
			int popped = stack[--i];
			stack[i] = null;
			return popped;
		}
		
		public int min() {
			return this.min;
		}
	}
	
	public static int getSecondLargest(int[] array) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = largest;
		
		//largest = 10
		//secLar = 7
		
		//input = 9
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] > largest) {
				secondLargest = largest;
				largest = array[i];
			} else {
				if(array[i] > secondLargest) secondLargest = array[i];
			}
		}
		
		return secondLargest;
	}
	
	
	
	static void printMatrix(int[][] mat, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(mat[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	
	static int[][] rotate90ClockWiseMatrix(int[][] mat, int n) {
		int[][] rotated = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				rotated[i][j] = mat[n-j-1][i];
			}
		}
		return rotated;
	}
	
	public static String URLify(String s, int length) {
		
		//replace all the multiple spaces with one space
		s = s.replaceAll(" +", "    ");
		s.trim();
		
		char[] bytes = s.toCharArray();
		
		for(int i = 0; i < bytes.length; i++) {
			if(bytes[i] == ' ') {
				bytes[i] = '%';
				bytes[i+1] = '2';
				bytes[i+2] = '0';
				bytes[i+3] = '%';
				i += 3;
			}
			
		}
		
		
		return "";
	}
	
	public int consecutiveNumbersSum(int N) {
		int result = 0;
		
		
		
		
		return result;
        
    }
	
	
	
	
	
	
	
	//abbccc
	public static List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> result = new ArrayList<>();
		
		char[] charArray = S.toCharArray();
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < charArray.length; i++) {
			
			int currentCharCount = 0;
			char currentChar = charArray[i];
			
			int pointer = i;
			while(pointer < charArray.length && charArray[pointer] == currentChar) {
				currentCharCount++;
				end++;
				pointer++;
			}
			i += currentCharCount-1;
			if(currentCharCount > 2) {
				result.add(Arrays.asList(start,end));
			}			
			start = end;			
		}
        return result;
    }
	
	
	public static String maskPII(String S) {		
        return S.contains("@") ? maskEmail(S) : maskPhoneNumber(S);
    }
    
    public static String maskEmail(String s){
        return Character.toString(s.charAt(0)).toLowerCase()+"*****"+s.substring(s.indexOf('@')-1).toLowerCase();
    }
    
    public static String maskPhoneNumber(String s){
    		if(countDigits(s) > 10) {
    			return "+**-***-***-"+getLast4Digits(s);
    		}
        return "***-***-"+getLast4Digits(s);
    }
    
    private static String getLast4Digits(String s) {
    		char[] chars = s.toCharArray();
    		char[] last4Digits = new char[4];
    		for(int i = chars.length-1, j = 3; i >= 0 && j >= 0; i--) {
    			if(Character.getNumericValue(chars[i]) != -1) {
    				last4Digits[j] = chars[i];
    				j--;
    			}
    		}
    		
		return Character.toString(last4Digits[0])+Character.toString(last4Digits[1])+Character.toString(last4Digits[2])+Character.toString(last4Digits[3]);
	}

	static int countDigits(String s) {
    		char[] chars = s.toCharArray();
    		int count = 0;
    		for(int i = 0; i < chars.length; i++) {
    			if(Character.getNumericValue(chars[i]) >= 0 && Character.getNumericValue(chars[i]) <= 9) {
    				count++;
    			}
    		}
    		
    		return count;
    }
	
}

class Stack{
	private int size = 0;
	private Integer[] elements;
	
	public Stack() {
		elements = new Integer[10];
	}
	
	public void push(int element) {
		elements[size++] = element;
	}
	
	public void pop() {
		int popped = elements[--size];
		System.out.println(popped);
	}
}


class Node {
	int data;
	Node left;
	Node right;
	
	
	
	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	public static void toListInOrder(Node root, List<Integer> toList){
		if(root == null) return;
		toListInOrder(root.left, toList);
		toList.add(root.data);
		toListInOrder(root.right, toList);
	}
	
	public static void inOrder(Node root) {
	    if (root == null)  return; 
	    inOrder(root.left);
	    System.out.print(root.data + " ");
	    inOrder(root.right);
	}
	
	public static void preOrder(Node root) {
	    if (root == null)  return;
	    System.out.print(root.data + " ");
	    preOrder(root.left);
	    preOrder(root.right);
	}
	
	public static void postOrder(Node root) {
	    if (root == null)  return;
	    postOrder(root.left);
	    inOrder(root.right);
	    System.out.print(root.data + " ");
	}
}



















