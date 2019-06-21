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
			// ��֦ //���Ӽ�֦�Ľ����Time Limit Exceeded (>2s)
			// ����1 //�������1.2s //����ÿ��DFS�Ż�Ҳ��1.1s
			int lessAns = Math.abs(s.c - e.c) + Math.abs(s.r - e.r);
			if (lessAns % 2 != T % 2) { // ���һ��ʼ��ע��������ָ��ʱ�䵽�ԭ����ż��֦ԭ��
				System.out.println("NO");
				continue;
			}

			// ����2 //��������ȷʵ1.8s //����ÿ��DFS�Ż�ֻ��Ҫ0.4s //û�����ֻ��DFS�Ż�Ҫ1.1s
			if (T > n * m - wall - 1) // ���һ��ʼ��ע��������ָ��ʱ�䵽�ԭ�򣺸�����<Ŀ��ʱ��
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
				continue; // ��ʱ
			if (a < 0 || a >= n || b < 0 || b >= m)
				continue; // Խ��
			if (vis[a][b])
				continue; // ���ʹ�
			if (a == e.r && b == e.c) { 
				if (tt == T)
					yes = true; // �Ǵ�
				else
					continue; // �����ض���ʱ�䲻����
			}
			if (yes)
				return; // �Ѿ����˽��
			int tem = T - tt - Math.abs(a - e.r) - Math.abs(b - e.c); // ÿ��DFS����֦
			if (tem % 2 == 1) // �����������㣬ʱ��-��̾��� һ��==ż��
				// //��ż��֦ԭ����ʵ�൱��(T-tt)%2==(abs(x1-x2)+abs(y1-y2)%2)//����-����=ż�� ż��-ż��=ż��
				continue;

			vis[a][b] = true;
			dfs(a, b, tt);
			vis[a][b] = false;// ÿһ��·��Ӧ���ǲ�ͬ��vis
		}
	}

}
