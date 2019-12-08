package lecture_2;

public class ClassicQuickSort {
	
	public static void quickSort(int[] arr, int L, int R) {
		if (L < R) {
			int[] p = partition(arr, L, R);
			quickSort(arr, L, p[0]-1);
			quickSort(arr, p[1]+1, R);
		}
	}
	
	//将数组最后一个值作为partition的依据
	private static int[] partition(int[] arr, int L, int R) {
		int cur = L;
		int less = L - 1;
		int more = R;
		
		while (cur < more) {
			if (arr[cur] < arr[R]) {
				swap(arr, cur++, ++less);
			} else if (arr[cur] > arr[R]) {
				swap(arr, cur, --more);
			} else {
				cur++;
			}
		}
		
		swap(arr, R, more);
		return new int[] {less+1, more};
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
