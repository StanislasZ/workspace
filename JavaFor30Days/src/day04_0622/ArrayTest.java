package day04_0622;
//day04-14-数组的应用：求和
public class ArrayTest {

	public static void main(String[] args) {
		
		//获取多个数的和的功能
		/*
		 明确1：结果？和 int
		 明确2：参数？多个数，定义多个参数合适吗？既然是一组数，数组
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
	
	//冒泡排序，从小到大
	public static void maopao(int[] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-i-1;j++){           //每一次把大的留在最上面
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
