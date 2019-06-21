package knapsack_problem;

/*
 * 0-1��������:һ�ѹ�ͷ,ÿ����ͷ������Ϊw[...],����Ϊv[...],
 *          ��һ��ֻ�ܷ�V��ô�ع�ͷ�ı���,�ʱ����й�ͷ��ֵ���Ϊ����
 */
public class MaxBone {

	private static int getMaxBone(int weight[], int value[], int v) {
		int[] dp = new int[v + 1];
		// �����õ�һ�Ź�ͷ
		for (int i = 0; i <= v; i++) {
			dp[i] = i >= weight[0] ? value[0] : 0;
		}

		for (int i = 1; i < weight.length; i++) {
			for (int j = v; j >= weight[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
			}
		}

		return dp[v];
	}

	public static void main(String[] args) {
		int[] weight = { 3, 5, 1, 2, 7, 4 };
		int[] value = { 5, 6, 2, 4, 8, 3 };
		int V = 15;
		System.out.println(getMaxBone(weight, value, V));
	}
}
