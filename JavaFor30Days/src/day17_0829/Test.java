package day17_0829;

import java.util.Arrays;

public class Test {
	private static final String SEPARATOR=" ";
	
	public static void main(String[] args) {
		/*
		 * 练习："23 10 -8 0 3 7 108"对字符串中的数值进行升序排序后，生成一个数值有序的字符串。
		 * 
		 * 思路：
		 * 1.排序，而且对整数数值排序
		 * 2.排序的元素都在字符串中，如何取出？
		 * 3.找String类的功能。数字之间都是空格。有规律
		 * 如果有这个功能，结果是多个字符串。String[]  XXX.(String)
		 * 4.将获取的数字格式的字符串转成数字存储到数组中。
		 * 
		 */
		
	
		String numStr="23 10 -8 0 3 7 108";
		String[] numStrs=numStr.split(" ");
		
		String sortStr=sortNumberString(numStr);
		
		System.out.println(sortStr);
	}
	/**
	 * 对一个有多个数值的字符串，进行数值的排序。
	 * @param numStr
	 * @return
	 */
	public static String sortNumberString(String numStr) {
		//1.将给定的字符串分解成多个数字格式的字符串
		String[] numStrs=toStringArray(numStr);
		
		//2.将字符串数组转成int数组
		int[] nums=toIntArray(numStrs);
		
		//3.对数组排序
		sort(nums);
		
		//4.将int数组转成字符串
		return toString(nums);
		
		
	}
	/*
	 * 将int数组转成字符串
	 */
	private static String toString(int[] nums) {
		//1.定义一个字符串缓冲区
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
	 * 对int数组进行升序排序
	 */
	private static void sort(int[] nums) {
		Arrays.sort(nums);
	}
	/*
	 * 将字符串数组转成int类型的数组
	 */
	private static int[] toIntArray(String[] numStrs) {
		//1.创建一个int类型数组
		int[] nums=new int[numStrs.length];
		
		//2.遍历
		for(int i=0;i<numStrs.length;i++){
			//3.将字符串数组中的元素通过parseInt转换后，赋值给int类型数组
			nums[i]=Integer.parseInt(numStrs[i]);
		}
		return nums;
	}
	/*
	 * 将字符串按照指定的分隔，转成字符串数组
	 */
	private static String[] toStringArray(String numStr) {
		//使用字符串的split功能
		
		return numStr.split(SEPARATOR);
		
	}

}
