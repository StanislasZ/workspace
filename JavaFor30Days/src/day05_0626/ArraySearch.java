package day05_0626;
//day05-25������ͨ���ҷ�ʽ��26-���ֲ��ҷ����۰���ң�
public class ArraySearch {

	public static void main(String[] args) {
		int[] arr={9,12,15,24,26,41,59,68,90};
		int key=90;
		System.out.println("index="+bisectionKey(arr,key));

	}

	//���ֲ��ҡ���Ҫ������
	/*
	public static int bisectionKey(int[] arr,int key){
		int left_index=0;
		int right_index=arr.length-1;
		int index;		
		while(1>0){
			index=(left_index+left_index)/2;    //��ѭ����   Ҳ��д��(left_index+left_index)>>1
			
			if(arr[index]==key)
				return index;
			else if(arr[index]<key)
				left_index=index+1;                
			else if(arr[index]>key)
				right_index=index-1;
		
			if(index==left_index||index==right_index)
				return -1;
		}
		
	}
	*/
	
	public static int bisectionKey(int[] arr,int key){
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
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//���ҡ�
	/*
	 ���󣺲���һ��Ԫ���������еĵ�һ�γ��ֵ�λ�á�
	 */
	
	public static int searchKey(int[] arr,int key){
		//��������
		for(int i=0;i<arr.length;i++){
			if(arr[i]==key)
				return i;
		}
		return -1;          //-1��������ǽǱ겻���ڵ����
	}
	//Ч�ʲ���
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
