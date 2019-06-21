package dynamic_programming;

/*
 * ��һ��������,����ָ�ɶ�����ֺͣ�ʹ��˻����(���ٷֳ�������)
 */
public class MaxProduct {
	private static int[] getMaxProduct(int n) {
		int[] arr = new int[n + 1];
		arr[1] = 1;
		//arr[i]��ʾ�ָ�i���ĳ˻�
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
