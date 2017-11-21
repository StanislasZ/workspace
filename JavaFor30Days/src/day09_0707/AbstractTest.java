package day09_0707;
//day09-41-抽象类练习
/*
需求：公司中程序员有姓名，工号，薪水，工作内容。
项目经理除了有姓名，工号，薪水，还有奖金，工作内容。
对给出需求进行数据建模。

分析：
在这个问题领域中，先找出涉及的对象。通过名词提炼法。
	程序员：
		属性：姓名，工号，薪水、
		行为：工作。
	经理：
		属性：姓名，工号，薪水，奖金。
		行为：工作。

程序员和经理不存在着直接继承关系，但是程序员和经理却具有共性内容。可以进行抽取。因为他们都是公司的雇员 

可以将程序员和经理进行抽取.建立体系。
两者的共性类型是什么？  雇员

	雇员：
	属性：姓名，工号，薪水
	行为：工作（抽象）
*/

abstract class Employee{         //雇员
	private String name;
	private String id;
	private double pay;
	
	Employee(String name,String id,double pay){
		this.name=name;
		this.id=id;
		this.pay=pay;
	}
	
	public abstract void work();	
}

class Programmer extends Employee{    //程序员
	Programmer(String name,String id,double pay){
		super(name,id,pay);
	}
	public void work(){
		System.out.println("code");
	}
}

class Manager extends Employee{     //经理
	private double bonus;
	Manager(String name,String id,double pay,double bonus){
		super(name,id,pay);    //super必须放第一行
		this.bonus=bonus;
	}
	public void work(){
		System.out.println("manage");
	}
}





public class AbstractTest {
	public static void main(String[] args) {
		

	}

}
