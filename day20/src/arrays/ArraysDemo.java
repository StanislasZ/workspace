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
		
		//发现集合中本身有这个方法。contains
		//将数组转成集合。   
		List<String> list=Arrays.asList(strs);
		System.out.println(list.contains("nba"));
		
		/*
		 * 如果数组中都是引用数据类型，转成集合时，数组元素直接作为集合元素
		 * 如果数组中都是基本数据类型，会将数组对象作为集合中的元素。
		 */
		
		int[] arr={45,23,78,11,99};
		List<int[]> list2=Arrays.asList(arr);   //把数组作为一个元素存进去了
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
