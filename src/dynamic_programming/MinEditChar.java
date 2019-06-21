package dynamic_programming;

/*
 * 两个字符串str1和str2，三个整数ic,dc,rc分别代表插入/删除/替换所要做出的代价,求str1编辑成str2的最小代价
 */
public class MinEditChar {

	private static int getMinEditCharCost(String str1, String str2, int ic, int dc, int rc) {
		// dp[0][0]表示 "" → "" 的代价(空字符串)
		// int[行][列]
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];
		// 第一行
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = ic * i;
		}
		// 第一列
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = dc * i;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				// dp[0][0]是空格 所以dp[1][1]才代表两个字符串的第一个字符
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = Math.min(Math.min(ic + dp[i][j - 1], dc + dp[i - 1][j]), dp[i - 1][j - 1]);
				} else {
					dp[i][j] = Math.min(Math.min(ic + dp[i][j - 1], dc + dp[i - 1][j]), dp[i - 1][j - 1] + rc);
				}
			}
		}
	return dp[str1.length()][str2.length()];

	}

	public static void main(String[] args) {
		String str1 = "ab12cd3";
		String str2 = "abcdf";
		int ic = 5;
		int dc = 3;
		int rc = 2;
		System.out.println(getMinEditCharCost(str1, str2, ic, dc, rc));
	}
}
