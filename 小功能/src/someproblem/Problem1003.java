package someproblem;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem1003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int counter = 1;
		while (counter <= N) {
			ArrayList<Integer> Mydata = new ArrayList<Integer>();
			int len = scanner.nextInt();
			for (int i = 0; i < len; ++i)
				Mydata.add(scanner.nextInt());

			ArrayList<Subarray> dp = new ArrayList<Subarray>();
			Subarray initial = new Subarray(0, 0, Mydata.get(0));// 初始化边界
			dp.add(initial);// 添加边界
			Subarray MaxSum = dp.get(0);
			for (int i = 1; i < len; ++i) {
				if (dp.get(i - 1).sum > 0) {
					Subarray current = new Subarray(dp.get(i - 1).low, i, dp.get(i - 1).sum + Mydata.get(i));
					dp.add(current);
				} else {
					Subarray current = new Subarray(i, i, Mydata.get(i));
					dp.add(current);
				}
				MaxSum = MaxSum.sum > dp.get(i).sum ? MaxSum : dp.get(i);
			}
			System.out.println("Case " + counter + ":");
			System.out.println(MaxSum.sum + " " + (MaxSum.low + 1) + " " + (MaxSum.high + 1));
			if (counter != N)
				System.out.println();
			counter++;
		}

	}

}

class Subarray {
	public int low, high, sum;

	public Subarray(int _l, int _h, int _s) {
		low = _l;
		high = _h;
		sum = _s;
	}
}
