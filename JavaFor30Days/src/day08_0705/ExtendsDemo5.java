package day08_0705;
//day08-34-子类的实例化过程练习
/*
 父类Person中属性：name,age 一初始化就必须有姓名和年龄
 			行为：setXxx  getXxx
 			
 子类有：Student  Worker  他们初始化时也要有姓名和年龄
 */
//进行了代码的复用。
class Person1{
	private String name;
	private int age;
	Person1(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
}
class Student1 extends Person1{
	
	Student1(String name,int age){
		super(name,age); //父类没有空参构造器，这里要显式调用
	}
	void study(){
		System.out.println("student study");
	}
	
}
class Worker1 extends Person1{
	private String name;
	private int age;
	Worker1(String name,int age){
		super(name,age);
	}
	void work(){
		System.out.println("worker work");
	}
}

public class ExtendsDemo5 {
	public static void main(String[] args){
		new Student1("li",20).study();
	}
}
