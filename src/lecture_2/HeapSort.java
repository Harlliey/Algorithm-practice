package lecture_2;

public class HeapSort {
	
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		
		int size = arr.length;
		swap(arr, 0, --size);
		while (size > 0) {
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}
	}

	private static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}
	
	private static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		
		while (left < size) {
		int largest = left + 1 < size && arr[left] < arr[left + 1] ? left + 1 : left;
		largest = arr[index] > arr[largest] ? index : largest;
		if (largest == index) {
			break;
		}
		swap(arr, index, largest);
		index = largest;
		left = index * 2 + 1;
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
