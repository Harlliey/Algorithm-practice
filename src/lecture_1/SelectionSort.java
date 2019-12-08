package lecture_1;

public class SelectionSort {
	
	public static void selectionSort(int arr[]) {
		if (arr==null || arr.length<2) {
			return;
		}
		
		int minIndex = 0;
		for (int start=0; start<arr.length-1; start++) {
			minIndex = start;
			for (int i=start+1; i<=arr.length-1; i++) {
				minIndex = arr[minIndex] > arr[i] ? i : minIndex;
			}
			swap(arr, start, minIndex);
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
