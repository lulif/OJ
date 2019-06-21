package dynamic_programming;

/*
 * 给一个正整数,将其分割成多个数字和，使其乘积最大(至少分成两个数)
 */
public class MaxProduct {
	private static int[] getMaxProduct(int n) {
		int[] arr = new int[n + 1];
		arr[1] = 1;
		//arr[i]表示分割i最大的乘积
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i - 1; j++) {
				arr[i] = Math.max(Math.max(arr[i], j * (i - j)), j * arr[i - j]);
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(getMaxProduct(10)[10]);
	}
}
