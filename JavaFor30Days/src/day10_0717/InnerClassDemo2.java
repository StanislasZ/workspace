package day10_0717;   //63-内部类细节 

/*
 为什么内部类就可以直接访问外部类中的成员。
 	因为内部类持有了外部的引用。外部类名.this
 */

/*
class Outer1{
	int num=2;
	
	class Inner1{
		int num=3;
		void show(){
			int num=4;
			System.out.println("show.."+num);
			System.out.println("show this num="+this.num);
			System.out.println("show Inner1 this num="+Inner1.this.num);   //和上一句相同
			System.out.println("show Outer1 this num="+Outer1.this.num);
		}
	}
	
	public void method(){
		new Inner1().show();
	}
}
*/

//将内部类定义到了局部位置上。
class Outer1{
	private int num=4;
	
	Object obj;
	
	public void method(){
		/*final*/ int x=5;
		class Inner1 extends Object{    //Inner本身继承Object
			//覆盖Object类中的toString方法
			public String toString(){
				System.out.println("show.."+num);
				System.out.println("show.."+x);
				return "Inner...abc";
			}
		}
		//创建内部类对象
		Inner1 in=new Inner1();
		//将内部类对象的地址赋值给obj
		obj=in;
		
	}
	
	public void function(){
		//打印obj指向的对象的字符串表现形式
		System.out.println(obj.toString());
	}
}




public class InnerClassDemo2 {
	public static void main(String[] args) {
		//new Outer1().method();

		Outer1 o=new Outer1();
		o.method();
		o.function();
		
	}

}
