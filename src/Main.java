import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	static boolean[] isVis = new boolean[105];
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		while (sc.hasNext()) {
			int tt = sc.nextInt();
			for (int i = 0; i < tt; i++) {
				map.clear();
				Arrays.fill(isVis, false);
				int num = sc.nextInt();
				for (int j = 1; j <= num; j++) {
					List<Integer> list = new ArrayList<Integer>();
					while (true) {
						int number = sc.nextInt();
						if (number == 0) {
							break;
						}
						list.add(number);
					}
					map.put(j, list);
				}
				List<Map.Entry<Integer, List<Integer>>> l = new ArrayList<>(map.entrySet());
				Collections.sort(l, new Comparator<Map.Entry<Integer, List<Integer>>>() {
					public int compare(Map.Entry<Integer, List<Integer>> o1, Map.Entry<Integer, List<Integer>> o2) {
						if (o1.getValue().size() > o2.getValue().size()) {
							return -1;
						} else {
							return 1;
						}
					}
				});
				int res = 0;
				for (Map.Entry<Integer, List<Integer>> entry : l) {
					if (!isVis[entry.getKey()]) {
						isVis[entry.getKey()] = true;
						res++;
					}
					nodify(entry.getValue());
				}

				for (int m = 1; m < num; m++) {
					if (!isVis[m]) {
						res++;
					}
				}
				System.out.println(res);
			}
		}
	}

	private static void nodify(List<Integer> value) {
		for (Integer m : value) {
			if (!isVis[m]) {
				isVis[m] = true;
				nodify(map.get(m));
				res++;
			}
		}

	}

}