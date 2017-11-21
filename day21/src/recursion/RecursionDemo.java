package recursion;

public class RecursionDemo {

	public static void main(String[] args) {
		/*
		 * 递归：函数自身调用自身。函数内部又使用到了该函数功能。
		 * 什么时候使用？
		 * 功能被重复使用，但是每次该功能使用参与运算的数据不同时，可以考虑递归方式解决
		 * 
		 * 使用时，一定要定义条件
		 * 
		 * 
		 */
		int num=getSum(3);
		System.out.println("sum="+num);  //3+2+1
	}

	public static int getSum(int num){
		if(num==1)
			return 1;
		return num+getSum(num-1);
	}
	
	
}
