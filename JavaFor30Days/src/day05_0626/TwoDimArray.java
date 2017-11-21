package day05_0626;
//day05-27-二维数组定义和内存图解
public class TwoDimArray {

	public static void main(String[] args) {
		//二维数组
		int[][] arr=new int[3][2];
		
		System.out.println(arr);  //[[I@15db9742    @是分隔符，右边是十六进制值（哈希值：实体在内存中的位置）
		                                 //左边是[[，二维数组，I是
		                         //二维数组实体
		
		System.out.println(arr[0]); //[I@6d06d69c   一维数组实体  一维I@ 内存中位置
		
		System.out.println(arr[0][0]);   //0     元素

		//
		int[][] array=new int[3][];   //明确了二维数组,没有明确具体的一维数组
		System.out.println(array);             //[[I@7852e922
		System.out.println(array[0]);       //null 
		//System.out.println(array[0][0]);   //java.lang.NullPointerException空指针， 指向nowhere
		
		
	}

}
