package day16_0817;

import java.util.Arrays;

public class StringTest5 {
	public static void main(String[] args) {
		/*
		 ����5�����ַ������ַ�������Ȼ˳������
		 ˼·��
		 	1.��ô�ܰ��ַ���ת�������أ����з�����
		 	2.�ҷ���
		 	3.���������������ַ��� ���з�����
		 */

		String str="agewvddew";
		String sortString=sortChar(str);
		System.out.println(sortString);
		
	}

	public static String sortChar(String str) {
		//1.���ַ���ת���ַ����顣
		char[] chs=stringToArray(str);
		
		//2.����������
		sort(chs);
		
		//3.������ת���ַ���
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
