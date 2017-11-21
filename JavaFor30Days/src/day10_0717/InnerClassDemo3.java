package day10_0717;   //63-匿名内部类（继承）

/*
 匿名内部类：简化书写的内部类。
 
 	前提：
 		内部类需要继承或者实现外部的类或接口。
 */

abstract class Demo2{
	abstract void show();
}

class Outer2{
	private int num=4;
	/*
	class Inner2 extends Demo2{
		//复写
		public void show(){
			System.out.println("show.."+num);
		}
	}
	*/
	
	public void method(){
		//new Inner2().show();
		
		new Demo2(){     //匿名内部类，看成一个子类对象
			//覆盖Demo2中的抽象方法
			public void show(){
				System.out.println("show..."+num);
			}
		}.show();     //这个子类对象有点胖
	}
	
}



public class InnerClassDemo3 {
	public static void main(String[] args) {
		
		new Outer2().method();

	}

}
