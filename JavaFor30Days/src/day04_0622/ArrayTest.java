package day04_0622;
//day04-14-�����Ӧ�ã����
public class ArrayTest {

	public static void main(String[] args) {
		
		//��ȡ������ĺ͵Ĺ���
		/*
		 ��ȷ1��������� int
		 ��ȷ2������������������������������𣿼�Ȼ��һ����������
		 */
		int[] arr={113,22,111};
		int sum=add(arr);
		
		maopao(arr);
		System.out.println("sum="+sum);
		
		for(int i=0;i<arr.length;i++)
			System.out.println("arr["+i+"]="+arr[i]);
	}
	public static int add(int[] arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
		}
		return sum;
	}
	
	//ð�����򣬴�С����
	public static void maopao(int[] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-i-1;j++){           //ÿһ�ΰѴ������������
				if(arr[j]>arr[j+1]){
					swap(arr,j);
 				}
			}
		}
		
	}
	
	
	public static void swap(int[] arr,int j){
		int temp=arr[j];
		arr[j]=arr[j+1];
		arr[j+1]=temp; 
		
	}
	
	
	
	
	
	
	
	
}
