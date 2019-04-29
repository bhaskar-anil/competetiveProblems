package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {
	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		int number = 0;
		for(int i = A.size() - 1; i >= 0; i--) {
			number += A.get(i) * Math.pow(10, A.size()-i-1);
		}
		
		number += 1;
		ArrayList<Integer> result = new ArrayList<>();
		//make array list of the number again
		while(number != 0) {
			result.add(number%10);
			number = number / 10;
		}
		ArrayList<Integer> reversed = new ArrayList<>(result.size());
		for(int i = result.size()-1; i >= 0; i--) {
			reversed.add(result.size()-i-1, result.get(i));
		}
		return reversed;
    }
	public static void main(String[] args) {
		plusOne(new ArrayList<>(Arrays.asList(1,2,3)));
	}

}
