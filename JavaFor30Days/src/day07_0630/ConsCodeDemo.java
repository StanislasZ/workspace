package day07_0630;
//day07-16-构造代码块，对象的初始化流程

class Person4{
	private int age=8;
	{  //定义在类中的非静态的代码块。给所有对象进行初始化的。
		
		//构造函数只给对应的对象初始化！！！
		System.out.println("Constructor code run"+age);   //8已经存在
		cry();   //每个对象要哇哇，就把cry写到这里
	}
	
	Person4(){
		System.out.println("person run");	
		//cry();
	}
	Person4(int age){
		this.age=age;
		System.out.println("Person(age) run");
		//cry();
	}
	
	 void cry(){
		System.out.println("哇哇");
	}
}
/*
 创建一个对象的流程:
	1.加载指定的字节码文件进内存。
	2.通过new在堆内存中开辟空间。分配首地址值
	3.对对象中的属性进行默认初始化。
	4.调用与之对应的构造函数。构造函数压栈
	5.构造函数中执行隐式的语句super()访问父类中的构造函数
	6.对属性进行初始化
	7.调用类中的构造代码块
	8.执行构造函数中自定义的初始化代码
	9.初始化完毕，将地址赋值给指定的引用。
 */

public class ConsCodeDemo {

	public static void main(String[] args) {
		Person4 p1=new Person4();
		Person4 p2=new Person4(4);
		
		int x=3;
		{ //局部代码块 。可以控制局部变量的生命周期
			System.out.println("hehe");
		}
		System.out.println("x="+x);
		
	}

}
