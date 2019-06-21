package dynamic_programming;
/*
 * 工人挖金库
 */
public class MostGold {
	// n表示 n个金库 ;w表示w个工人;
	// g[]表示每个金库可以得到多少钱;p[]表示挖每个金库需要多少人
	private static int[] getMostGold(int n, int w, int[] g, int[] p) {
		int[] lastRes = new int[w + 1];
		int[] res = new int[w + 1];
		for (int i = 0; i <= w; i++) {
			if (i < p[0]) {
				lastRes[i] = 0;
			} else {
				lastRes[i] = g[0];
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= w; j++) {
				if (j >= p[i]) {
					res[j] = Math.max(lastRes[j], lastRes[j - p[i]] + g[i]);
				} else {
					res[j] = lastRes[j];
				}
			}
			for(int t=1; t<=w; t++)
	        {
	            lastRes[t]=res[t];
	        }
			
		}

		return res;
	}

	public static void main(String[] args) {
		int g[] = { 400, 500, 200, 300, 350 };
		int p[] = { 5, 5, 3, 4, 3 };
		int[] res = getMostGold(5, 10, g, p);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
