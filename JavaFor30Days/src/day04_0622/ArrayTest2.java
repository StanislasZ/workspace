package day04_0622;
//day04-15-��ֵ
public class ArrayTest2 {

	public static void main(String[] args) {
		/*
		 ���󣺻�ȡ������������ֵ
		 ˼·��
		 1.���ݶ���Ϊ�˱��ڲ������ȴ洢��������Ҫ������������ 
		 2.���������Ҫ���бȽϡ�ÿ�ζ��нϴ��������Ҫ��¼��������һ�����Ƚ�
		 3.�������е�Ԫ�ض���һ�顣��󣬾��������ֵ��
		 
		 ���裺
		 1.��Ҫ����
		 2.����һ��������¼ס�ϴ����
		 3.��������б�������ÿһ��Ԫ�ض��ͽϴ��ֵ���бȽϡ������������
		 */
		int[] arr={5,44,33};
		int max1=getmax(arr);
		int max2=getmax1(arr);
		System.out.println("����1�õ������ֵ��"+max1);
		System.out.println("����2�õ������ֵ��"+max2);
	}
	
	//�������ֵ����   ����1
	public static int getmax(int[] arr){
		int max=arr[0];   //��ʼ��Ϊ�����ڵ�����һ��Ԫ��
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}

	//��������
	public static void swap(int[] arr,int j){
		int temp=arr[j];
		arr[j]=arr[j+1];
		arr[j+1]=temp; 
		
	}
	//����2
	public static int getmax1(int[] arr){
		int max_index=0;    //��ʼ��Ϊ�����е�����һ������
		for(int i=1;i<arr.length;i++){
			if(arr[i]>arr[max_index]){
				max_index=i;
			}
		}
		return arr[max_index];
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

