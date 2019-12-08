package lecture_3;

/*
 * Leetcode 164. Maximum Gap
 * 需要注意在leetcode大样本容量数据测试下，要将getBucketId函数的参数类型都改成long，否则乘法溢出，进而导致数组越界
 */
public class MaxGap {

	public static int getMaxGap(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int len = arr.length;
		int i = 0;
		for (; i < len; i++) {
			max = Math.max(arr[i], max);
			min = Math.min(arr[i], min);
		}
		
		if (max == min) {
			return 0;
		}
		
		boolean[] hasNum = new boolean[len + 1];
		int[] maxs = new int[len+1];
		int[] mins = new int[len+1];
		int bid = 0;
		
		for (i = 0; i < len; i++) {
			bid = getBucketId(arr[i], len, min, max);
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
			hasNum[bid] = true;
		}
		
		int result = 0;
		int lastMax = maxs[0];
		for (i = 1; i <= len; i++) {
			if (hasNum[i]) {
				result = Math.max(mins[i]-lastMax, result);
				lastMax = maxs[i];
			}
		}
		
		return result;
	}
	
	private static int getBucketId(int num, int len, int min, int max) {
		return (int) ((num-min) * len / (max-min));
	}
}
