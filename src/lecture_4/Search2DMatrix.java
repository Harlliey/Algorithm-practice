package lecture_4;

/*
 * Leetcode 240. Search a 2D Matrix II
 */

public class Search2DMatrix {
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		int endRow = matrix.length - 1;
		int endCol = 0;
		
		int curRow = 0;
		int curCol = matrix[0].length - 1;
		
		while (curRow <= endRow && curCol >= endCol) {
			if (target > matrix[curRow][curCol]) {
				curRow ++;
			} else if (target < matrix[curRow][curCol]) {
				curCol --;
			} else {
				return true;
			}
		}
		
		return false;
	}
}
