package param;

public class ParamDemo {

	public static void main(String[] args) {
		
//		int sum=add(4,5);
//		int sum1=add(4,5,6);
		
//		int[] arr={43,2,10};
//		int sum=add(arr);
		
		
		int sum=add(3,5,7,4);
		System.out.println(sum);
		
	}
	/*
	 * 可变参数需要注意，只能定义在参数列表的最后。
	 */
	public static int add(int... arr){
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	
	
	
	/*
	public static int add(int[] arr){
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
	*/
	
	
	
	

	private static int add(int i, int j, int k) {
		return i+j+k;
	}

	private static int add(int i, int j) {
		return i+j;
	}

}
