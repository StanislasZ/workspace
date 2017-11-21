package day09_0707;
//day09-42-接口概述，43-接口特点

/*
 抽象类中所有的方法都是抽象的。
 这时，可以把抽象类用另一种形式来表示。接口
 
 初期可以理解为接口是特殊的抽象类。
 */
/*
abstract class AbsDemo{
	abstract void show1();
	abstract void show2();
}
*/

//定义接口
interface Inter{
	public static final int NUM=4;  //全局常量，类名调用
	public abstract void show1();
	public abstract void show2();
}
//接口中的成员和class定义不同之处：
//接口中常见的成员有两种： 1.全局常量（public final）  2.抽象方法
//而且都有固定的修饰符。共性：成员都是public修饰的。

/*	
接口的特点：
	1.接口不可以实例化
	2.需要覆盖了接口中的所有的抽象方法的子类，才可以实例化。
		否则，该子类还是一个抽象类。
	3.接口是用来被实现的。
*/

class Demo implements Inter{
	public void show1(){   //有方法主体，没内容
		
	}
	public void show2(){
		
	}
}






public class InterfaceDemo {
	public static void main(String[] args) {
		Demo d=new Demo();   //覆盖完方法才能new
		

	}

}
