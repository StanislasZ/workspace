package day04_0622;
//day04-02,03-void&return
public class MethodDemo2 {

	public static void main(String[] args) {
		/*
		 修饰符 返回值类型 函数名（参数类型 形式参数1，参数类型 形式参数2，………………）
		 {
		 	执行语句；
		 	return 返回值； //return关键字是用于**结束**该功能，并将后面的具体结果返回给调用者
		 }
		 
		 注意：如果函数返回值类型是void，return语句可以不写 
		 	  void表示的是没有返回值的情况。
		 
		 */
		
		/*
		 如何定义一个函数呢？
		 函数就是一个功能。
		 功能就需要两部分：
		 1.结果 2.未知内容
		 明确1：这个功能的结果是什么？
		 明确2：这个功能需要未知内容是什么？
		 */
		
		//需求：需要一个方法，进行加法运算，获取两个整数的和
		/*
		 明确1：功能的结果是什么？是一个和。和是整数，返回值的类型是int
		 明确2：功能的未知未知内容？加数和被加数，都是int，这就是参数列表
		 */
		int sum=add(2,3);
		System.out.println(sum);
	}
	
	public static int add(int a1,int a2){
		return a1+a2;
	
	}

	
	
	
	
	
	
	
	
	
	
}
