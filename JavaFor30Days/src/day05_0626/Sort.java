package day05_0626;
//day05-22-ѡ������23-ð�� 24-��������  ����ΪSort, �Զ��巽��Select,ð��Bubble
import java.util.*;
public class Sort {

	public static void main(String[] args) {
		/*
		 ���������
		 */
		
		int[] arr={12,5,77,6,8,1,111,3};
		printArray(arr);
		Select(arr);
		//Bubble(arr);
		
	  // Arrays.sort(arr);//java�ṩ�����򷽷�
		printArray(arr);
		
		
	}
	 
	public static void Select(int[] arr){           //ѡ�����򣺴�С����
		
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[i]){        //��ÿ�εĵ�һ����Ϊ��Сֵ��������ÿһ���Ƚϣ��и�С�ľͽ�����ÿ�εĵ�һ��������Сֵ
					swap(arr,j,i);
				}
			}
		}
	}
	
	
	

	public static void Bubble(int[] arr){   //ð�ݣ���С���� ֮ ÿһ�β���һ��������������
		int flag;
		for(int i=0;i<arr.length-1;i++){
			flag=0;
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					swap(arr,j,j+1);
					flag++;
				}
			}
			if(flag==0)break;           //�Ż��ˡ�  ���ĳ�ε���ѭ���У�һ��Ҳû��������˵��
			                            //�Ѿ��ź����ˣ���ֱ��������ѭ��
		}
		
		
		
		
	}
	
	
	//��ӡ����ķ���
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=arr.length-1)
				System.out.print(arr[i]+",");
			else
				System.out.println(arr[i]);
		}
	}
	
	//�������򷽷���λ���û������ظ������г�ȡ��
	public static void swap(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	
	
	
	
	
	
	
	
}


