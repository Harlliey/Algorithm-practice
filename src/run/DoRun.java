package run;

import lecture_1.MergeSort;
import lecture_1.SmallSum;

public class DoRun {
	
	public static void main(String[] args) {
//		int[] arr = {4, 2, 3, 1 , 9, 5, 8};
//		runMergeSort(arr);
		
		int[] arr = {1, 3, 4, 2, 5};
		runSmallSum(arr);
	}
	
	private static void printRes(int[] arr) {
		for (int element : arr) {
			System.out.print(element + " ");
		}
	}
	
	private static void runMergeSort(int[] arr) {
		MergeSort.sortProcess(arr, 0, arr.length - 1);
		printRes(arr);
	}
	
	private static void runSmallSum(int[] arr) {
		int result = SmallSum.smallSum(arr);
		System.out.println(result);
	}
}
