package dynamic_programming;

import java.util.Arrays;

/*
 * 最长上升子序列
 */
public class LongAscendingSequence {
	private static int getLongAscendingSequence(int[] arr) {
		int[] memo = new int[arr.length];
		Arrays.fill(memo, 1);

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					memo[i] = Math.max(memo[i], 1 + memo[j]);
				}
			}
		}
		
		int res = 1;
		for (int i = 0; i < arr.length; i++) {
			res = Math.max(res, memo[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(getLongAscendingSequence(arr));
	}
}
