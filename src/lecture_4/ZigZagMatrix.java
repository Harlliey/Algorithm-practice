package lecture_4;

public class ZigZagMatrix {

	public static void printZigZagMatrix(int[][] matrix) {
		
		int aR = 0;
		int aC = 0;
		int bR = 0;
		int bC = 0;
		
		int rowLimit = matrix.length - 1;
		int colLimit = matrix[0].length - 1;
		boolean flag = false;
		
		while (aR <= rowLimit) {
			printDiagonal(matrix, aR, aC, bR, bC, flag);
			aR = aC == colLimit ? aR+1 : aR;
			aC = aC == colLimit ? aC : aC+1;
			bC = bR == rowLimit ? bC+1 : bC;
			bR = bR == rowLimit ? bR : bR+1;
			flag = !flag;
		}
	}
	
	private static void printDiagonal(int[][] matrix, int aR, int aC, int bR, int bC, boolean flag) {
		int curR = 0;
		int curC = 0;
		
		if (!flag) {
			curR = bR;
			curC = bC;
			while (curR >= aR) {
				System.out.print(matrix[curR--][curC++] + " ");
			}
		} else {
			curR = aR;
			curC = aC;
			while (curR <= bR) {
				System.out.print(matrix[curR++][curC--] + " ");
			}
		}
	}
}
