package dynamic_programming;

/*
 * С͵ϴ�ٷ��ӣ�ÿ�������в�ͬ��ֵ�ı���,��������͵�����������͵�����ټ�ֵ�Ķ���
 */
public class StealTreasure {
	private static int[] stealMax(int arr[], int n) {
		int[] res = new int[n];
		// һ��ʼ��͵ȡn-1����
		res[n - 1] = arr[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				res[i] = Math.max(res[i], arr[j] + (j + 2 < n ? arr[j + 2] : 0));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 1, 2 };
		int[] res = stealMax(arr, 4);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
