package dynamic_programming;

/*
 * 走楼梯 每次走1步/2步 求走完n步 有几种不同的走法
 */
public class Way2Go {
	private static int way2Go(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		// return way2Go(n - 1) + way2Go(n - 2);
		int a = 1;
		int b = 2;
		int temp = 0;
		for (int i = 3; i <= n; i++) {
			temp = a + b;
			a = b;
			b = temp;
		}
		return temp;
	}

	public static void main(String[] args) {
		System.out.println(way2Go(10));
	}
}
