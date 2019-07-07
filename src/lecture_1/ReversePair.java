package lecture_1;

public class ReversePair {
	
	public static int countReversePair(int[] arr) {
		return mergeSort(arr, 0, arr.length-1);
	}
	
	private static int mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		
		int m = l + ((r - l) >> 1);
		
		return mergeSort(arr, l, m) + mergeSort(arr, m+1, r) + merge(arr, l, m, r);
	}
	
	private static int merge(int arr[], int l, int m, int r) {
		int[] help = new int[r-l+1];
		int index = 0;
		int result = 0;
		int p1 = l;
		int p2 = m + 1;
		
		while (p1 <= m && p2 <= r) {
			result += arr[p1] > arr[p2] ? (m-p1+1) : 0;
			help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		
		while (p1 <= m) {
			help[index++] = arr[p1++];
		}
		
		while (p2 <= r) {
			help[index++] = arr[p2++];
		}
		
		for (index = 0; index < help.length; index++) {
			arr[l+index] = help[index];
		}
		
		return result;
	}
}
