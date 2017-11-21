package day05_0626;
//day05-25数组普通查找方式，26-二分查找法（折半查找）
public class ArraySearch {

	public static void main(String[] args) {
		int[] arr={9,12,15,24,26,41,59,68,90};
		int key=90;
		System.out.println("index="+bisectionKey(arr,key));

	}

	//二分查找。（要求有序）
	/*
	public static int bisectionKey(int[] arr,int key){
		int left_index=0;
		int right_index=arr.length-1;
		int index;		
		while(1>0){
			index=(left_index+left_index)/2;    //在循环内   也可写成(left_index+left_index)>>1
			
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
			index=(left_index+left_index)/2;    //在循环内   也可写成(left_index+left_index)>>1
			
			if(arr[index]==key)
				return index;
			else if(arr[index]<key)
				left_index=index+1;                
			else if(arr[index]>key)
				right_index=index-1;
		
			
				
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//查找。
	/*
	 需求：查找一个元素在数组中的第一次出现的位置。
	 */
	
	public static int searchKey(int[] arr,int key){
		//遍历查找
		for(int i=0;i<arr.length;i++){
			if(arr[i]==key)
				return i;
		}
		return -1;          //-1，代表的是角标不存在的情况
	}
	//效率不高
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
