package dynamic_programming;
/*
 * �����ڽ��
 */
public class MostGold {
	// n��ʾ n����� ;w��ʾw������;
	// g[]��ʾÿ�������Եõ�����Ǯ;p[]��ʾ��ÿ�������Ҫ������
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
