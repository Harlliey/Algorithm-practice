package lecture_2;

public class NetherlandsFlag {
	
	public static void partition(int[] arr, int L, int R, int num) {
		int less = L - 1;
		int more = R + 1;
		int cur = L;
		
		while (cur < more) {
			if (arr[cur] < num) {
				swap(arr, cur++, ++less);
			} else if (arr[cur] > num) {
				swap(arr, cur, --more);
			} else {
				cur++;
			}
		}
	}
	
	private static void swap(int[] arr, int firstIndex, int secondIndex) {
		int temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}
}
