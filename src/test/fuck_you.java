package test;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

//import java.io.BufferedInputStream;
//import java.util.Arrays;
//import java.util.Scanner;
//hdoj 1166 Ïß¶ÎÊ÷
//public class Main {
//	private static int[] tree = new int[50005 * 2];
//	private static int[] arr = new int[50005];
//
//	private static void pushUpSectionSum(int rt) {
//		tree[rt] = tree[rt * 2] + tree[rt * 2 + 1];
//	}
//
//	private static void build(int l, int r, int rt) {
//		if (l == r) {
//			tree[rt] = arr[l];
//			return;
//		}
//		int m = (l + r) / 2;
//		build(l, m, rt * 2);
//		build(m + 1, r, rt * 2 + 1);
//		pushUpSectionSum(rt);
//	}
//
//	private static void update(int l, int r, int rt, int L, int C) {
//		if (l == r) {
//			tree[rt] += C;
//			return;
//		}
//		int m = (l + r) / 2;
//		if (L <= m) {
//			update(l, m, rt * 2, L, C);
//		} else {
//			update(m + 1, r, rt * 2 + 1, L, C);
//		}
//
//		pushUpSectionSum(rt);
//	}
//
//	private static int query(int l, int r, int rt, int L, int R) {
//		if (L <= l && r <= R) {
//			return tree[rt];
//		}
//		int ret = 0;
//		int m = (l + r) / 2;
//		if (L <= m)
//			ret += query(l, m, rt * 2, L, R);
//		if (m < R)
//			ret += query(m + 1, r, rt * 2 + 1, L, R);
//		return ret;
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(new BufferedInputStream(System.in));
//		int tt = sc.nextInt();
//		for (int w = 1; w <= tt; w++) {
//			System.out.println("Case " + w + ":");
//			int N = sc.nextInt();
//			for (int i = 1; i <= N; i++) {
//				arr[i] = sc.nextInt();
//			}
//			build(1, N, 1);
//			while (sc.hasNext()) {
//				String op = sc.next();
//				if (op.equals("End")) {
//					break;
//				}
//				if (op.equals("Query")) {
//					int res = query(1, N, 1, sc.nextInt(), sc.nextInt());
//					System.out.println(res);
//				}
//				if (op.equals("Add")) {
//					update(1, N, 1, sc.nextInt(), sc.nextInt());
//				}
//				if (op.equals("Sub")) {
//					update(1, N, 1, sc.nextInt(), -sc.nextInt());
//				}
//			}
//			Arrays.fill(tree, 0);
//			Arrays.fill(arr, 0);
//		}
//	}
//}
	
	/** 1166 c++
	#include<cstdio>
	#include<cstring>
	const int N = 50000+5;
	int tree[N<<2], a[N];
	void PushUp(int rt) {
	    tree[rt] = tree[rt<<1]+tree[rt<<1|1];
	}
	void Build(int l, int r, int rt){
	    if(l == r) {
	        tree[rt] = a[l];
	        return ;
	    }
	    int m = l+r >> 1;
	    Build(l, m, rt*2);
	    Build(m+1, r, rt*2+1);
	    PushUp(rt);
	}
	void Update(int l, int r, int rt, int L, int C){
	    if(l == r){
	        tree[rt] += C;
	        return ;
	    }
	    int m = l+r >> 1;
	    if(L <= m) Update(l, m, rt*2, L, C);
	    else Update(m+1, r, rt*2+1, L, C);
	    PushUp(rt);
	}
	int Query(int l, int r, int rt, int L, int R){
	    if(L <= l && r <= R) return tree[rt];
	    int ans = 0;
	    int m = l+r >> 1;
	    if(L <= m) ans += Query(l, m, rt*2, L, R);
	    if(m < R)  ans += Query(m+1, r, rt*2+1, L, R);
	    return ans;
	}
	int main()
	{
	    int t, n, x, y;
	    char str[100];
	    scanf("%d", &t);
	    for(int i = 1; i <= t; i++) {
	        printf("Case %d:\n", i);
	        int n;
	        scanf("%d", &n);
	        for(int i = 1; i <= n; i++) scanf("%d", &a[i]);
	        Build(1,n,1);
	        while(~scanf("%s", str) && strcmp(str,"End") != 0) {
	            scanf("%d%d", &x, &y);
	            if(str[0] == 'Q') printf("%d\n", Query(1, n, 1, x, y));
	            else if(str[0] == 'A') Update(1, n, 1, x, y);
	            else if(str[0] == 'S') Update(1, n, 1, x, -y);
	        }
	    }
	    return 0;
	}
	**/
//hdoj 1754 Ïß¶ÎÊ÷
// public class Main {
//	private static int[] tree = new int[(200000 + 5) * 2];
//	private static int[] arr = new int[200000 + 5];
//
//	private static void pushUpSectionMax(int rt) {
//		tree[rt] = Math.max(tree[rt * 2], tree[rt * 2 + 1]);
//	}
//
//	private static void build(int l, int r, int rt) {
//		if (l == r) {
//			tree[rt] = arr[l];
//			return;
//		}
//		int m = (l + r) / 2;
//		build(l, m, rt * 2);
//		build(m + 1, r, rt * 2 + 1);
//		pushUpSectionMax(rt);
//	}
//
//	private static void update(int l, int r, int rt, int L, int C) {
//		if (l == r) {
//			tree[rt] = C;
//			return;
//		}
//		int m = (l + r) / 2;
//		if (L <= m) {
//			update(l, m, rt * 2, L, C);
//		} else {
//			update(m + 1, r, rt * 2 + 1, L, C);
//		}
//		pushUpSectionMax(rt);
//	}
//
//	private static int query(int l, int r, int rt, int L, int R) {
//		if (L <= l && r <= R) {
//			return tree[rt];
//		}
//		int ret = 0;
//		int m = (l + r) / 2;
//		if (L <= m)
//			ret = Math.max(ret, query(l, m, rt * 2, L, R));
//		if (m < R)
//			ret = Math.max(ret, query(m + 1, r, rt * 2 + 1, L, R));
//		return ret;
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(new BufferedInputStream(System.in));
//		while (sc.hasNext()) {
//			int st_num = sc.nextInt();
//			int op_num = sc.nextInt();
//			for (int i = 1; i <= st_num; i++) {
//				arr[i] = sc.nextInt();
//			}
//			build(1, st_num, 1);
//			for (int i = 1; i <= op_num; i++) {
//				String op = sc.next();
//				if (op.equals("Q")) {
//					int res = query(1, st_num, 1, sc.nextInt(), sc.nextInt());
//					System.out.println(res);
//				}
//				if (op.equals("U")) {
//					update(1, st_num, 1, sc.nextInt(), sc.nextInt());
//				}
//			}
//			Arrays.fill(tree, 0);
//			Arrays.fill(arr, 0);
//		}
//	}
//}

/**hdoj 1754
#include<cstdio>
#include<algorithm>
using namespace std;
const int N = 200005;
int tree[N<<2], a[N];
void PushUp(int rt) {
    tree[rt] = max(tree[rt<<1], tree[rt<<1|1]);
}
void Build(int l, int r, int rt) {
    if(l == r) {
        tree[rt] = a[l];
        return ;
    }
    int m = l+r >>1;
    Build(l, m, rt*2);
    Build(m+1, r, rt*2+1);
    PushUp(rt);
}
void Update(int l, int r, int rt, int L, int C) {
    if(l == r) {
        tree[rt] = C;
        return;
    }
    int m = l+r >> 1;
    if(L <= m) Update(l, m, rt*2, L, C);
    else Update(m+1, r, rt*2+1, L, C);
    PushUp(rt);
}
int Query(int l, int r, int rt, int L, int R) {
    if(L <= l && r <= R)  {
        return tree[rt];
    }
    int ret = -N, m = l+r >> 1;
    if(L <= m) ret = max(ret, Query(l, m, rt*2, L, R));
    if(m < R) ret = max(ret, Query(m+1, r, rt*2+1, L, R));
    return ret;
}
int main()
{
    int n, m;
    char str[N];
    while(~scanf("%d%d", &n, &m)) {
        for(int i = 1; i <= n; i++)
            scanf("%d", &a[i]);
        Build(1,n,1);
        int i, j;
        while(m--) {
            scanf("%s%d%d", str, &i, &j);
            if(str[0] == 'Q'){
                if(i > j) swap(i, j);
                printf("%d\n", Query(1,n,1,i,j));
            }
            else if(str[0] == 'U')
                Update(1,n,1,i,j);
        }
    }
    return 0;
}
**/