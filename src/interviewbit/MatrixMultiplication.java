package interviewbit;

public class MatrixMultiplication {
	
	static int[][] muliply(int[][] a, int[][] b, int n, int m, int p){
		int c[][] = new int [n][p];
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < p; i++) {
				c[k][i] = 0;

				for (int j = 0; j < m; j++) {
					c[k][i] += a[k][j] * b[j][i];
				}
			}
		}
		return c;//3x2
	}

	public static void main(String[] args) {
		int a[][] = {	{1,2,3,4},
						{2,1,3,4},
						{2,1,1,1}}; //3x4
		
		int b[][] = {	{3,5},
						{2,1},
						{4,3},
						{2,3}};//4x2
		
		muliply(a, b, 3, 4, 2);

	}
	
	

}
