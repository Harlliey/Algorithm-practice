package lecture_2;

/*
 * 最常用的排序
 * 代码最简洁，工程上使用该排序，常数项复杂度最低，所以最快
 * 空间复杂度为 O(logN)，因为需要额外记录断点
 */

public class RandomQuickSort {
	
	public static void quickSort(int[] arr, int L, int R) {
		if (L < R) {
			swap(arr, L + (int)Math.random()*(R - L + 1), R);		//随机选择一个数字作为partition的依据，并与数组最后一个数字交换
			int[] p = partition(arr, L, R);
			quickSort(arr, L, p[0]-1);
			quickSort(arr, p[1]+1, R);
		}
	}
	
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
