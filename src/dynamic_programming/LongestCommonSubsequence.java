package dynamic_programming;

/*
 * 两个字符串的最长公共子序列
 */
public class LongestCommonSubsequence {

	private static int getLongestLength(String str1, String str2) {

		int[][] dp = new int[str1.length()][str2.length()];
		// 第一行
		for (int i = 0; i < dp[0].length; i++) {
			if (str1.charAt(0) == str2.charAt(i)) {
				//一旦有一个是1 那么后面的都是1
				for (int k = i; k < dp[0].length; k++) {
					dp[0][k] = 1;
				}
				break;
			}
		}

		// 第一列
		for (int i = 0; i < dp.length; i++) {
			if (str2.charAt(0) == str1.charAt(i)) {
				for (int k = i; k < dp.length; k++) {
					dp[k][0] = 1;
				}
				break;
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[str1.length() - 1][str2.length() - 1];
	}

	public static void main(String[] args) {
		String str1 = "AAACCGTGAGTTATTCGTTCTAGAA";
		String str2 = "CACCCCTAAGGTACCTTTGGTTC";
		System.out.println(getLongestLength(str1, str2));
	}
}
