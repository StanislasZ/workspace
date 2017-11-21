package day04_0622;
//day04-15-最值
public class ArrayTest2 {

	public static void main(String[] args) {
		/*
		 需求：获取多个整数中最大值
		 思路：
		 1.数据多了为了便于操作，先存储起来，需要容器。用数组 
		 2.多个数据需要进行比较。每次都有较大的数，需要记录下来和下一个数比较
		 3.将数组中的元素都比一遍。最后，就有了最大值。
		 
		 步骤：
		 1.需要数组
		 2.定义一个变量记录住较大的数
		 3.对数组进行遍历，让每一个元素都和较大的值进行比较。如果…………
		 */
		int[] arr={5,44,33};
		int max1=getmax(arr);
		int max2=getmax1(arr);
		System.out.println("方法1得到的最大值是"+max1);
		System.out.println("方法2得到的最大值是"+max2);
	}
	
	//返回最大值函数   方法1
	public static int getmax(int[] arr){
		int max=arr[0];   //初始化为数组内的任意一个元素
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}

	//交换函数
	public static void swap(int[] arr,int j){
		int temp=arr[j];
		arr[j]=arr[j+1];
		arr[j+1]=temp; 
		
	}
	//方法2
	public static int getmax1(int[] arr){
		int max_index=0;    //初始化为数组中的任意一个索引
		for(int i=1;i<arr.length;i++){
			if(arr[i]>arr[max_index]){
				max_index=i;
			}
		}
		return arr[max_index];
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

