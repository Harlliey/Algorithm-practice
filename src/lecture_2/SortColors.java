package lecture_2;
/*
 * LeetCode75. Sort Colors
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色
 * 示例:

 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class SortColors {
    
	public static void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1 || nums == null) {
            return;
        }
        
        int less = -1;
        int more = nums.length;
        int cur = 0;
        
        while (cur < more) {
            if (nums[cur] < 1) {
                swap(nums, cur++, ++less);
            } else if (nums[cur] > 1) {
                swap(nums, cur, --more);
            } else {
                cur ++;
            }
        }
    }
	
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
