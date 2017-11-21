package day16_0817;

import java.util.Arrays;

public class StringTest5 {
	public static void main(String[] args) {
		/*
		 需求5：对字符串中字符进行自然顺序排序。
		 思路：
		 	1.怎么能把字符串转成数组呢？（有方法）
		 	2.找方法
		 	3.将排序后的数组变成字符串 （有方法）
		 */

		String str="agewvddew";
		String sortString=sortChar(str);
		System.out.println(sortString);
		
	}

	public static String sortChar(String str) {
		//1.将字符串转成字符数组。
		char[] chs=stringToArray(str);
		
		//2.对数组排序
		sort(chs);
		
		//3.将数组转成字符串
		return tostring(chs);
	}

	private static String tostring(char[] chs) {
		return new String(chs);
	}

	private static char[] stringToArray(String str) {
		return str.toCharArray();
	}

	private static void sort(char[] chs) {
		Arrays.sort(chs);
		
	}

}
