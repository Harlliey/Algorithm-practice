package run;

//import java.util.LinkedList;
import java.util.List;

import lecture_4.RotateImage;
import lecture_4.Search2DMatrix;
import lecture_4.SpiralMatrix;
import lecture_4.ZigZagMatrix;

public class RunLecFour {
	
	public static void main(String[] args) {
//		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
		runSearch2DMatrix(matrix, 20);
//		runZigZagMatrix(matrix);
//		runRotateImage(matrix);
//		
//		for (int[] arr : matrix) {
//			for (int item : arr) {
//				System.out.print(item + " ");
//			}
//			System.out.println();
//		}
	}
	
	private static List<Integer> runSpiralMatrix(int[][] matrix) {
		List<Integer> result = SpiralMatrix.spiralOrder(matrix);
		return result;
	}
	
	private static void runRotateImage(int[][] matrix) {
		RotateImage.rotateMatrix(matrix);
	}
	
	private static void runZigZagMatrix(int[][] matrix) {
		ZigZagMatrix.printZigZagMatrix(matrix);
	}
	
	private static void runSearch2DMatrix(int[][] matrix, int target) {
		boolean flag = Search2DMatrix.searchMatrix(matrix, target);
		System.out.println(flag);
	}
}
