package lecture_1;

public class MergeSort {
	
	public static void sortProcess(int[] arr, int L, int R) {
		if (L == R) {
			return;
		}
		
		int mid = L + ((R - L) >> 1);
		sortProcess(arr, L, mid);
		sortProcess(arr, mid+1, R);
		merge(arr, L, mid, R);
	}
	
	private static void merge(int[] arr, int L, int mid, int R) {
		int[] help = new int[R - L + 1];
		int index = 0;
		int lp = L;
		int rp = mid + 1;
		while (lp <= mid && rp <= R) {
			help[index++] = arr[lp] < arr[rp] ? arr[lp++] : arr[rp++];
		}
		
		while (lp <= mid) {
			help[index++] = arr[lp++];
		}
		
		while (rp <= R) {
			help[index++] = arr[rp++];
		}
		
		for (index = 0; index < help.length; index++) {
			arr[L+index] = help[index];
		}
	}
}
