package dynamic_programming;

/*
 * 从矩阵的左上角走到右下角，走过路径最小值
 */
public class MinimalPath {
	private static int getMinPath(int arr[][]) {
			int len=arr.length;
			int[][] dp = new int[len][len];
			dp[0][0] = arr[0][0];
			// 第一行
			for (int i = 1; i < arr[0].length; i++) {
				dp[0][i] = arr[0][i] + dp[0][i - 1];
			}
			// 第一列
			for (int i = 1; i < arr.length; i++) {
				dp[i][0] = arr[i][0] + dp[i - 1][0];
			}
	
			for (int i = 1; i < arr.length; i++) {
				for (int j = 1; j < arr[0].length; j++) {
					dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
	
			return dp[len-1][len-1];
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		System.out.println(getMinPath(arr));
	}
}
