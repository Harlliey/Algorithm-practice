package lecture_1;

public class SmallSum {
	
	public static int smallSum(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}
	
	private static int mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		
		int mid = l + ((r - l) >> 1);
		
		return mergeSort(arr, l, mid) + mergeSort(arr, mid+1, r) + merge(arr, l, mid, r);
	}
	
	private static int merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int index = 0;
		int res = 0;
		int p1 = l;
		int p2 = m + 1;
		
		while (p1 <= m && p2 <= r) {
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
			help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		
		while (p1 <= m) {
			help[index++] = arr[p1++];
		}
		
		while (p2 <= r) {
			help[index++] = arr[p2++];
		}
		
		for(index = 0; index < help.length; index++) {
			arr[l+index] = help[index];
		}
		
		return res;
	}
}
