package run;

import lecture_1.BubbleSort;
import lecture_1.InsertSort;
import lecture_1.MergeSort;
import lecture_1.ReversePair;
import lecture_1.SelectionSort;
import lecture_1.SmallSum;

public class RunLecOne {
	
	public static void main(String[] args) {
		int[] arr = {4, 2, 3, 1 , 9, 5, 8, 100, 3};
		runInsertSort(arr);
//		runSelectionSort(arr);
//		runBubbleSort(arr);
//		runMergeSort(arr);
		
//		int[] arr = {1, 3, 4, 2, 5};
//		runSmallSum(arr);
		
//		int[] arr = {1, 3, 2, 3, 1};
//		runReversePair(arr);
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
	
	private static void runReversePair(int[] arr) {
		int result = ReversePair.countReversePair(arr);
		System.out.println(result);
	}
	
	private static void runBubbleSort(int[] arr) {
		BubbleSort.bubbleSort(arr);
		printRes(arr);
	}
	
	private static void runSelectionSort(int[] arr) {
		SelectionSort.selectionSort(arr);
		printRes(arr);
	}
	
	private static void runInsertSort(int[] arr) {
		InsertSort.insertSort(arr);
		printRes(arr);
	}
}
