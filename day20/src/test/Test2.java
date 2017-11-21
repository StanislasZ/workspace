package test;

public class Test2 {

	public static void main(String[] args) {
		Integer[] arr=new Integer[3];
		swap(arr,1,2);

	}
	
	public static <T> void swap(T[] arr,int x,int y){
		T temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	
	}
}
