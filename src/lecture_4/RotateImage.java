package lecture_4;

/*
 * Leetcode 48. Rotate Image
 */

public class RotateImage {
	
	public static void rotateMatrix(int[][] matrix) {

		int lR = 0;
		int lC = 0;
		int rR = matrix.length - 1;
		int rC = matrix[0].length - 1;
		
		while (lR < rR) {
			rotateEdge(matrix, lR++, lC++, rR--, rC--);
		}
	}
	
	private static void rotateEdge(int[][] matrix, int lR, int lC, int rR, int rC) {
		int times = rC - lC;
		int tmp = 0;
		
		for (int i = 0; i < times; i++) {
			tmp = matrix[lR][lC + i];
			matrix[lR][lC + i] = matrix[rR - i][lC];
			matrix[rR - i][lC] = matrix[rR][rC - i];
			matrix[rR][rC - i] = matrix[lR + i][rC];
			matrix[lR + i][rC] = tmp;
		}
	}
}
