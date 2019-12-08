package run;

import lecture_3.MaxGap;

public class RunLecThree {

	public static void main(String[] args) {
		int[] arr = {3,6,9,1};
		runMaxGap(arr);
	}
	
	private static void runMaxGap(int[] arr) {
		int result = MaxGap.getMaxGap(arr);
		System.out.println(result);
	}
}
