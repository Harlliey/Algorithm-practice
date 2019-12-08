package lecture_1;

public class InsertSort {

	public static void insertSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return;
		}
		
		for (int end=1; end<arr.length; end++) {
			for (int i=end-1; i>=0 && arr[i+1]<arr[i]; i--) {
				swap(arr, i, i+1);
			}
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
