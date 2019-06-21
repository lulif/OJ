package dynamic_programming;

/*
 * 最大子矩阵：一个N*N的矩阵，找出在矩阵中，所有元素加起来之和最大的子矩阵
 */
public class MaximumSubmatrix {
	// 全程不停维护这个最大值
	private static int max;

	private static void maxSum(int arr[]) {
		int temp = 0;
		for (int t = 0; t < arr.length; t++) {
			if (temp > 0) {
				temp += arr[t];
			} else {
				temp = arr[t];
			}
			max = Math.max(max, temp);
		}
	}

	private static int getResult(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			maxSum(arr[i]);
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = 0; k < arr[0].length; k++) {
					arr[i][k] += arr[j][k];
				}
				maxSum(arr[i]);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] arr = { { 0, -2, -7, 0 }, { 9, 2, -6, 2 }, { -4, 1, -4, 1 }, { -1, 8, 0, -2 } };
		System.out.println(getResult(arr));
	}
}
