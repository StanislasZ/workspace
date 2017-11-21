package day07_0630;
//day07-15-静态代码块

/*
 静态代码块：随着类的加载而执行。而且只执行一次
 
 作用：给类进行初始化的。
 
 应用场景：类不需要创建对象。但是需要初始化，这是将部分代码存储到静态代码块中。
 */
class StaticCode{
	static int num;
	static{
		num=1;
		System.out.println("A");
	}
	static void show(){
		System.out.println("show run");
	}
}





public class StaticCodeDemo0704 {
	static{
		System.out.println("B");
	}
	public static void main(String[] args) {
		StaticCode.show();
		StaticCode.show();
	}
	static{
		System.out.println("C");
	}
}


