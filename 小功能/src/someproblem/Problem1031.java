package someproblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Problem1031 {

	public static void main(String[] args) {

		/*
		 * 思路：从左往右输入数据到集合，用treeset 用自己定义的比较器
		 */

		Scanner in = new Scanner(System.in);

		int M, N, K;

		while (in.hasNext()) {
			M = in.nextInt();
			N = in.nextInt();
			K = in.nextInt();
			double[] sum = new double[N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					double temp = in.nextDouble();
					sum[j] = sum[j] + temp;
				}
			}

			TreeSet<Satisfication> ts = new TreeSet<>(new Comparator<Satisfication>() {

				@Override
				public int compare(Satisfication o1, Satisfication o2) {

					if (o1.value == o2.value) {

						if (o1.index > o2.index)
							return 1;
						else
							return -1;

					} else if (o1.value > o2.value)
						return -1;
					else
						return 1;

				}

			});

			for (int i = 1; i <= N; i++) {
				ts.add(new Satisfication(i - 1, sum[i - 1]));
			}

			// for (Iterator<Satisfication> it = ts.iterator(); it.hasNext();) {
			// Satisfication s =it.next();
			// System.out.println(s.index+1);
			// }

			int[] result = new int[K];
			for (int i = 0; i < K; i++) {
				result[i] = -(ts.pollFirst().index + 1);
			}
			Arrays.sort(result);

			for (int i = 0; i < K; i++) {
				if (i < K - 1) {
					System.out.print(-result[i] + " ");
				} else {
					System.out.println(-result[i]);
				}

			}
		}

	}

}

class Satisfication {
	int index;
	double value;

	public Satisfication(int index, double value) {
		super();
		this.index = index;
		this.value = value;
	}

}
