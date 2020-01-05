package lecture_4;

/*
 * Leetcode 54. Spiral Matrix
 */

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
	 
	public static List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> resultList = new LinkedList<>();
		int lR = 0;
		int lC = 0;
		int rR = matrix.length - 1;
		int rC = matrix[0].length - 1;
		
		while (lR <= rR && lC <= rC) {
			List<Integer> edgeList = getEdge(matrix, lR++, lC++, rR--, rC--);
			resultList.addAll(edgeList);
		}
		
		return resultList;
	}
	
	private static List<Integer> getEdge(int[][] matrix, int lR, int lC, int rR, int rC) {
		
		List<Integer> edgeList = new LinkedList<>();
		int ltR = lR;
		int ltC = lC;
		int rbR = rR;
		int rbC = rC;
		
		if (lR == rR) {
			while (ltC <= rC) {
				edgeList.add(matrix[lR][ltC++]);
			}
		} else if (lC == rC) {
			while (ltR <= rR) {
				edgeList.add(matrix[ltR++][lC]);
			}
		} else {
			while (ltC != rC) {
				edgeList.add(matrix[lR][ltC++]);
			}
			
			while (ltR != rR) {
				edgeList.add(matrix[ltR++][rC]);
			}
			
			while (rbC != lC) {
				edgeList.add(matrix[rR][rbC--]);
			}
			
			while (rbR != lR) {
				edgeList.add(matrix[rbR--][lC]);
			}
		}
		return edgeList;
	}
}
