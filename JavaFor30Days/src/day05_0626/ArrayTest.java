package day05_0626;
//���鷴ת,  ��������
import java.util.*;
public class ArrayTest {

	public static void main(String[] args) {
		//int[] arr={23,14,88,5};
		
		/*
		int[] temp=new int[arr.length];
		
		for(int i=0;i<arr.length;i++)
			temp[arr.length-1-i]=arr[i];
		arr=temp;
		*/
		
		
		
		
		/*
		 ˼���⣺
		 �������������������в���һ��Ԫ�ز�������֤��������λ�ȡ��λ��
		 ˼·��
		 1.��Ȼ����������飬��������λ�ã�����Ҫ�뵽 ���ֲ��ҷ���
		 
		 */
		int[] arr={9,13,17,22,32,46,58,77};
		
		int index=Arrays.binarySearch(arr,8);
		System.out.println("index="+index);
		
		
		
		
		

	}

	public static void reverse(int[] arr){
		for(int start=0,end=arr.length;start<end;start++,end--){
			swap(arr,start,end);
		}
	}
	public static void swap(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	
	
	
	public static int binarysearch(int[] arr,int key){
		int left_index=0;
		int right_index=arr.length-1;
		int index;		
		while(left_index<=right_index){
			index=(left_index+left_index)/2;    //��ѭ����   Ҳ��д��(left_index+left_index)>>1
			
			if(arr[index]==key)
				return index;
			else if(arr[index]<key)
				left_index=index+1;                
			else if(arr[index]>key)
				right_index=index-1;
					
		}
		return left_index;
	}
	
	
	
	
	
}
