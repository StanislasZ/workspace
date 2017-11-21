package day08_0705;
//day08-23，24,25,26-继承

/*
 继承：
 	1.提高了代码的复用性。
 	2.让类与类之间产生了关系（重要）。为第三个特征**多态**提供了前提
 	
 Java支持单继承。不直接支持多继承
 
 单继承：一个类只能有一个父类
 
 多继承：一个类可以有多个父类。Java并不直接支持。
 优势：可以让子类具备更多的功能。
 弊端：产生调用的不确定性，因为方法的主体不同。java对其进行了改良。

class Fu1{
	void show(){
		s.o.p("fu1 show");
	}
}
class Fu2{
	void show(){
		s.o.p("fu2 show");
	}
} 
class Zi extends Fu1,Fu2{
}
new Zi().show();出现调用的不确定性。

多层次继承：

什么时候定义继承？

当事物之间存在着所属（is a）关系时，可以通过继承来体现这个关系。
xxx是yyy中的一种。xxx extends yyy。

class Demo1{
	void method1(){}
	
	void method2(){}
	
class Demo2 extends Demo1{    //Demo2中可以获取到Demo1中的method1,但不应该具备method2，不存在继承

    //void method1(){}
     
     void method3(){}
}
但是Demo1，Demo2具备共性。抽取
class Demo{
	void method1(){}
}
class Demo1 extends Demo{
	void method2(){}
}
class Demo2 extends Demo{
	void method3(){}
}
new Demo1().method1();
new Demo1().method2();

细节：对于父类中私有的部分。
子类对象是无法直接访问的。

 */




//将学生和工人的共享代码向上抽取到一个共性的类型中。这个类型中既包括学生，也包括工人
class Person{   //父类，超类，基类
	String name;  //私有的话，访问权限降低
	int age;
	
}


//描述学生,属性:姓名，年龄，行为：学习。让Student和Person产生关系，就能让Student使用Person中共性的内容
//通过一个关键字 extends继承。
class Student extends Person{               //Person是父类
	//不用再定义名字，年龄了。
	void study(){
		System.out.println("good good");
	}
	
}
//描述工人。属性：姓名，年龄   行为：工作
class worker extends Person{
	//不用再定义名字，年龄了。
	void work(){
		System.out.println("hard");
	}
}



public class ExtendsDemo {
	public static void main(String[] args) {
		Student s=new Student();
		s.name="小明";
		s.age=14;
		s.study();

	}

}
