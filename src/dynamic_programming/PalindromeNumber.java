package dynamic_programming;

/*
 * 一串英文 求有多少个回文数
 */
public class PalindromeNumber {
	private static int getNumber(String str) {
		int res = 0;
		boolean[][] dp = new boolean[str.length()][str.length()];

		for (int i = 1; i < str.length(); i++) {
			for (int j = 0; j < str.length() - i; j++) {
				if (str.charAt(j) == str.charAt(i + j)) {
					if (j + 1 < i + j - 1) {
						if (dp[j + 1][i + j - 1]) {
							dp[j][i + j] = true;
							res++;
						} else {
							dp[j][i + j] = false;
						}
					} else {
						dp[j][i + j] = true;
						res++;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String str = "aacasasddsewweqqrew";
		System.out.println(getNumber(str));
	}
}
