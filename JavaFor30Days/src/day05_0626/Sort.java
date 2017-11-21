package day05_0626;
//day05-22-选择排序23-冒泡 24-交换函数  类名为Sort, 自定义方法Select,冒泡Bubble
import java.util.*;
public class Sort {

	public static void main(String[] args) {
		/*
		 数组的排序
		 */
		
		int[] arr={12,5,77,6,8,1,111,3};
		printArray(arr);
		Select(arr);
		//Bubble(arr);
		
	  // Arrays.sort(arr);//java提供的排序方法
		printArray(arr);
		
		
	}
	 
	public static void Select(int[] arr){           //选择排序：从小到大
		
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[i]){        //把每次的第一个作为最小值，跟其他每一个比较，有更小的就交换。每次的第一个就是最小值
					swap(arr,j,i);
				}
			}
		}
	}
	
	
	

	public static void Bubble(int[] arr){   //冒泡：从小到大 之 每一次产生一个最大的在最上面
		int flag;
		for(int i=0;i<arr.length-1;i++){
			flag=0;
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					swap(arr,j,j+1);
					flag++;
				}
			}
			if(flag==0)break;           //优化了。  如果某次的内循环中，一个也没交换过，说明
			                            //已经排好序了，则直接跳出外循环
		}
		
		
		
		
	}
	
	
	//打印数组的方法
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=arr.length-1)
				System.out.print(arr[i]+",");
			else
				System.out.println(arr[i]);
		}
	}
	
	//发现排序方法，位置置换代码重复，进行抽取。
	public static void swap(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	
	
	
	
	
	
	
	
}


