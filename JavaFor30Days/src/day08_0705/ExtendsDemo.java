package day08_0705;
//day08-23��24,25,26-�̳�

/*
 �̳У�
 	1.����˴���ĸ����ԡ�
 	2.��������֮������˹�ϵ����Ҫ����Ϊ����������**��̬**�ṩ��ǰ��
 	
 Java֧�ֵ��̳С���ֱ��֧�ֶ�̳�
 
 ���̳У�һ����ֻ����һ������
 
 ��̳У�һ��������ж�����ࡣJava����ֱ��֧�֡�
 ���ƣ�����������߱�����Ĺ��ܡ�
 �׶ˣ��������õĲ�ȷ���ԣ���Ϊ���������岻ͬ��java��������˸�����

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
new Zi().show();���ֵ��õĲ�ȷ���ԡ�

���μ̳У�

ʲôʱ����̳У�

������֮�������������is a����ϵʱ������ͨ���̳������������ϵ��
xxx��yyy�е�һ�֡�xxx extends yyy��

class Demo1{
	void method1(){}
	
	void method2(){}
	
class Demo2 extends Demo1{    //Demo2�п��Ի�ȡ��Demo1�е�method1,����Ӧ�þ߱�method2�������ڼ̳�

    //void method1(){}
     
     void method3(){}
}
����Demo1��Demo2�߱����ԡ���ȡ
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

ϸ�ڣ����ڸ�����˽�еĲ��֡�
����������޷�ֱ�ӷ��ʵġ�

 */




//��ѧ���͹��˵Ĺ���������ϳ�ȡ��һ�����Ե������С���������мȰ���ѧ����Ҳ��������
class Person{   //���࣬���࣬����
	String name;  //˽�еĻ�������Ȩ�޽���
	int age;
	
}


//����ѧ��,����:���������䣬��Ϊ��ѧϰ����Student��Person������ϵ��������Studentʹ��Person�й��Ե�����
//ͨ��һ���ؼ��� extends�̳С�
class Student extends Person{               //Person�Ǹ���
	//�����ٶ������֣������ˡ�
	void study(){
		System.out.println("good good");
	}
	
}
//�������ˡ����ԣ�����������   ��Ϊ������
class worker extends Person{
	//�����ٶ������֣������ˡ�
	void work(){
		System.out.println("hard");
	}
}



public class ExtendsDemo {
	public static void main(String[] args) {
		Student s=new Student();
		s.name="С��";
		s.age=14;
		s.study();

	}

}
