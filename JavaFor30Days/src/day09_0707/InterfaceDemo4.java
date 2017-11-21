package day09_0707;
//day09-46-接口多继承&没有抽象方法的抽象类
/*
 类与类之间   继承关系   is a
 
 类与接口之间   实现关系   like a
 
 接口与接口之间是什么关系呢？     继承
 */
/*
interface Inter1{
	void show1();
}
interface InterA{
	void showA();
}
interface Inter2 extends Inter1,InterA{
	void show2();
}

class Demo implements Inter2{
	public void show1(){}
	public void show2(){}
	public void showA(){}
}
*/

interface Inter1{
	void show1();
	void show2();
	void show3();
	void show4();
	
}
//DemoA需要使用接口中的部分方法。比如使用show1()
class DemoA implements Inter1{
	public void show1(){
		System.out.println("Demoa show1");
	}
	public void show2(){}
	public void show3(){}
	public void show4(){}
}
//问题：只需要部分功能，但是为了实例化，必须要全部覆盖。代码复用性很差。

//为了方便创建Inter接口的子类对象。可以用一个类先把接口中的所有方法空实现。

abstract class Demo1 implements Inter1{   //没有抽象方法的抽象类，方便创建接口的对象
	public void show1(){}
	public void show2(){}
	public void show3(){}
	public void show4(){}             //空实现
}
class DemoB extends Demo1{       //比上面的DemoA方便了很多
	public void show3(){
		System.out.println("demoB show3");
	}
}



public class InterfaceDemo4 {
	public static void main(String[] args) {
		DemoA a=new DemoA();
		a.show1();
	}

}
