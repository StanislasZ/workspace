package day10_0717;   //60-内部类，61-非静态内部类，62-静态内部类
/*
 内部类：
 	其实是将类定义到了另一个类的内部.
 	A类要直接访问B类中的成员时，可以将A类定义到B类中，作为 B类的内部类存在。
 	
 访问规则：
 	内部类可以直接访问外部类中的成员（包括变量和函数）
 	外部类要想访问内部类，只能创建内部类的对象来访问。
 */

class Outer{
	private static int num=4;
	class Inner{//内部类  相当于外部类中的一个成员。它就可以被成员修饰符所修饰。 public private static
		static final int count=5;
		void show(){
			System.out.println(num);  //外部类的num是私有也能访问
		}
	}
	
	static class Inner2{      //静态内部类，相当于一个外部类
		void show2(){ //内部类中的非静态成员
			System.out.println("show2..."+num);
		}
		static void show3(){  //内部类中的静态成员
			System.out.println("show3..."+num);
		}
	}
	
	public void method(){   //用来创建内部类对象
		Inner in=new Inner();
		in.show();
	}
}




public class InnerClassDemo {

	public static void main(String[] args) {
//		Outer out=new Outer();
//		out.method();

		
//=============非静态，非私有的内部类访问方式=====================================		
		//如果内部类权限是非私有的。就可以在外部其他程序中的被访问到。
		//通过创建外部类对象来完成
//		Outer.Inner in=new Outer().new Inner();  //类名是Outer.Inner
//		in.show();
		
//=============静态的，非私有的内部类访问方式1:访问非静态成员====================================		
//		Outer.Inner2 in=new Outer.Inner2();
//		in.show2();
		
//=============静态的，非私有的内部类访问方式2：访问静态成员====================================			
		Outer.Inner2.show3();
	
	
	
	
	
	}

}
