package day08_0705;
//day08-34-�����ʵ����������ϰ
/*
 ����Person�����ԣ�name,age һ��ʼ���ͱ���������������
 			��Ϊ��setXxx  getXxx
 			
 �����У�Student  Worker  ���ǳ�ʼ��ʱҲҪ������������
 */
//�����˴���ĸ��á�
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
		super(name,age); //����û�пղι�����������Ҫ��ʽ����
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
