package day13_��ϰ;

import java.util.Arrays;

/*
 ���б�дһ������������һ���ַ��������Ƿ����ĳ���ַ���������ڣ��򷵻�������ַ������е�һ�γ��ֵ�λ��
 û�ҵ��ͷ���-1
 ������������ΪNull��Ӧ�׳�IllegalArgumentException�쳣
 
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
			throw new IllegalArgumentException("����Ϊ��");
		for(int i=0;i<arr.length;i++){
			if(arr[i]==key){
				return i;
			}
		}
		return -1;
	}
	

}
