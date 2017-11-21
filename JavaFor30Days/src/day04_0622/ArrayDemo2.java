package day04_0622;
//day04-12-数组的常见问题
public class ArrayDemo2 {

	public static void main(String[] args) {
		int[] arr=new int[3];
		//System.out.println(arr[3]); //访问到了数组不存在的索引时，会发生该异常（ArrayIndexOutofBoundsException）
		
		arr=null;
		System.out.println(arr[0]);//NullPointerException：当使用没有任何实体指向的引用型变量操作实体时，运行会发生该异常

	}

}
