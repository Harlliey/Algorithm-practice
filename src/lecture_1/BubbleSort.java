package lecture_1;

/*
 * 插入排序的复杂度是与数据情况是有关的，而冒泡排序和选择排序是无关的
 * 最差情况的算法复杂度是一个算法流程的复杂度指标
 */

public class BubbleSort {
	
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		
		for (int end=arr.length-1; end>0; end--) {
			for (int i=0; i<end; i++) {
				if (arr[i]>arr[i+1]) {
					swap(arr, i, i+1);
				}
			}
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
