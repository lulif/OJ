package test;

import java.util.Scanner;

class Node {
	int r, c;

	Node(int a, int b) {
		r = a;
		c = b;
	}

	public Node() {
	}
}

public class Temp {

	static int n, m, T;
	static boolean vis[][];
	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean yes;
	static Node s = new Node(), e = new Node();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			n = sc.nextInt();
			m = sc.nextInt();
			T = sc.nextInt();
			sc.nextLine();
			if (n == 0 && m == 0 && T == 0)
				break;

			vis = new boolean[n][m];
			yes = false;
			int wall = 0;
			for (int i = 0; i < n; i++) {
				String ss = sc.nextLine();
				for (int j = 0; j < m; j++) {
					char c = ss.charAt(j);
					switch (c) {
					case 'X':
						vis[i][j] = true;
						wall++;
						break;
					case 'S':
						s = new Node(i, j);
						break;
					case 'D':
						e = new Node(i, j);
						break;
					case '.':
						break;
					default:
						break;
					}
				}
			}
			// 剪枝 //不加剪枝的结果是Time Limit Exceeded (>2s)
			// 方法1 //仅仅这个1.2s //加上每次DFS优化也就1.1s
			int lessAns = Math.abs(s.c - e.c) + Math.abs(s.r - e.r);
			if (lessAns % 2 != T % 2) { // 如果一开始就注定不能在指定时间到达，原因：奇偶剪枝原理
				System.out.println("NO");
				continue;
			}

			// 方法2 //仅仅这样确实1.8s //加上每次DFS优化只需要0.4s //没有这个只有DFS优化要1.1s
			if (T > n * m - wall - 1) // 如果一开始就注定不能在指定时间到达，原因：格子数<目标时间
			{
				System.out.println("NO");
				continue;
			}
			// DFS
			vis[s.r][s.c] = true; // !
			dfs(s.r, s.c, 0);
			if (yes) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	// AC
	private static void dfs(int r, int c, int t) {
		for (int i = 0; i < dir.length; i++) {
			int a = r + dir[i][0];
			int b = c + dir[i][1]; 
			int tt = t + 1;
			if (tt > T)
				continue; // 超时
			if (a < 0 || a >= n || b < 0 || b >= m)
				continue; // 越界
			if (vis[a][b])
				continue; // 访问过
			if (a == e.r && b == e.c) { 
				if (tt == T)
					yes = true; // 是答案
				else
					continue; // 不是特定的时间不可以
			}
			if (yes)
				return; // 已经有了结果
			int tem = T - tt - Math.abs(a - e.r) - Math.abs(b - e.c); // 每次DFS都剪枝
			if (tem % 2 == 1) // 对任意两个点，时限-最短距离 一定==偶数
				// //奇偶剪枝原理，其实相当于(T-tt)%2==(abs(x1-x2)+abs(y1-y2)%2)//奇数-奇数=偶数 偶数-偶数=偶数
				continue;

			vis[a][b] = true;
			dfs(a, b, tt);
			vis[a][b] = false;// 每一个路径应该是不同的vis
		}
	}

}
