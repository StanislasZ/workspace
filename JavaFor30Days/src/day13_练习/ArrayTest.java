package day13_练习;

import java.util.Arrays;

/*
 类中编写一个方法，搜索一个字符数组中是否存在某个字符，如果存在，则返回这个在字符数组中第一次出现的位置
 没找到就返回-1
 如果传入的数组为Null，应抛出IllegalArgumentException异常
 
 */


public class ArrayTest {
	public static void main(String[] args) {
		char[] arr={'a','b','c','a','b','c'};
		//arr=null;
		char key='e';
		
		System.out.println(searchChar(arr,key));

	}
	
	public static int searchChar(char[] arr,char key){
		if(arr==null)
			throw new IllegalArgumentException("数组为空");
		for(int i=0;i<arr.length;i++){
			if(arr[i]==key){
				return i;
			}
		}
		return -1;
	}
	

}
