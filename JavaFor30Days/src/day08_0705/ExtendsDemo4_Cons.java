package day08_0705;
//day08-32-继承-子类的实例化过程，33-注意事项

/*
 子父类中构造函数的特点。
 就会发现，创建子类对象时，Fu中的空参数构造函数也运行了？
 
 因为子类中所有的构造函数的第一行默认都有一个隐式的super();语句
 
 调用本类中的构造函数用this(实参列表）语句。调用父类中的构造函数用super(实参列表）
 
 为什么子类对象初始化都要访问父类中的构造函数呢？
	因为子类继承了父类中的内容，所以创建对象时必须要先看父类是如何对内容进行初始化的
	
	这就是子类的实例化过程     object
	
注意：
	当父类中没有空参数构造函数时，子类需要通过显式定义super语句指定要访问的父类中的构造函数。
 	
 	用来调用父类构造函数的super语句在子类构造函数中必须定义在第一行，因为父类的初始化要先完成。
 	
问题：
	1.this和super用于调用构造函数，可以同时存在吗？
		不可以，因为它们只能定义在第一行
	
	2.为什么需要定义在第一行？
		因为初始化动作要先执行。
 */

class Fu2{
	int num;
	Fu2(){
		num=4;
		System.out.println("fu2 run");
	}
	Fu2(int x){
		System.out.println("fu2 run.."+x);
	}
}
class Zi2 extends Fu2{  //单继承，继承Fu2,但能用Object里的东西（多层继承）
	Zi2(){
		                                                             //super(4);   //隐式爆炸，这里用显式super指定
		this(5);     
		System.out.println("zi22 run");
	}
	Zi2(int x){
		super(); //隐式
		System.out.println("zi2 run.."+x);
	}
}


public class ExtendsDemo4_Cons {

	public static void main(String[] args) {
		Zi2 z=new Zi2();
		

	}

}
