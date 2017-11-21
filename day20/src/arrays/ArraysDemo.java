package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

	public static void main(String[] args) {
		
//		int[] arr={45,23,78,11,99};
//		
//		System.out.println(arr);
//		System.out.println(Arrays.toString(arr));
		
		String[] strs={"abc","haha","nba","zz"};
		
		//���ּ����б��������������contains
		//������ת�ɼ��ϡ�   
		List<String> list=Arrays.asList(strs);
		System.out.println(list.contains("nba"));
		
		/*
		 * ��������ж��������������ͣ�ת�ɼ���ʱ������Ԫ��ֱ����Ϊ����Ԫ��
		 * ��������ж��ǻ����������ͣ��Ὣ���������Ϊ�����е�Ԫ�ء�
		 */
		
		int[] arr={45,23,78,11,99};
		List<int[]> list2=Arrays.asList(arr);   //��������Ϊһ��Ԫ�ش��ȥ��
		System.out.println(list2.size());
		
		Integer[] arr1={45,23,78,11,99};
		List<Integer> list3=Arrays.asList(arr1);
		System.out.println(list3.get(0));

	}
	public static boolean myContains(String[] arr,String key){
		for (int i = 0; i < arr.length; i++) {
			String str=arr[i];
			
			if(str.equals(key)){
				return true;
			}
		}
		return false;
	}
	
	
	
	public static <T> void swap(T[] arr,int x,int y){
		T temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	
	}
}
