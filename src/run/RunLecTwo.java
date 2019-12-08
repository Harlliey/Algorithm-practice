package run;

import lecture_2.ClassicQuickSort;
import lecture_2.HeapSort;
import lecture_2.NetherlandsFlag;

public class RunLecTwo {
	
	public static void main(String[] args) {
		int[] arr = {7, 2, 9, 5, 4, 5, 1, 5, 10, 3};
//		int[] arr = {1, 2, 3, 5, 4};
//		runNetherlandsFlag(arr);
//		runClassicQuickSort(arr);
		runHeapSort(arr);
	}
	
	private static void runNetherlandsFlag(int[] arr) {
		NetherlandsFlag.partition(arr, 0, arr.length-1, 5);
		printArr(arr);
	}
	
	private static void runClassicQuickSort (int[] arr) {
		ClassicQuickSort.quickSort(arr, 0, arr.length-1);
		printArr(arr);
	}
	
	private static void runHeapSort (int[] arr) {
		HeapSort.heapSort(arr);
		printArr(arr);
	}
	
	private static void printArr(int[] arr) {
		for (int ele : arr) {
			System.out.print(ele + " ");
		}
	}
}
