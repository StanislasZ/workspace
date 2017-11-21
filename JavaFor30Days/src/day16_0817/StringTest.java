package day16_0817;

/*
 
 */

public class StringTest {
	public static void main(String[] args) {
		String[] strs = { "nba", "abc", "cba", "haha", "qq" };

		printArray(strs);
		// 对字符串数组进行排序
		sort(strs);

		printArray(strs);

	}

	public static void sort(String[] strs) {
		for (int i = 0; i < strs.length - 1; i++) {
			for (int j = i + 1; j < strs.length; j++) {
				if (strs[i].compareTo(strs[j]) > 0) {
					swap(strs, i, j);
				}
			}
		}

	}

	private static void swap(String[] strs, int i, int j) {
		String temp=strs[i];
		strs[i]=strs[j];
		strs[j]=temp;
	}

	public static void printArray(String[] strs) {
		for (int i = 0; i < strs.length; i++) {
			if (i != strs.length - 1)
				System.out.print(strs[i] + ",");
			else
				System.out.println(strs[i]);
		}
	}

}
