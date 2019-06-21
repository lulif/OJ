package test;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

public class hdoj {
	// hdoj 1003 最大子序列(需打印下标)
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(System.in);
	// int tt = sc.nextInt();
	// int caseNum = 1;
	// while (tt-- > 0) {
	// int left = 0;
	// int end = 0;
	// long sum = -1001;
	// long thisSum = 0;
	// int tempIndex = 0;
	// int len = sc.nextInt();
	// for (int i = 0; i < len; i++) {
	// thisSum += sc.nextInt();
	// if (thisSum > sum) {
	// sum = thisSum;
	// end = i;
	// left = tempIndex;
	// }
	// if (thisSum < 0) {
	// tempIndex = i + 1;
	// thisSum = 0;
	// }
	// }
	// System.out.println("Case " + caseNum + ":");
	// System.out.println(sum + " " + (left + 1) + " " + (end + 1));
	// caseNum++;
	// if (tt != 0)
	// System.out.println();
	// }
	// }

	// hdoj 1008 模拟
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(System.in);
	// while (true) {
	// int t = sc.nextInt();
	// if (t == 0) {
	// break;
	// }
	// int sum = 0;
	// List<Integer> list = new ArrayList<>();
	// for (int i = 0; i < t; i++) {
	// int n = sc.nextInt();
	// list.add(n);
	// }
	// sum += list.size() * 5;
	// int temp = list.get(0);
	// sum += temp * 6;
	// for (int i = 1; i < list.size(); i++) {
	// if (list.get(i) >= temp) {
	// sum += (list.get(i) - temp) * 6;
	// } else {
	// sum += (temp - list.get(i)) * 4;
	// }
	// temp = list.get(i);
	// }
	// System.out.println(sum);
	// list.clear();
	// }
	// }

	// hdoj 1015 dfs
	// public static void main(String[] arg) {
	// Scanner scan = new Scanner(new BufferedInputStream(System.in));
	// int target;
	// String inputStr;
	// ArrayList<String> answers = new ArrayList<>();
	// ArrayList<String> combinations = new ArrayList<>();
	// ArrayList<Character> com = new ArrayList<>(5);
	// while (true) {
	// target = scan.nextInt();
	// inputStr = scan.next();
	// if (target == 0 && inputStr.contentEquals("END")) {
	// break;
	// }
	// answers.clear();
	// combinations.clear();
	// com.clear();
	// // 获取所有的组合
	// getCombinations(combinations, inputStr.toCharArray(), 0, 5, com);
	// // 获取全排列
	// for (int i = 0; i != combinations.size(); i++) {
	// ArrayList<String> permutations = new ArrayList<>();
	// getAllPermutations(permutations, combinations.get(i).toCharArray(), 0,
	// combinations.get(i).length());
	// // 判断是否符合target函数，符合则放入answer
	// for (int j = 0; j != permutations.size(); j++) {
	// if (target(permutations.get(j), target)) {
	// answers.add(permutations.get(j));
	// }
	// }
	// }
	//
	// String answerCode = "";
	// for (int i = 0; i != answers.size(); i++) {
	// if (answers.get(i).compareTo(answerCode) >= 1) {
	// answerCode = answers.get(i);
	// }
	// }
	// if (answerCode.equals("")) {
	// System.out.println("no solution");
	// } else {
	// System.out.println(answerCode);
	// }
	// }
	// scan.close();
	// }
	//
	// static boolean target(String s, int target) {
	// char[] cs = s.toCharArray();
	// return (cs[0] - 'A' + 1) - Math.pow(cs[1] - 'A' + 1, 2) + Math.pow(cs[2] -
	// 'A' + 1, 3)
	// - Math.pow(cs[3] - 'A' + 1, 4) + Math.pow(cs[4] - 'A' + 1, 5) == target;
	// }
	//
	// static void getAllPermutations(ArrayList<String> answers, char[] cs, int
	// start, int len) {
	// if (start == len) {
	// answers.add(String.valueOf(cs));
	// return;
	// }
	// for (int i = start; i != len; i++) {
	// swap(cs, i, start);
	// getAllPermutations(answers, cs, start + 1, len);
	// swap(cs, i, start);
	// }
	// }
	//
	// static void getCombinations(ArrayList<String> list, char[] cs, int start, int
	// len, ArrayList<Character> com) {// len为组合的长度
	// if (len == 0) {
	// String s = "";
	// for (int i = 0; i != com.size(); i++) {
	// s = s.concat(com.get(i).toString());
	// }
	// list.add(s);
	// return;
	// }
	// if (start == cs.length) {
	// return;
	// }
	// com.add(cs[start]);
	// getCombinations(list, cs, start + 1, len - 1, com);
	// com.remove(com.size() - 1);
	// getCombinations(list, cs, start + 1, len, com);
	// }
	//
	// static void swap(char[] cs, int i, int j) {
	// char t;
	// t = cs[i];
	// cs[i] = cs[j];
	// cs[j] = t;
	// }
	//
	// // hdoj 1058 dp
	// public static void main(String[] args) {
	// int a, b, c, d;
	// a = b = c = d = 1;
	// int[] dp = new int[5842 + 1];
	// dp[1] = 1;
	// for (int i = 2; i <= 5842; ++i) {
	// dp[i] = Math.min(dp[a] * 2, Math.min(dp[b] * 3, Math.min(dp[c] * 5, dp[d] *
	// 7)));
	//
	// if (dp[i] == dp[a] * 2)
	// ++a;
	// if (dp[i] == dp[b] * 3)
	// ++b;
	// if (dp[i] == dp[c] * 5)
	// ++c;
	// if (dp[i] == dp[d] * 7)
	// ++d;
	// }
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (true) {
	// int t = sc.nextInt();
	// if (t == 0) {
	// break;
	// } else if (t % 10 == 1 && t % 100 != 11) {
	// System.out.println("The " + t + "st humble number is " + dp[t] + ".");
	// } else if (t % 10 == 2 && t % 100 != 12) {
	// System.out.println("The " + t + "nd humble number is " + dp[t] + ".");
	// } else if (t % 10 == 3 && t % 100 != 13) {
	// System.out.println("The " + t + "rd humble number is " + dp[t] + ".");
	// } else {
	// System.out.println("The " + t + "th humble number is " + dp[t] + ".");
	// }
	// }
	// }
	//
	// // hdoj 1421 dp
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (true) {
	// int n = sc.nextInt();
	// int k = sc.nextInt();
	// int[] arr = new int[n + 1];
	// for (int i = 1; i <= n; i++) {
	// arr[i] = sc.nextInt();
	// }
	// // 从小到大排序
	// Arrays.sort(arr, 1, n + 1);
	// // dp[i][j]表示前i件物品取j对的最优解
	// int[][] dp = new int[n + 1][k + 1];
	//
	// for (int j = 1; j <= k; j++) {
	// for (int i = 2 * j; i <= n; i++) {
	// dp[i][j] = dp[i - 2][j - 1] + (arr[i] - arr[i - 1]) * (arr[i] - arr[i - 1]);
	// if (i > 2 * j) {
	// dp[i][j] = Math.min(dp[i - 1][j],
	// dp[i - 2][j - 1] + (arr[i] - arr[i - 1]) * (arr[i] - arr[i - 1]));
	// }
	// }
	// }
	// System.out.println(dp[n][k]);
	// }
	// }
	//
	// // hdoj 1020 字符串
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// int t = sc.nextInt();
	// while (t-- > 0) {
	// String str = sc.next();
	// boolean hasFind = false;
	// int i = 0, j = i + 1;
	// for (; j < str.length();) {
	// if (str.charAt(i) == str.charAt(j)) {
	// j++;
	// hasFind = true;
	// continue;
	// } else if (hasFind) {
	// String str1 = str.substring(0, i);
	// String str2 = str.substring(j, str.length());
	// int num = j - i;
	// str = str1 + Integer.toString(num) + str.charAt(i) + str2;
	// hasFind = false;
	// i = i + 2;
	// j = i + 1;
	// } else {
	// i++;
	// j = i + 1;
	// }
	// }
	// if (hasFind) {
	// String str1 = str.substring(0, i);
	// String str2 = str.substring(j, str.length());
	// int num = j - i;
	// str = str1 + Integer.toString(num) + str.charAt(i) + str2;
	// }
	// System.out.println(str);
	// }
	// }
	//
	// // hdoj 1042 大数
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int n = sc.nextInt();
	// BigInteger sum = BigInteger.valueOf(1);
	// for (int i = 1; i <= n; i++) {
	// sum = sum.multiply(BigInteger.valueOf(i));
	// }
	// System.out.println(sum);
	// }
	// }
	//
	// // hdoj 1264 暴力
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// boolean[][] vis = new boolean[105][105];
	// int flag = 1;
	// while (true) {
	// while (sc.hasNext()) {
	// int[] arr = new int[4];
	// for (int i = 0; i < 4; i++) {
	// arr[i] = sc.nextInt();
	// }
	// if (arr[0] == -1 && arr[1] == -1 && arr[2] == -1 && arr[3] == -1) {
	// break;
	// }
	// if (arr[0] == -2 && arr[1] == -2 && arr[2] == -2 && arr[3] == -2) {
	// flag = 0;
	// break;
	// }
	// for (int i = Math.min(arr[0], arr[2]); i < Math.max(arr[0], arr[2]); i++) {
	// for (int j = Math.min(arr[1], arr[3]); j < Math.max(arr[1], arr[3]); j++) {
	// vis[i][j] = true;
	// }
	// }
	// }
	// int sum = 0;
	// for (int i = 0; i <= 100; i++) {
	// for (int j = 0; j <= 100; j++) {
	// if (vis[i][j]) {
	// sum++;
	// }
	// }
	// }
	// System.out.println(sum);
	// if (flag == 0) {
	// break;
	// }
	// }
	// }
	// // hdoj 1250 大数
	// private static BigInteger getFibonacci(int n) {
	// if (n == 1 || n == 2 || n == 3 || n == 4) {
	// return BigInteger.valueOf(1);
	// }
	// // return getFibonacci(n - 1).add(getFibonacci(n - 2)).add(getFibonacci(n -
	// // 3)).add(getFibonacci(n - 4));
	// BigInteger a = BigInteger.valueOf(1);
	// BigInteger b = BigInteger.valueOf(1);
	// BigInteger c = BigInteger.valueOf(1);
	// BigInteger d = BigInteger.valueOf(1);
	// BigInteger temp = null;
	// for (int i = 5; i <= n; i++) {
	// temp = a.add(b).add(c).add(d);
	// a = b;
	// b = c;
	// c = d;
	// d = temp;
	// }
	// return temp;
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int n = sc.nextInt();
	// System.out.println(getFibonacci(n));
	// }
	// }
	//
	// // hdoj 1231 序列最大值 (需打印出下标)
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (true) {
	// int num = sc.nextInt();
	// if (num == 0) {
	// break;
	// }
	// int[] arr = new int[num];
	// for (int i = 0; i < num; i++) {
	// arr[i] = sc.nextInt();
	// }
	// int start = 0, end = 0, max = -1001, tempMax = 0, tempIndex = 0;
	//
	// int isFu = 0;
	// for (int i = 0; i < arr.length; i++) {
	// if (arr[i] < 0) {
	// isFu++;
	// }
	// }
	//
	// if (isFu == arr.length) {
	// max = 0;
	// start = 0;
	// end = arr.length - 1;
	// } else {
	//
	// for (int i = 0; i < arr.length; i++) {
	// tempMax += arr[i];
	// if (tempMax > max) {
	// max = tempMax;
	// end = i;
	// start = tempIndex;
	// }
	// if (tempMax < 0) { // ←
	// tempIndex = i + 1;
	// tempMax = 0;
	// }
	// }
	//
	// }
	// System.out.println(max + " " + arr[start] + " " + arr[end]);
	// }
	// }
	//
	// // hdoj 1257 贪心
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int n = sc.nextInt();
	// int[] arr = new int[n];
	// for (int i = 0; i < n; i++) {
	// arr[i] = sc.nextInt();
	// }
	// List<Integer> daodanList = new ArrayList<>();
	// daodanList.add(arr[0]);
	// for (int i = 1; i < arr.length; i++) {
	// boolean isFind = false;
	// for (int j = 0; j < daodanList.size(); j++) {
	// if (daodanList.get(j) > arr[i]) {
	// daodanList.set(j, arr[i]);
	// isFind = true;
	// break;
	// }
	// }
	// if (!isFind) {
	// daodanList.add(arr[i]);
	// }
	// }
	// System.out.println(daodanList.size());
	// }
	// }
	//
	// // hdoj 2602 01背包
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// int tt = sc.nextInt();
	// while (tt-- > 0) {
	// int boneNum = sc.nextInt();
	// int bagW = sc.nextInt();
	// int[] boneV = new int[boneNum];
	// int[] boneW = new int[boneNum];
	// int[] dp = new int[bagW + 1];
	// for (int i = 0; i < boneNum; i++) {
	// boneV[i] = sc.nextInt();
	// }
	// for (int i = 0; i < boneNum; i++) {
	// boneW[i] = sc.nextInt();
	// }
	//
	// for (int i = 0; i <= bagW; i++) {
	// if (boneW[0] > i) {
	// dp[i] = 0;
	// } else {
	// dp[i] = boneV[0];
	// }
	// }
	//
	// for (int i = 1; i < boneNum; i++) {
	// for (int j = bagW; j >= boneW[i]; j--) {
	// dp[j] = Math.max(dp[j], dp[j - boneW[i]] + boneV[i]);
	// }
	// }
	// System.out.println(dp[bagW]);
	// }
	// }
	//
	// // hdoj 2026 首字母大写
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// String str = sc.nextLine();
	// String resStr = "";
	// String[] sSplit = str.split(" ");
	// for (int i = 0; i < sSplit.length; i++) {
	// String upper = sSplit[i].substring(0, 1).toUpperCase();
	// sSplit[i] = upper + sSplit[i].substring(1, sSplit[i].length());
	// }
	// for (int i = 0; i < sSplit.length - 1; i++) {
	// resStr += sSplit[i] + " ";
	// }
	// resStr += sSplit[sSplit.length - 1];
	// System.out.println(resStr);
	// }
	// }

	// hdoj 2037
	// public static void main(String[] args) {
	// Scanner in = new Scanner(System.in);
	// while (in.hasNextInt()) {
	// int n = in.nextInt();
	// if (n == 0) {
	// break;
	// }
	// // 电视节目总数
	// TV[] tvs = new TV[n];
	// for (int i = 0; i < n; i++) {
	// tvs[i] = new TV(in.nextInt(), in.nextInt());
	// }
	// // 按结束时间升序排序
	// Arrays.sort(tvs);
	// int k = 0;
	// int sum = 0;
	// for (int i = 0; i < n; i++) {
	// if (tvs[i].s >= k) {
	// sum++;
	// k = tvs[i].e;
	// }
	// }
	// System.out.println(sum);
	// }
	// }
	//
	// class TV implements Comparable<TV> {
	// int s;
	// int e;
	//
	// public TV(int s, int e) {
	// this.s = s;
	// this.e = e;
	// }
	//
	// @Override
	// public int compareTo(TV tv) {
	// return (e > tv.e) ? 1 : -1;
	// }
	// }

	// hdoj 3466 需先排序(有后效性)的 01背包
	// class Goods implements Comparable<Goods> {
	// int price;
	// int weight;
	// int value;
	//
	// public Goods(int price, int weight, int value) {
	// super();
	// this.price = price;
	// this.weight = weight;
	// this.value = value;
	// }
	//
	// @Override
	// public int compareTo(Goods o) {
	// // 对象从小到大排序
	// return (this.weight - this.price) - (o.weight - o.price);
	// }
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int tt = sc.nextInt();
	// int M = sc.nextInt();
	// Goods[] g = new Goods[tt];
	// int[] dp = new int[M + 1];
	// for (int i = 0; i < tt; i++) {
	// Goods good = new Main().new Goods(sc.nextInt(), sc.nextInt(), sc.nextInt());
	// g[i] = good;
	// }
	// Arrays.sort(g);
	// for (int i = 0; i <= M; i++) {
	// if (i < g[0].weight) {
	// dp[i] = 0;
	// } else {
	// dp[i] = g[0].value;
	// }
	// }
	//
	// for (int i = 1; i < tt; i++) {
	// for (int j = M; j >= g[i].weight; j--) {
	// dp[j] = Math.max(dp[j], dp[j - g[i].price] + g[i].value);
	// }
	// }
	//
	// System.out.println(dp[M]);
	// }

	// hdoj 1556 本来应该用线段树(这儿没用,这个更巧妙)
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int n = sc.nextInt();
	// if (n == 0)
	// break;
	// int res = 0;
	// int[] sum = new int[n + 50];
	// for (int i = 0; i < n; i++) {
	// int start = sc.nextInt();
	// int end = sc.nextInt();
	// sum[start]++;
	// sum[end + 1]--;
	// }
	// // 打印结果的时候再去 累加
	// for (int i = 1; i <= n; i++) {
	// res += sum[i];
	// System.out.print(res);
	// if (i != n) {
	// System.out.print(" ");
	// }
	// }
	// System.out.println();
	// }
	// }

	// hdoj 1455 DFS深度搜索
	// private static int n;
	// private static int stick_num;
	// private static int length;
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// n = sc.nextInt();
	// if (n == 0)
	// break;
	// boolean[] isVis = new boolean[n];
	// Integer[] arr = new Integer[n];
	// int sum = 0;
	// for (int i = 0; i < n; i++) {
	// Integer t = sc.nextInt();
	// arr[i] = t;
	// sum += t;
	// }
	// Arrays.sort(arr, new Comparator<Integer>() {
	// public int compare(Integer i1, Integer i2) {
	// return i2 - i1;
	// }
	// });
	//
	// for (int i = arr[0]; i <= sum; i++) {
	// if (sum % i == 0) {
	// stick_num = sum / i;
	// length = i;
	// // 假设完整棍子的长度,已经搜索了几根断棍,搜索第几根断棍,两个数组
	// if (dfs(length, 0, 0, isVis, arr)) {
	// System.out.println(length);
	// break;
	// }
	// }
	// }
	// }
	// }
	//
	// private static boolean dfs(int res, int num, int No, boolean[] isVis,
	// Integer[] arr) {
	// if (num == stick_num)
	// return true;
	//
	// for (int i = No; i < n; i++) {
	// if (isVis[i])
	// continue;
	//
	// isVis[i] = true;
	// if (arr[i] == res) {
	// if (dfs(length, num + 1, 0, isVis, arr))
	// return true;
	// } else if (arr[i] < res) {
	// if (dfs(res - arr[i], num, i + 1, isVis, arr))
	// return true;
	// }
	// isVis[i] = false;
	// // 未找到合适的
	// if (res == length)
	// return false;
	// // 剪枝
	// while (i + 1 < n && arr[i + 1] == arr[i])
	// i++;
	// }
	// return false;
	// }

	// hdoj 1248
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// int tt = sc.nextInt();
	// while (tt-- > 0) {
	// int N = sc.nextInt();
	// int[] price = { 150, 200, 350 };
	// int[] dp = new int[N + 1];
	// for (int i = 0; i < 3; i++) {
	// for (int m = price[i]; m <= N; m++) {
	// dp[m] = Math.max(dp[m], dp[m - price[i]] + price[i]);
	// }
	// }
	// System.out.println(N - dp[N]);
	// }
	//
	// }

	// hdoj 1114 完全背包(min)
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// int tt = sc.nextInt();
	// while (tt-- > 0) {
	// int num1 = sc.nextInt();
	// int num2 = sc.nextInt();
	// int V = num2 - num1;
	// int n = sc.nextInt();
	// int[][] arr = new int[n][2];
	// int[] dp = new int[V + 1];
	// for (int i = 0; i < n; i++) {
	// arr[i][0] = sc.nextInt();
	// arr[i][1] = sc.nextInt();
	// }
	//
	// for (int i = 0; i <= V; i++) {
	// dp[i] = 0x3F3F3F3F;
	// }
	// dp[0] = 0;
	//
	// for (int i = 0; i < n; i++)
	// for (int j = arr[i][1]; j <= V; j++)
	// dp[j] = Math.min(dp[j], dp[j - arr[i][1]] + arr[i][0]);
	//
	// if (dp[V] != 0x3F3F3F3F) {
	// System.out.println("The minimum amount of money in the piggy-bank is " +
	// dp[V] + ".");
	// } else {
	// System.out.println("This is impossible.");
	// }
	// }
	// }

	// hdoj 2159 完全背包(有限制)
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int n = sc.nextInt();
	// int m = sc.nextInt();
	// int k = sc.nextInt();
	// int s = sc.nextInt();
	// int[][] boss = new int[k][2];
	// int[] dp = new int[m + 1];
	// int[] cos = new int[m + 1];
	// for (int i = 0; i < k; i++) {
	// boss[i][0] = sc.nextInt();
	// boss[i][1] = sc.nextInt();
	// }
	//
	// for (int i = 0; i < k; i++) {
	// for (int j = boss[i][1]; j <= m; j++) {
	// if (dp[j] >= dp[j - boss[i][1]] + boss[i][0]) {
	// dp[j] = dp[j];
	// cos[j] = cos[j];
	// } else {
	// dp[j] = dp[j - boss[i][1]] + boss[i][0];
	// cos[j] = cos[j - boss[i][1]] + 1;
	// }
	// }
	// }
	//
	// boolean flag = false;
	// for (int i = 0; i < dp.length; i++) {
	//
	// if (dp[i] >= n && cos[i] <= s) {
	// flag = true;
	// System.out.println(m - i);
	// break;
	// }
	// }
	// if (!flag) {
	// System.out.println(-1);
	// }
	// }
	// }

	// hdoj 2191 多重背包
	// class Mi {
	// int price;
	// int weight;
	//
	// public Mi(int price, int weight) {
	// super();
	// this.price = price;
	// this.weight = weight;
	// }
	//
	// }
	//
	// public class Main {
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// int n = sc.nextInt();
	// while (n-- > 0) {
	// List<Mi> list = new ArrayList<Mi>();
	// int V = sc.nextInt();
	// int num = sc.nextInt();
	// int[] dp = new int[V + 1];
	// for (int i = 0; i < num; i++) {
	// Mi mi = new Mi(sc.nextInt(), sc.nextInt());
	// int number = sc.nextInt();
	// for (int k = 0; k < number; k++) {
	// list.add(mi);
	// }
	// }
	//
	// for (int i = 0; i <= V; i++) {
	// if (i >= list.get(0).price) {
	// dp[i] = list.get(0).weight;
	// }
	// }
	//
	// for (int i = 1; i < list.size(); i++) {
	// for (int j = V; j >= list.get(i).price; j--) {
	// dp[j] = Math.max(dp[j], dp[j - list.get(i).price] + list.get(i).weight);
	// }
	// }
	//
	// System.out.println(dp[V]);
	// }
	// }

	// hdoj 1062 字符串
	// private static String swap(String str) {
	// char[] cs = str.toCharArray();
	// for (int i = 0; i < str.length() / 2; i++) {
	// char temp = cs[i];
	// cs[i] = cs[str.length() - 1 - i];
	// cs[str.length() - 1 - i] = temp;
	// }
	// return new String(cs);
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// int n = sc.nextInt();
	// sc.nextLine();// 读取t后面的回车
	// for (int t = 0; t < n; t++) {
	// String str = sc.nextLine();
	// String[] split = str.split(" ");
	// String res = "";
	// for (int i = 0; i < split.length - 1; i++) {
	// String r = swap(split[i]);
	// res += r + " ";
	// }
	// String re = swap(split[split.length - 1]);
	// res += re;
	// System.out.println(res);
	//
	// for (int i = res.length(); i < str.length(); i++) {
	// System.out.print(" ");
	// }
	// }
	// }

	// hdoj 1004 字符串
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// Map<String, Integer> map = new HashMap<String, Integer>();
	// int n = sc.nextInt();
	// if (n == 0) {
	// break;
	// }
	// for (int i = 0; i < n; i++) {
	// String str = sc.next();
	// if (map.containsKey(str)) {
	// map.put(str, map.get(str) + 1);
	// } else {
	// map.put(str, 1);
	// }
	// }
	// String color = "";
	// int max = 0;
	// for (Entry<String, Integer> entry : map.entrySet()) {
	// if (entry.getValue() > max) {
	// color = entry.getKey();
	// max = entry.getValue();
	// }
	// }
	// System.out.println(color);
	// }
	// }

	// hdoj 1005 有规律循环 (感觉题目有点问题)
	// public static void main(String[] args) throws Exception {
	// Scanner cin = new Scanner(System.in);
	// int a = cin.nextInt();
	// int b = cin.nextInt();
	// int n = cin.nextInt();
	//
	// while (a != 0 && b != 0 && n != 0) {
	// System.out.println(fun(a, b, n % 48));
	// a = cin.nextInt();
	// b = cin.nextInt();
	// n = cin.nextInt();
	// }
	//
	// }
	//
	// public static int fun(int a, int b, int n) {
	// return (n == 1 || n == 2) ? 1 : (a * fun(a, b, n - 1) + b * fun(a, b, n - 2))
	// % 7;
	// }

	// hdoj 1012 水题
	// private static double deal(int n) {
	// double res = 1;
	// for (int i = 1; i <= n; i++) {
	// res *= i;
	// }
	// return 1f / res;
	// }
	//
	// public static void main(String[] args) {
	// System.out.println("n e");
	// System.out.println("- -----------");
	// System.out.println("0 1");
	// System.out.println("1 2");
	// System.out.println("2 2.5");
	// double sum = 2.5f;
	// for (int i = 3; i <= 9; i++) {
	// sum += deal(i);
	// System.out.printf("%d %.9f", i, sum);
	// System.out.println();
	// }
	// }

	// hdoj 1013 水题 字符串处理
	// private static int deal(char[] cs) {
	// int num = 0;
	// for (int i = 0; i < cs.length; i++) {
	// num += Integer.parseInt(String.valueOf(cs[i]));
	// new String();
	// }
	// if (num < 10) {
	// return num;
	// } else {
	// int temp = deal(Integer.toString(num).toCharArray());
	// return temp;
	// }
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// String n = sc.next();
	// if (n.equals("0")) {
	// break;
	// }
	// char cs[] = n.toCharArray();
	// int res = deal(cs);
	// System.out.println(res);
	// }
	// }

	// hdoj 1006 未解决 (要用角速度去算)
	// private static double getDistance(int i, int l, int r, double[][] arr) {
	// return Math.abs(arr[l][i] - arr[r][i]) <= 180 ? Math.abs(arr[l][i] -
	// arr[r][i])
	// : 360 - Math.abs(arr[l][i] - arr[r][i]);
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int D = sc.nextInt();
	// if (D == -1) {
	// break;
	// }
	// double mStep = 6.0;
	// double fStep = 0.1;
	// double sStep = 5.0 / 600.0;
	// double[][] arr = new double[3][43200 + 1];
	//
	// for (int i = 0; i < 43200; i++) {
	// arr[0][i + 1] = arr[0][i] + mStep;
	// if (arr[0][i + 1] == 360) {
	// arr[0][i + 1] = 0;
	// }
	// arr[1][i + 1] = arr[1][i] + fStep;
	// if (arr[1][i + 1] >= 360) {
	// arr[1][i + 1] = arr[1][i + 1] % 360.0;
	// }
	// arr[2][i + 1] = arr[2][i] + sStep;
	// }
	//
	// boolean m = false;
	// boolean f = false;
	// boolean s = false;
	// int tt = 0;
	// for (int i = 0; i <= 43200; i++) {
	// double d1 = getDistance(i, 0, 1, arr);
	// double d2 = getDistance(i, 0, 2, arr);
	// double d3 = getDistance(i, 1, 2, arr);
	// if (d1 >= D && d2 >= D) {
	// m = true;
	// }
	// if (d1 >= D && d3 >= D) {
	// f = true;
	// }
	// if (d2 >= D && d3 >= D) {
	// s = true;
	// }
	// if (m && f && s) {
	// tt++;
	// }
	// m = false;
	// f = false;
	// s = false;
	// }
	// double res = ((tt * 100) / 43200.0);
	// System.out.printf("%.3f", res);
	// System.out.println();
	//
	// }
	// }

	// hdoj 1016 dfs素数环
//	private static int tt = 1;
//	private static int[] arr = new int[21];
//	private static boolean[] isVis = new boolean[21];
//
//	private static boolean isPrime(int x) {
//		for (int i = 2; i < x; i++) {
//			if (x % i == 0) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	private static void dfs(int num, int index) {
//		if (index > num) {
//			for (int i = 1; i <= num - 1; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println(arr[num]);
//		}
//
//		for (int i = 2; i <= num; i++) {
//			if (!isVis[i]) {
//				if (!isPrime(i + arr[index - 1])) {
//					continue;
//				}
//				if (index == num) {
//					if (!isPrime(1 + i)) {
//						continue;
//					}
//				}
//				arr[index] = i;
//				isVis[i] = true;
//				dfs(num, index + 1);
//				arr[index] = 0;
//				isVis[i] = false;
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(new BufferedInputStream(System.in));
//		while (sc.hasNext()) {
//			int n = sc.nextInt();
//			arr[1] = 1;
//			isVis[1] = true;
//			System.out.println("Case " + tt + ":");
//			dfs(n, 2);
//			System.out.println();
//			tt++;
//			Arrays.fill(isVis, false);
//			Arrays.fill(arr, 0);
//		}
//
//	}

	// hdoj 1018 数学问题 (大数N！的位数)
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// int n = sc.nextInt();
	// for (int i = 0; i < n; i++) {
	// int num = sc.nextInt();
	// double m = 0;
	// for (int j = 1; j <= num; j++) {
	// m += Math.log10((double) j);
	// }
	// int res = (int) m + 1;
	// System.out.println(res);
	// }
	// }

	// hdoj 1009 贪心
	// class Exchange implements Comparable<Exchange> {
	// int javaBeans;
	// int catFood;
	// double x;
	//
	// public Exchange(int javaBeans, int catFood) {
	// super();
	// this.javaBeans = javaBeans;
	// this.catFood = catFood;
	// this.x = (double) catFood / javaBeans;
	//
	// }
	//
	// @Override
	// public int compareTo(Exchange o) {
	// // 从小到大:this大 返回1(正常的)那这就是从小到大
	// return this.x - o.x >= 0 ? 1 : -1;
	// }
	//
	// }
	//
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int M = sc.nextInt();
	// int N = sc.nextInt();
	// if (M == -1 && N == -1) {
	// break;
	// }
	// Exchange[] exArr = new Exchange[N];
	// for (int i = 0; i < N; i++) {
	// Exchange ex = new Exchange(sc.nextInt(), sc.nextInt());
	// exArr[i] = ex;
	// }
	// Arrays.sort(exArr);
	//
	// double res = 0.0;
	// for (int i = 0; i < N; i++) {
	// if (M < exArr[i].catFood) {
	// res += ((double) M / exArr[i].catFood) * exArr[i].javaBeans;
	// break;
	// } else {
	// res += exArr[i].javaBeans;
	// M = M - exArr[i].catFood;
	// }
	// }
	// System.out.printf("%.3f", res);
	// System.out.println();
	// }
	// }

	// hdoj 1010 DFS+奇偶剪枝

	// class Node {
	// int r, c;
	//
	// Node(int a, int b) {
	// r = a;
	// c = b;
	// }
	//
	// public Node() {
	// }
	// }
	//
	// public class Main {
	// static int n, m, T;
	// static boolean vis[][];
	// static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	// static boolean yes;
	// static Node s = new Node(), e = new Node();
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(System.in);
	// while (sc.hasNextLine()) {
	// n = sc.nextInt();
	// m = sc.nextInt();
	// T = sc.nextInt();
	// sc.nextLine();
	// if (n == 0 && m == 0 && T == 0)
	// break;
	//
	// vis = new boolean[n][m];
	// yes = false;
	// int wall = 0;
	// for (int i = 0; i < n; i++) {
	// String ss = sc.nextLine();
	// for (int j = 0; j < m; j++) {
	// char c = ss.charAt(j);
	// switch (c) {
	// case 'X':
	// vis[i][j] = true;
	// wall++;
	// break;
	// case 'S':
	// s = new Node(i, j);
	// break;
	// case 'D':
	// e = new Node(i, j);
	// break;
	// case '.':
	// break;
	// default:
	// break;
	// }
	// }
	// }
	// // 剪枝 //不加剪枝的结果是Time Limit Exceeded (>2s)
	// // 方法1 //仅仅这个1.2s //加上每次DFS优化也就1.1s
	// // int lessAns = Math.abs(s.c-e.c)+Math.abs(s.r-e.r);
	// // if(lessAns%2!=T%2){ //如果一开始就注定不能在指定时间到达，原因：奇偶剪枝原理
	// // System.out.println("NO");
	// // continue;
	// // }
	//
	// // 方法2 //仅仅这样确实1.8s //加上每次DFS优化只需要0.4s //没有这个只有DFS优化要1.1s
	// if (T > n * m - wall - 1) // 如果一开始就注定不能在指定时间到达，原因：格子数<目标时间
	// {
	// System.out.println("NO");
	// continue;
	// }
	// // DFS
	// vis[s.r][s.c] = true; // !
	// dfs(s.r, s.c, 0);
	// if (yes) {
	// System.out.println("YES");
	// } else {
	// System.out.println("NO");
	// }
	// }
	// }
	//
	// // AC
	// private static void dfs(int r, int c, int t) {
	// for (int i = 0; i < dir.length; i++) {
	// int a = r + dir[i][0];
	// int b = c + dir[i][1]; // 一开始写了2个r =。= 找了半天BUG
	// int tt = t + 1;
	// if (tt > T)
	// continue; // 超时
	// if (a < 0 || a >= n || b < 0 || b >= m)
	// continue; // 越界
	// if (vis[a][b])
	// continue; // 访问过
	// if (a == e.r && b == e.c) { // 这个r、c老是搞混
	// if (tt == T)
	// yes = true; // 是答案
	// else
	// continue; // 不是特定的时间不可以
	// }
	// if (yes)
	// return; // 已经有了结果
	// int tem = T - tt - Math.abs(a - e.r) - Math.abs(b - e.c); // 每次DFS都剪枝
	// if (tem % 2 == 1) // 对任意两个点，时限-最短距离 一定==偶数
	// // //奇偶剪枝原理，其实相当于(T-tt)%2==(abs(x1-x2)+abs(y1-y2)%2)//奇数-奇数=偶数 偶数-偶数=偶数
	// continue;
	//
	// vis[a][b] = true;
	// dfs(a, b, tt);
	// vis[a][b] = false;// 每一个路径应该是不同的vis
	// }
	// }
	// }

	// hdoj 1098 数学题 反证
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int k = sc.nextInt();
	// boolean isSuccess = false;
	// for (int a = 0; a <= 65; a++) {
	// if ((a * k + 18) % 65 == 0) {
	// System.out.println(a);
	// isSuccess = true;
	// }
	// }
	// if (!isSuccess) {
	// System.out.println("no");
	// }
	// }
	// }

	// hdoj 1031 贪心(各种排序)
	// 想使用优先队列 ,可以考虑把它搞成一个类 按此对象的某个属性排序
	// class Hui implements Comparable<Hui> {
	// int index;
	// double du;
	//
	// public Hui(int index, double du) {
	// super();
	// this.index = index;
	// this.du = du;
	// }
	//
	// @Override
	// public int compareTo(Hui o) {
	// if (o.du - this.du > 0) {
	// return 1;
	// }
	// if (o.du - this.du < 0) {
	// return -1;
	// }
	// //按两个属性排序(如果等于了则....)
	// if (o.du - this.du == 0) {
	// if (o.index - this.index < 0) {
	// return 1;
	// } else {
	// return -1;
	// }
	// }
	// return 0;
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	//
	// while (sc.hasNext()) {
	// Map<Integer, Double> map = new HashMap<Integer, Double>();
	// int N = sc.nextInt();
	// int M = sc.nextInt();
	// int K = sc.nextInt();
	// List<Hui> list = new ArrayList<Hui>();
	// List<Integer> res = new ArrayList<Integer>();
	// for (int i = 1; i <= N; i++) {
	// for (int j = 1; j <= M; j++) {
	// double t = sc.nextDouble();
	// if (map.containsKey(j)) {
	// map.put(j, map.get(j) + t);
	// } else {
	// map.put(j, t);
	// }
	// }
	// }
	// for (Entry<Integer, Double> e : map.entrySet()) {
	// Hui h = new Hui(e.getKey(), e.getValue());
	// list.add(h);
	// }
	//
	// Collections.sort(list);
	// for (int i = 0; i < K; i++) {
	// res.add(list.get(i).index);
	// }
	// res.sort(new Comparator<Integer>() {
	// @Override//list 数字从大到小
	// public int compare(Integer a, Integer b) {
	// return b - a > 0 ? 1 : -1;
	// }
	// });
	//
	// for (int i = 0; i < res.size() - 1; i++) {
	// System.out.print(res.get(i) + " ");
	// }
	// System.out.println(res.get(res.size() - 1));
	// }
	// }

	// hdoj 1052 田忌赛马 (贪心)
	/*
	 * 1.田忌最大的马大于国王最大的马，那么就胜场++ 2.田忌最大的马小于国王最大的马，那么就一定会输，所以用田忌最小的马输给国王最大的马
	 * 3.如果田忌最大的马等于国王最大的马，那么就比较最小的马 1)田忌最小的马大于国王最小的马，那么胜场++(双方最大马打平，最小马 田忌赢一把)
	 * 2)田忌最小的马小于等于国王最小的马，田忌最小的马和国王最大的马去比 ①如果国王最大的马大，那么财产要减200;
	 * ②如果田忌最小的马和国王最大的马一样大(双方打平)//有可能几匹马都是一样大小的
	 */
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int n = sc.nextInt();
	// if (n == 0)
	// break;
	// Integer[] tianMa = new Integer[n];
	// Integer[] guoMa = new Integer[n];
	// for (int j = 0; j < n; j++) {
	// tianMa[j] = sc.nextInt();
	// }
	// for (int j = 0; j < n; j++) {
	// guoMa[j] = sc.nextInt();
	// }
	// Comparator<Integer> cmp = new Comparator<Integer>() {
	// public int compare(Integer i1, Integer i2) {
	// return i2 - i1;
	// }
	// };
	// int res = 0;
	// Arrays.sort(tianMa, cmp);
	// Arrays.sort(guoMa, cmp);
	// int tianMin = n - 1;
	// int tianMax = 0;
	// int guoMin = n - 1;
	// int guoMax = 0;
	// while (tianMax <= tianMin && guoMax <= guoMin) {
	// if (tianMa[tianMax] > guoMa[guoMax]) {
	// res++;
	// tianMax++;
	// guoMax++;
	// } else if (tianMa[tianMax] < guoMa[guoMax]) {
	// tianMin--;
	// guoMax++;
	// res--;
	// } else {
	// // tianMa[tianMax]==guoMa[tianMax]
	// if (tianMa[tianMin] > guoMa[guoMin]) {
	// tianMin--;
	// guoMin--;
	// res++;
	// } else {
	// //tianMa[tianMin] <= guoMa[guoMin]→把田忌最小的马和国王最大的马去比
	//
	// if (tianMa[tianMin] < guoMa[guoMax]) {
	// res--;
	// }
	// //不管打平还是田忌输一把都要执行这些操作
	// tianMin--;
	// guoMax++;
	// }
	// }
	// }
	// System.out.println(res * 200);
	// }
	// }

	// hdoj 1081 最大子矩阵
	// private static int max;
	//
	// private static void maxSum(int arr[]) {
	// int temp = 0;
	// for (int t = 0; t < arr.length; t++) {
	// if (temp > 0) {
	// temp += arr[t];
	// } else {
	// temp = arr[t];
	// }
	// max = Math.max(max, temp);
	// }
	// }
	//
	// private static int getResult(int arr[][]) {
	// for (int i = 0; i < arr.length; i++) {
	// maxSum(arr[i]);
	// for (int j = i + 1; j < arr.length; j++) {
	// for (int k = 0; k < arr[0].length; k++) {
	// arr[i][k] += arr[j][k];
	// }
	// maxSum(arr[i]);
	// }
	// }
	// return max;
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while(sc.hasNext()) {
	// max=0;
	// int n = sc.nextInt();
	// int[][] m = new int[n][n];
	// for (int i = 0; i < n; i++) {
	// for (int j = 0; j < n; j++) {
	// m[i][j] = sc.nextInt();
	// }
	// }
	// System.out.println(getResult(m));
	// }
	// }

	// hdoj 1087 变向最长上升子序列(数据需累加)
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int n = sc.nextInt();
	// if (n == 0) {
	// break;
	// }
	// int[] arr = new int[n];
	// int[] dp = new int[n];
	// for (int i = 0; i < n; i++) {
	// int num = sc.nextInt();
	// arr[i] = num;
	// dp[i] = num;
	// }
	//
	// for (int i = 0; i < n; i++) {
	// int j = 0;
	// int tempMax = 0;
	// for (; j < i; j++) {
	// if (arr[j] < arr[i]) {
	// tempMax = Math.max(dp[j], tempMax);
	// }
	// }
	// dp[i] += tempMax;
	// }
	//
	// int res = 0;
	// for (int i = 0; i < n; i++) {
	// res = Math.max(res, dp[i]);
	// }
	// System.out.println(res);
	// }
	// }

	// hdoj 1875 最小生成树 Prim算法
	// class Land {
	// int x;
	// int y;
	//
	// public Land(int x, int y) {
	// super();
	// this.x = x;
	// this.y = y;
	// }
	// }
	//
	//
	// private static int n = 0;
	//
	// private static double getDis(Land land1, Land land2) {
	// return Math.sqrt((land1.x - land2.x) * (land1.x - land2.x) + (land1.y -
	// land2.y) * (land1.y - land2.y));
	// }
	//
	// private static double prim(double[][] map) {
	// double result = 0;
	// boolean[] isSelect = new boolean[105];
	// double[] edge = new double[105];
	//
	// int pos = 1;
	// isSelect[1] = true;
	// //计算此点到其他各个点的距离
	// for (int i = 1; i <= n; i++) {
	// if (pos != i) {
	// edge[i] = map[pos][i];
	// }
	// }
	//
	// for (int i = 1; i < n; i++) {
	// double min = 0x3f3f3f3f;
	// //这么多边里面选条最小的出来
	// for (int j = 1; j <= n; j++) {
	// if (!isSelect[j] && edge[j] < min) {
	// min = edge[j];
	// pos = j;
	// }
	// }
	// //没有最小的就告知失败
	// if (min == 0x3f3f3f3f) {
	// return -1;
	// } else {
	// result += min;
	// isSelect[pos] = true;
	//
	// for (int j = 1; j <= n; j++) {
	// //新添加的节点到一条边的距离<之前那些点到这条边的距离,那么就覆盖它
	// if (!isSelect[j] && map[pos][j]<edge[j]) {
	// edge[j] = map[pos][j];
	// }
	// }
	// }
	// }
	// return result;
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// int t = sc.nextInt();
	// for (int i = 0; i < t; i++) {
	//
	// n = sc.nextInt();
	// Land[] lands = new Land[n + 1];
	// double[][] map = new double[n + 1][n + 1];
	// for (int j = 1; j <= n; j++) {
	// Land land = new Land(sc.nextInt(), sc.nextInt());
	// lands[j] = land;
	// }
	//
	// for (int p = 1; p < n; p++) {
	// for (int q = p + 1; q <= n; q++) {
	// double dis = getDis(lands[p], lands[q]);
	// if (dis >= 10 && dis <= 1000) {
	// map[p][q] = map[q][p] = dis * 100;
	// } else {
	// map[p][q] = map[q][p] = 0x3f3f3f3f;
	// }
	// }
	// }
	//
	// double res = prim(map);
	// if (res < 0) {
	// System.out.println("oh!");
	// } else {
	// System.out.printf("%.1f", res);
	// System.out.println();
	// }
	// }
	// }

	// hdoj 2544 最短路径 dijkstra算法
	// private static int n, m;
	// private static int[][] dis = new int[1001][1001];
	//
	// private static void init() {
	// for (int i = 1; i <= n; i++) {
	// for (int j = 1; j <= n; j++) {
	// if (i == j) {
	// dis[i][j] = 0;
	// } else {
	// dis[i][j] = 0x3F3F3F3F;
	// }
	// }
	// }
	// }
	//
	// private static void dijkstra(int start, int end) {
	//
	// int[] tempDis = new int[1001];
	//
	// boolean[] isVis = new boolean[1001];
	// int next = start;
	//
	// for (int i = 1; i <= n; i++) {
	// tempDis[i] = dis[start][i];
	// }
	//
	// isVis[start] = true;
	// for (int i = 1; i <= n; i++) {
	// int min = 0x3F3F3F3F;
	// for (int j = 1; j <= n; j++) {
	// if (!isVis[j] && tempDis[j] < min) {
	// next = j;
	// min = tempDis[j];
	// }
	// }
	// isVis[next] = true;
	// for (int j = 1; j <= n; j++) {
	// if (!isVis[j]) {
	// if (tempDis[next] + dis[next][j] < tempDis[j]) {
	// tempDis[j] = tempDis[next] + dis[next][j];
	// }
	// }
	// }
	// }
	// System.out.println(tempDis[end]);
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// n = sc.nextInt();
	// m = sc.nextInt();
	// if (n == 0 && m == 0)
	// break;
	// init();
	// for (int i = 1; i <= m; i++) {
	// int p = sc.nextInt();
	// int q = sc.nextInt();
	// int d = sc.nextInt();
	// dis[p][q] = dis[q][p] = d;
	// }
	// dijkstra(1, n);
	// }
	// }

	// hdoj 3790 最短路径 1000个点 条件:距离+花费 下面代码TLE
	// private static int n, m;
	// private static int[][] cost = new int[1001][1001];
	// private static int[][] dis = new int[1001][1001];
	//
	// private static void init() {
	//
	// for (int i = 1; i <= n; i++) {
	// for (int j = 1; j <= n; j++) {
	// if (i == j) {
	// dis[i][j] = cost[i][j] = 0;
	// } else {
	// dis[i][j] = cost[i][j] = 0x3F3F3F3F;
	// }
	// }
	// }
	// }
	//
	// private static void dijkstra(int start, int end) {
	//
	// int[] tempDis = new int[1001];
	// int[] tempCost = new int[1001];
	//
	// boolean[] isVis = new boolean[1001];
	// int next = start;// next的初始化操作
	//
	// for (int i = 1; i <= n; i++) {
	// tempDis[i] = dis[start][i];
	// tempCost[i] = cost[start][i];
	// }
	//
	// isVis[start] = true;
	// for (int i = 1; i <= n; i++) {
	//
	// int min = 0x3F3F3F3F;
	// for (int j = 1; j <= n; j++) {
	// if (!isVis[j] && tempDis[j] < min) {
	// next = j;
	// min = tempDis[j];
	// }
	// }
	//
	// isVis[next] = true;
	// for (int j = 1; j <= n; j++) {
	// if (!isVis[j]) {
	//
	// if (tempDis[next] + dis[next][j] < tempDis[j]) {
	// tempDis[j] = tempDis[next] + dis[next][j];
	// tempCost[j] = tempCost[next] + cost[next][j];
	// }
	//
	// if (tempDis[next] + dis[next][j] == tempDis[j] && tempCost[next] +
	// cost[next][j] < tempCost[j]) {
	// tempCost[j] = tempCost[next] + cost[next][j];
	// }
	// }
	// }
	// }
	// System.out.println(tempDis[end] + " " + tempCost[end]);
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// n = sc.nextInt();
	// m = sc.nextInt();
	// if (n == 0 && m == 0)
	// break;
	// init();
	//
	// for (int i = 1; i <= m; i++) {
	// int p = sc.nextInt();
	// int q = sc.nextInt();
	// int d = sc.nextInt();
	// int e = sc.nextInt();
	// if (dis[p][q] > d || dis[q][p] > d) {//解决重边
	// dis[p][q] = dis[q][p] = d;
	// cost[p][q] = cost[q][p] = e;
	// }
	// if (dis[p][q] == d && cost[p][q] > p) {
	// cost[p][q] = cost[q][p] = e;
	// }
	//
	// }
	//
	// int start = sc.nextInt();
	// int end = sc.nextInt();
	// dijkstra(start, end);
	// }
	// }

	// hdoj 2066多源最短路径 floyed算法
	// private static int[][] map = new int[1005][1005];
	//
	// private static void init() {
	// for (int i = 0; i < 1005; i++)
	// for (int j = 0; j < 1005; j++) {
	// if (i == j) {
	// map[i][j] = 0;
	// } else {
	// map[i][j] = 0x3F3F3F3F;
	// }
	// }
	// }
	//
	// private static void floyed(int max_num) {
	// for (int i = 1; i <= max_num; i++)
	// for (int j = 1; j <= max_num; j++)
	// if (map[j][i] != 0x3F3F3F3F) { // 优化floyed
	// for (int t = 1; t <= max_num; t++) {
	// if (map[j][t] > map[j][i] + map[i][t]) {
	// map[t][j] = map[j][t] = map[j][i] + map[i][t];
	// }
	// }
	// }
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// init();
	// int T = sc.nextInt();
	// int S = sc.nextInt();
	// int D = sc.nextInt();
	// int max_num = -1;// 城市的数量
	//
	// for (int j = 0; j < T; j++) {
	// int a = sc.nextInt();
	// if (a > max_num) {
	// max_num = a;
	// }
	// int b = sc.nextInt();
	// if (b > max_num) {
	// max_num = b;
	// }
	// int time = sc.nextInt();
	// if (map[a][b] > time||map[b][a]>time) //重边判断
	// map[a][b] = map[b][a] = time;
	// }
	//
	// int[] city = new int[S + 1];
	// for (int i = 0; i < S; i++) {
	// city[i] = sc.nextInt();
	// }
	// floyed(max_num);
	//
	// int min = 0x3F3F3F3F;
	// for (int i = 0; i < D; i++) {
	// int end = sc.nextInt();
	// for (int j = 0; j < S; j++) {
	// if (map[city[j]][end] < min) {
	// min = map[city[j]][end];
	// }
	// }
	// }
	// System.out.println(min);
	// }
	// }

	// hdoj 1082 模拟+字符串处理
	// class Matrix {
	// int row;
	// int col;
	//
	// public Matrix(int row, int col) {
	// super();
	// this.row = row;
	// this.col = col;
	// }
	//
	// }
	//
	//
	// private static char[] init = new char[26];
	//
	// private static void init() {
	// int k = 0;
	// for (int i = 0; i < 26; i++) {
	// init[i] = (char) (97 + k);
	// k++;
	// }
	// }
	//
	// public static void main(String[] args) {
	// init();
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// Map<String, Matrix> map = new HashMap<String, Matrix>();
	// int n = sc.nextInt();
	// for (int i = 0; i < n; i++) {
	// String name = sc.next();
	// Matrix matrix = new Matrix(sc.nextInt(), sc.nextInt());
	// map.put(name, matrix);
	// }
	// sc.nextLine();
	// while (sc.hasNextLine()) {
	// String str = sc.nextLine();
	// if (!str.contains("(") && !str.contains(")")) {
	// System.out.println(0);
	// continue;
	// }
	// int res = 0;
	// boolean isError = false;
	// while (str.contains("(") && str.contains(")")) {
	// char[] cs = str.toCharArray();
	// int l = str.lastIndexOf("(");
	// int r = str.indexOf(")");
	// while (l > r) {
	// r = str.indexOf(")", r + 1);
	// }
	// Matrix m1 = map.get(String.valueOf(cs[l + 1]));
	// Matrix m2 = map.get(String.valueOf(cs[r - 1]));
	// if (m1.col != m2.row) {
	// System.out.println("error");
	// isError = true;
	// break;
	// }
	// res += m1.row * m1.col * m2.col;
	//
	// char temp = 'a';
	// for(int x=0;x<26;x++) {
	// if(str.contains(String.valueOf(init[x]))) {
	// continue;
	// }else {
	// temp=init[x];
	// }
	// }
	//
	// map.put(String.valueOf(temp), new Matrix(m1.row, m2.col));
	// String str1 = str.substring(0, l);
	// String str2 = str.substring(r + 1, str.length());
	// str = str1 + String.valueOf(temp) + str2;
	// }
	// if (!isError) {
	// System.out.println(res);
	// }
	// }
	// }
	// }

	// hdoj 2063 二分图最大匹配(匈牙利算法)
	// private static int[] boy = new int[510];
	// private static boolean[][] mix = new boolean[510][510];
	//
	// private static void init() {
	// for (int i = 0; i < 510; i++) {
	// boy[i] = 0;
	// for (int j = 0; j < 510; j++) {
	// mix[i][j] = false;
	// }
	// }
	// }
	//
	// // i表示第几个女生,n表示总共男生数
	// private static boolean hasCombine(int i, int n, boolean[] used) {
	// for (int k = 1; k <= n; k++) {
	// // 女孩中意男孩 且 这个男孩此轮中没被选择过
	// if (mix[i][k] && !used[k]) {
	// used[k] = true;
	// // 这个男孩没有和任何女孩组合或者其他女生可以把这个男生[腾]出来
	// if (boy[k] == 0 || hasCombine(boy[k], n, used)) {
	// boy[k] = i;
	// return true;
	// }
	// }
	// }
	// return false;
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int K = sc.nextInt();
	// if (K == 0) {
	// break;
	// }
	// init();
	// int M = sc.nextInt();
	// int N = sc.nextInt();
	// for (int i = 1; i <= K; i++) {
	// // 女孩中意男孩组合
	// mix[sc.nextInt()][sc.nextInt()] = true;
	// }
	//
	// int sum = 0;
	// // 给第i个女生匹配男生
	// for (int i = 1; i <= M; i++) {
	// // 每轮匹配中,男生是否被搜过(为什么时每轮?→每轮女孩可以肆无忌惮的去找男孩就算被匹配过的,大不了让别的女孩腾出来)
	// boolean[] used = new boolean[510];
	// if (hasCombine(i, N, used))
	// sum++;
	// }
	// System.out.println(sum);
	// }
	// }

	// hdoj 1392 凸包问题(Graham算法)(求凸包的周长)
	// class Node implements Comparable<Node> {
	// int x;
	// int y;
	//
	// public Node(int x, int y) {
	// super();
	// this.x = x;
	// this.y = y;
	// }
	//
	// @Override
	// public int compareTo(Node o) {
	// if (this.y > o.y || this.y == o.y && this.x > o.x) {
	// return 1;
	// } else {
	// return -1;
	// }
	// }
	// }
	//
	// /*
	// * 叉乘：p1Xp2如果小于零则说明 p1在p2的逆时针方向 如果大于零则说明 p1在p2的顺时针方向
	// */
	// private static double X(Node a, Node b) {
	// return a.x * b.y - a.y * b.x;
	// }
	//
	// // 节点相减
	// private static Node sub(Node a, Node b) {
	// return new Node(a.x - b.x, a.y - b.y);
	// }
	//
	// // 节点距离
	// private static double dis(Node a, Node b) {
	// Node c = sub(a, b);
	// return Math.sqrt(c.x * c.x + c.y * c.y);
	// }
	//
	// /*
	// * 当逆时针遍历凸包时，我们应该在每个顶点向左转。因此在循环时若发现在一个顶点处没有向左转，就把该顶点移除出去。
	// */
	// private static double multi(Node a, Node b, Node c) {
	// return X(sub(b, a), sub(c, a));
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int num = sc.nextInt();
	// if (num == 0) {
	// break;
	// }
	// Node[] nodes = new Node[num];
	// for (int i = 0; i < num; i++) {
	// nodes[i] = new Node(sc.nextInt(), sc.nextInt());
	// }
	// if (num == 1) {
	// System.out.println("0.00");
	// continue;
	// }
	// if (num == 2) {
	// System.out.printf("%.2f", dis(nodes[0], nodes[1]));
	// System.out.println();
	// continue;
	// }
	// // 找出最下左角的点
	// Arrays.sort(nodes);
	// // 节点按极角从小到大排序
	// Arrays.sort(nodes, new Comparator<Node>() {
	// @Override
	// public int compare(Node a, Node b) {
	// Node c = sub(a, nodes[0]);
	// Node d = sub(b, nodes[0]);
	// double x = X(c, d);
	// // x>0=>c在d顺时针(c和nodes[0]的极角度较小)
	// if (x > 0)
	// return -1;
	// // 距离短的排在前面
	// if (x == 0 && dis(a, nodes[0]) < dis(b, nodes[0]))
	// return -1;
	// return 1;
	// }
	// });
	// Node[] s = new Node[num];
	// s[0] = nodes[0];
	// s[1] = nodes[1];
	// int temp = 1;
	// for (int i = 2; i < num; i++) {
	// while (temp >= 1 && multi(s[temp - 1], s[temp], nodes[i]) <= 0)
	// temp--;
	// s[++temp] = nodes[i];
	// }
	// double res = 0.0;
	// for (int i = 0; i < temp; i++) {
	// res += dis(s[i], s[i + 1]);
	// }
	// res += dis(s[0], s[temp]);
	// System.out.printf("%.2f", res);
	// System.out.println();
	// }
	//
	// }

	// hdoj 2108 判断是否凸包
	// class Node{
	// int x;
	// int y;
	//
	// public Node(int x, int y) {
	// super();
	// this.x = x;
	// this.y = y;
	// }
	// }
	// private static int X(Node a, Node b) {
	// return a.x * b.y - a.y * b.x;
	// }
	// private static Node sub(Node a, Node b) {
	// return new Node(a.x - b.x, a.y - b.y);
	// }
	// private static int multi(Node a, Node b, Node c) {
	// return X(sub(b, a), sub(c, a));
	// }
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int t = 0;
	// int num = sc.nextInt();
	// if (num == 0) {
	// break;
	// }
	// Node[] nodes = new Node[num];
	// for (int i = 0; i < num; i++) {
	// nodes[i] = new Node(sc.nextInt(), sc.nextInt());
	// }
	//
	// for (int i = 0; i < num; i++) {
	// t = multi(nodes[i % num], nodes[(i + 1) % num], nodes[(i + 2) % num]);
	// if (t < -1)
	// break;
	// }
	// if (t >= 0) {
	// System.out.println("convex");
	// } else {
	// System.out.println("concave");
	// }
	// }

	// hdoj 3342 拓扑排序(使用队列)
	// private static void topo(int n, int[][] map, int[] inde) {
	// int num = 0;
	// Queue<Integer> queue = new LinkedList<Integer>();
	// for (int i = 0; i < n; i++) {
	// // 入度为0的入队列(没有master的prentice)
	// if (inde[i] == 0) {
	// queue.add(i);
	// num++;
	// }
	// }
	//
	// while (!queue.isEmpty()) {
	// int k = queue.poll();
	// for (int i = 0; i < n; i++) {
	// if (map[k][i] == 1) {
	// inde[i]--;
	// if (inde[i] == 0) {
	// queue.add(i);
	// num++;
	// }
	// }
	// }
	// }
	//
	// if (num == n) {
	// System.out.println("YES");
	// } else {
	// System.out.println("NO");
	// }
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// int N = sc.nextInt();
	// int M = sc.nextInt();
	// if (N == 0 && M == 0) {
	// break;
	// }
	// int[][] map = new int[N][N];
	// // 入度 拓扑关系:master→prentice
	// int[] inde = new int[N];
	//
	// for (int i = 0; i < M; i++) {
	// int master = sc.nextInt();
	// int prentice = sc.nextInt();
	// //先判0,防止同样数据多次建拓扑关系而对inde的影响
	// if (map[master][prentice] == 0) {
	// map[master][prentice] = 1;
	// // prentice的master数++
	// inde[prentice]++;
	// }
	// }
	// topo(N, map, inde);
	// }
	// }
	// hdoj 1069 dp 类似于最长上升子序列
	// private static Set<Block> set = new TreeSet<Block>();
	//
	// static class Block implements Comparable<Block> {
	// int length;
	// int width;
	// int height;
	//
	// public Block(int length, int width, int height) {
	// super();
	// this.length = length;
	// this.width = width;
	// this.height = height;
	// }
	//
	// @Override
	// public int compareTo(Block o) {
	// if (this.length == o.length)
	// if (this.width > o.width)
	// return -1;
	//
	// if (this.length > o.length) {
	// return -1;
	// }
	// return 1;
	// }
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// int tt = 1;
	// while (sc.hasNext()) {
	// int n = sc.nextInt();
	// if (n == 0) {
	// break;
	// }
	//
	// for (int i = 0; i < n; i++) {
	// int len = sc.nextInt();
	// int wid = sc.nextInt();
	// int hei = sc.nextInt();
	// set.add(new Block(len, wid, hei));
	// set.add(new Block(wid, len, hei));
	// set.add(new Block(len, hei, wid));
	// set.add(new Block(hei, len, wid));
	// set.add(new Block(wid, hei, len));
	// set.add(new Block(hei, wid, len));
	// }
	// Block[] blocks = new Block[set.size()];
	// int[] dp = new int[blocks.length];
	// set.toArray(blocks);
	// dp[0] = blocks[0].height;
	//
	// for (int i = 1; i < blocks.length; i++) {
	// int tempMax = 0;
	// for (int j = 0; j < i; j++) {
	// if (blocks[j].length > blocks[i].length && blocks[j].width > blocks[i].width)
	// tempMax = tempMax > dp[j] ? tempMax : dp[j];
	// }
	// dp[i] = blocks[i].height + tempMax;
	// }
	//
	// int res = 0;
	// for (int i = 0; i < blocks.length; i++)
	// res = dp[i] > res ? dp[i] : res;
	//
	// System.out.println("Case " + tt + ": maximum height = " + res);
	// set.clear();
	// tt++;
	// }
	// }

	// hdoj 1151 有向图的最小路径覆盖=>顶点数-最大匹配数
	// private static boolean[][] linked = new boolean[121][121];
	// private static int[] crossPath = new int[121];
	// private static int m, n;
	//
	// private static void init() {
	// for (int q = 0; q < 121; q++) {
	// crossPath[q] = 0;
	// for (int p = 0; p < 121; p++)
	// linked[p][q] = false;
	// }
	// }
	//
	// private static int maxMatch() {
	// int count = 0;
	// for (int i = 1; i <= m; i++) {
	// boolean[] isVis = new boolean[m + 1];
	// if (search(i, isVis)) {
	// count++;
	// }
	// }
	// return count;
	// }
	//
	// private static boolean search(int u, boolean[] isVis) {
	// for (int i = 1; i <= m; i++) {
	// if (linked[i][u] && !isVis[i]) {
	// isVis[i] = true;
	// if (crossPath[i] == 0 || search(crossPath[i], isVis)) {
	// crossPath[i] = u;
	// return true;
	// }
	// }
	// }
	// return false;
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// int tt = sc.nextInt();
	// for (int i = 0; i < tt; i++) {
	// init();
	// m = sc.nextInt();
	// n = sc.nextInt();
	// for (int j = 0; j < n; j++) {
	// int a = sc.nextInt();
	// int b = sc.nextInt();
	// linked[a][b] = true;
	// }
	// System.out.println(m - maxMatch());
	// }
	// }

	// hdoj 1503 最长公共子序列
	// private static int[][] mark = new int[110][110];
	// private static int[][] dp = new int[110][110];
	// private static String str1, str2;
	//
	// private static void print(int x, int y) {
	// if (x == 0 && y == 0)
	// return;
	// else if (mark[x][y] == 0) {
	// print(x - 1, y - 1);
	// System.out.print(str1.charAt(x - 1));
	// } else if (mark[x][y] == 1) {
	// print(x - 1, y);
	// System.out.print(str1.charAt(x - 1));
	// } else if (mark[x][y] == -1) {
	// print(x, y - 1);
	// System.out.print(str2.charAt(y - 1));
	// }
	// }
	//
	// private static void init() {
	// for (int i = 0; i < 110; i++)
	// for (int j = 0; j < 110; j++) {
	// mark[i][j] = 0;
	// dp[i][j] = 0;
	// }
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// while (sc.hasNext()) {
	// init();
	//
	// str1 = sc.next();
	// str2 = sc.next();
	//
	// for (int i = 0; i < str1.length(); i++)
	// mark[i][0] = 1;
	// for (int i = 0; i < str2.length(); i++)
	// mark[0][i] = -1;
	//
	// for (int i = 1; i <= str1.length(); i++)
	// for (int j = 1; j <= str2.length(); j++)
	// if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
	// dp[i][j] = dp[i - 1][j - 1] + 1;
	// mark[i][j] = 0;
	// } else if (dp[i - 1][j] >= dp[i][j - 1]) {
	// dp[i][j] = dp[i - 1][j];
	// mark[i][j] = 1;
	// } else {
	// dp[i][j] = dp[i][j - 1];
	// mark[i][j] = -1;
	// }
	//
	// print(str1.length(), str2.length());
	// System.out.println();
	// }
	// }

	// hdoj 2588 欧拉函数
	// /*
	// * 设s为gcd(x,n)
	// * 要求gcd(x,n)>=m => s>=m
	// * 因为s为最大公约数
	// * 所以定存在a,b使s*a=x;s*b=n 且 gcd(a,b)==1 即a,b互质
	// * 因为x<=n 所以 a<=b
	// * 现在要算x的个数只需枚举s求a的个数即可,而a的个数可以通过b的欧拉值(互质)求出来 (ps：b=n/s)
	// */
	// private static long Euler(long n) {
	// long res = n;
	// for (long i = 2; i * i <= n; i++) {
	// if (n % i == 0)
	// res = res / i * (i - 1);
	// while (n % i == 0)
	// n /= i;
	// }
	// if (n > 1)
	// res = res / n * (n - 1);
	// return res;
	// }
	//
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(new BufferedInputStream(System.in));
	// int num = sc.nextInt();
	// for (int i = 1; i <= num; i++) {
	// int res = 0;
	// int n = sc.nextInt();
	// int m = sc.nextInt();
	// for (int s = 1; s * s <= n; s++) {
	// if (n % s == 0) { // 是必须是n的一个约数
	// // 一个约数 →s
	// if (s >= m) {
	// res += Euler(n / s);// n/s→b
	// }
	// // 另一个约数 →n/s
	// int t = n / s;
	// if (s * s != n && t >= m) {
	// res += Euler(n / t);
	// }
	// }
	// }
	// System.out.println(res);
	// }
	// }
	// poj 1753 状态压缩
	private static char[][] map = new char[6][6];
	private static int[][] vis = new int[6][6];
	private static int res = 17;
	private static int[] disx = { 0, 1, 0, -1, 0 };
	private static int[] disy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		while (sc.hasNext()) {
			for (int i = 1; i <= 4; i++) {
				String str = sc.next();
				for (int j = 0; j < str.length(); j++) {
					map[i][j + 1] = str.charAt(j);
				}
			}
			for (int i = 0; i < 16; i++) {
				dfsw(i);
				dfsb(i);
			}
			if (res == 17) {
				System.out.println("Impossible");
			} else {
				System.out.println(res);
			}
		}
	}

	private static void dfsw(int h) {
		int ans = 0;

		for (int i = 1; i <= 4; i++) // 每次dfs之前都要初始化
		{
			for (int j = 1; j <= 4; j++) {
				vis[i][j] = 0;
			}
		}

		for (int i = 1; i <= 4; i++) {// 第一行翻不翻的15种情况
			if ((h & 1) == 1) {
				vis[1][i] = 1;
				ans++;
			}
			h = h >> 1;
		}

		for (int i = 2; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (isBlack(i - 1, j)) { // 判断上一行对应位是不是黑色的
					vis[i][j] = 1;
					ans++;
				}
			}
		}

		for (int i = 1; i <= 4; i++) {
			if (isBlack(4, i)) {// 最后一行还有黑的 就return即这种情况不行
				return;
			}
		}

		if (ans < res)
			res = ans;
		return;
	}

	private static boolean isBlack(int i, int j) {
		int n = 0;
		if (map[i][j] == 'b') { // map中存的是最初的黑/白状态
			n++;
		}
		for (int t = 0; t < 5; t++) { // 至于具体现在怎么是黑白还要根据周围是否翻过
			if (vis[i + disx[t]][j + disy[t]] == 1) {
				n++;
			}
		}
		if (n % 2 == 1)
			return true;
		else
			return false;
	}

	private static void dfsb(int h) {

		int ans = 0;

		for (int i = 1; i <= 4; i++) // 每次dfs之前都要初始化
		{
			for (int j = 1; j <= 4; j++) {
				vis[i][j] = 0;
			}
		}

		for (int i = 1; i <= 4; i++) {
			if ((h & 1) == 1) {
				vis[1][i] = 1;
				ans++;
			}
			h >>= 1;
		}

		for (int i = 2; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (!isBlack(i - 1, j)) {
					vis[i][j] = 1;
					ans++;
				}
			}
		}

		for (int i = 1; i <= 4; i++) {
			if (!isBlack(4, i)) {
				return;
			}
		}

		if (ans < res)
			res = ans;
		return;
	}

}