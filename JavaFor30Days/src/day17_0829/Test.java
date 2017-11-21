package day17_0829;

import java.util.Arrays;

public class Test {
	private static final String SEPARATOR=" ";
	
	public static void main(String[] args) {
		/*
		 * ��ϰ��"23 10 -8 0 3 7 108"���ַ����е���ֵ�����������������һ����ֵ������ַ�����
		 * 
		 * ˼·��
		 * 1.���򣬶��Ҷ�������ֵ����
		 * 2.�����Ԫ�ض����ַ����У����ȡ����
		 * 3.��String��Ĺ��ܡ�����֮�䶼�ǿո��й���
		 * �����������ܣ�����Ƕ���ַ�����String[]  XXX.(String)
		 * 4.����ȡ�����ָ�ʽ���ַ���ת�����ִ洢�������С�
		 * 
		 */
		
	
		String numStr="23 10 -8 0 3 7 108";
		String[] numStrs=numStr.split(" ");
		
		String sortStr=sortNumberString(numStr);
		
		System.out.println(sortStr);
	}
	/**
	 * ��һ���ж����ֵ���ַ�����������ֵ������
	 * @param numStr
	 * @return
	 */
	public static String sortNumberString(String numStr) {
		//1.���������ַ����ֽ�ɶ�����ָ�ʽ���ַ���
		String[] numStrs=toStringArray(numStr);
		
		//2.���ַ�������ת��int����
		int[] nums=toIntArray(numStrs);
		
		//3.����������
		sort(nums);
		
		//4.��int����ת���ַ���
		return toString(nums);
		
		
	}
	/*
	 * ��int����ת���ַ���
	 */
	private static String toString(int[] nums) {
		//1.����һ���ַ���������
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<nums.length;i++){
			if(i!=nums.length){
				sb.append(nums[i]+SEPARATOR);
			}
			else
				sb.append(nums[i]);
		}
		return sb.toString();
		
	}
	/*
	 * ��int���������������
	 */
	private static void sort(int[] nums) {
		Arrays.sort(nums);
	}
	/*
	 * ���ַ�������ת��int���͵�����
	 */
	private static int[] toIntArray(String[] numStrs) {
		//1.����һ��int��������
		int[] nums=new int[numStrs.length];
		
		//2.����
		for(int i=0;i<numStrs.length;i++){
			//3.���ַ��������е�Ԫ��ͨ��parseIntת���󣬸�ֵ��int��������
			nums[i]=Integer.parseInt(numStrs[i]);
		}
		return nums;
	}
	/*
	 * ���ַ�������ָ���ķָ���ת���ַ�������
	 */
	private static String[] toStringArray(String numStr) {
		//ʹ���ַ�����split����
		
		return numStr.split(SEPARATOR);
		
	}

}
